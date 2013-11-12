/*
 * Copyright 2010-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.plugin;

import com.google.common.base.Predicate;
import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.lang.java.JavaDocumentationProvider;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.impl.compiled.ClsClassImpl;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jet.kdoc.lexer.KDocTokens;
import org.jetbrains.jet.kdoc.psi.api.KDoc;
import org.jetbrains.jet.lang.descriptors.CallableDescriptor;
import org.jetbrains.jet.lang.descriptors.CallableMemberDescriptor;
import org.jetbrains.jet.lang.descriptors.DeclarationDescriptor;
import org.jetbrains.jet.lang.psi.*;
import org.jetbrains.jet.lang.resolve.BindingContext;
import org.jetbrains.jet.lang.resolve.BindingContextUtils;
import org.jetbrains.jet.plugin.libraries.DecompiledUtils;
import org.jetbrains.jet.plugin.project.AnalyzerFacadeWithCache;
import org.jetbrains.jet.plugin.references.BuiltInsReferenceResolver;
import org.jetbrains.jet.renderer.DescriptorRenderer;

import java.util.Collection;
import java.util.List;

public class JetQuickDocumentationProvider extends AbstractDocumentationProvider {
    private static final Predicate<PsiElement> SKIP_WHITESPACE_AND_EMPTY_NAMESPACE = new Predicate<PsiElement>() {
        @Override
        public boolean apply(PsiElement input) {
            // Skip empty namespace because there can be comments before it
            // Skip whitespaces
            return (input instanceof JetNamespaceHeader && input.getChildren().length == 0) || input instanceof PsiWhiteSpace;
        }
    };

    private static String getText(PsiElement element, PsiElement originalElement, boolean mergeKotlinAndJava) {
        JetReferenceExpression ref = PsiTreeUtil.getParentOfType(originalElement, JetReferenceExpression.class, false);

        PsiElement declarationPsiElement = PsiTreeUtil.getParentOfType(originalElement, JetDeclaration.class);
        if (ref != null || declarationPsiElement != null) {
            BindingContext bindingContext = AnalyzerFacadeWithCache.analyzeFileWithCache((JetFile) originalElement.getContainingFile())
                    .getBindingContext();

            if (ref != null) {
                DeclarationDescriptor declarationDescriptor = bindingContext.get(BindingContext.REFERENCE_TARGET, ref);
                if (declarationDescriptor != null) {
                    return render(declarationDescriptor, bindingContext, element, originalElement, mergeKotlinAndJava);
                }
                if (declarationPsiElement != null) {
                    declarationPsiElement = BindingContextUtils.resolveToDeclarationPsiElement(bindingContext, ref);
                }
            }

            if (declarationPsiElement != null) {
                DeclarationDescriptor declarationDescriptor = bindingContext.get(BindingContext.DECLARATION_TO_DESCRIPTOR,
                                                                                 declarationPsiElement);

                if (declarationDescriptor != null) {
                    return render(declarationDescriptor, bindingContext, element, originalElement, mergeKotlinAndJava);
                }
            }
            return "Unresolved";
        }
        return null;
    }

    private static String render(
            @NotNull DeclarationDescriptor declarationDescriptor, @NotNull BindingContext bindingContext,
            PsiElement element, PsiElement originalElement, boolean mergeKotlinAndJava) {
        String renderedDecl = DescriptorRenderer.HTML.render(declarationDescriptor);
        //TODO: deal with situation when declarationDescriptor is fake override with several overridden descriptors
        if (isKotlinDeclaration(declarationDescriptor, bindingContext, element)) {
            KDoc comment = findElementKDoc(element);
            if (comment != null) {
                renderedDecl = renderedDecl + "<br/>" + kDocToHtml(comment);
            }

            return renderedDecl;
        }
        else if (mergeKotlinAndJava) {
            String originalInfo = new JavaDocumentationProvider().getQuickNavigateInfo(element, originalElement);
            if (originalInfo != null) {
                return renderedDecl + "<br/>Java declaration:<br/>" + originalInfo;
            }
            return renderedDecl;
        }
        return null;
    }

    private static boolean isKotlinDeclaration(
            DeclarationDescriptor descriptor,
            BindingContext bindingContext,
            PsiElement element
    ) {
        if (JetLanguage.INSTANCE == element.getLanguage()) return true;

        List<PsiElement> declarations = BindingContextUtils.descriptorToDeclarations(bindingContext, descriptor);
        if (declarations.isEmpty()) {
            BuiltInsReferenceResolver libraryReferenceResolver = element.getProject().getComponent(BuiltInsReferenceResolver.class);
            Collection<PsiElement> elements = libraryReferenceResolver.resolveBuiltInSymbol(descriptor);
            return !elements.isEmpty();
        }

        if (declarations.size() == 1) {
            PsiElement declaration = declarations.iterator().next();
            ClsClassImpl clsClass = PsiTreeUtil.getParentOfType(declaration, ClsClassImpl.class);
            if (clsClass == null) return false;
            VirtualFile file = clsClass.getContainingFile().getVirtualFile();
            return file != null && DecompiledUtils.isKotlinCompiledFile(file);
        }

        assert descriptor instanceof CallableMemberDescriptor
               && ((CallableMemberDescriptor) descriptor).getKind() != CallableMemberDescriptor.Kind.DECLARATION
                : "Callable descriptor with no declaration expected, but was: " + descriptor;
        return false;
    }

    @Override
    public String getQuickNavigateInfo(PsiElement element, PsiElement originalElement) {
        return getText(element, originalElement, true);
    }

    @Override
    public String generateDoc(PsiElement element, PsiElement originalElement) {
        return getText(element, originalElement, false);
    }

    private static String getKDocContent(@NotNull KDoc kDoc) {
        StringBuilder builder = new StringBuilder();

        boolean contentStarted = false;
        boolean afterAsterisk = false;

        for (PsiElement element : kDoc.getChildren()) {
            IElementType type = element.getNode().getElementType();

            if (KDocTokens.CONTENT_TOKENS.contains(type)) {
                contentStarted = true;
                builder.append(afterAsterisk ? StringUtil.trimLeading(element.getText()) : element.getText());
                afterAsterisk = false;
            }

            if (type == KDocTokens.LEADING_ASTERISK || type == KDocTokens.START) {
                afterAsterisk = true;
            }

            if (contentStarted && element instanceof PsiWhiteSpace) {
                builder.append(StringUtil.repeat("\n", StringUtil.countNewLines(element.getText())));
            }
        }

        return builder.toString();
    }

    @Nullable
    private static KDoc findElementKDoc(@NotNull PsiElement element) {
        PsiElement navigateElement = (element instanceof JetElement) ? element : element.getNavigationElement();
        PsiElement comment = JetPsiUtil.skipSiblingsBackwardByPredicate(navigateElement, SKIP_WHITESPACE_AND_EMPTY_NAMESPACE);

        return comment instanceof KDoc ? (KDoc) comment : null;
    }

    private static String kDocToHtml(@NotNull KDoc comment) {
        // TODO: Parse and show markdown comments as html
        String content = getKDocContent(comment);
        String htmlContent = StringUtil.replace(content, "\n", "<br/>")
                .replaceAll("(@param)\\s+(\\w+)", "@param - <i>$2</i>")
                .replaceAll("(@\\w+)", "<b>$1</b>");

        return "<p>" + htmlContent + "</p>";
    }
}
