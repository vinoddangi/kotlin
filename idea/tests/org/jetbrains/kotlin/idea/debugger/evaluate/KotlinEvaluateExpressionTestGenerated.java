/*
 * Copyright 2010-2015 JetBrains s.r.o.
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

package org.jetbrains.kotlin.idea.debugger.evaluate;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.InnerTestClasses;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.JetTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@InnerTestClasses({
        KotlinEvaluateExpressionTestGenerated.SingleBreakpoint.class,
        KotlinEvaluateExpressionTestGenerated.MultipleBreakpoints.class})
@RunWith(JUnit3RunnerWithInners.class)
public class KotlinEvaluateExpressionTestGenerated extends AbstractKotlinEvaluateExpressionTest {
    @TestMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint")
    @TestDataPath("$PROJECT_ROOT")
    @InnerTestClasses({
            SingleBreakpoint.CompilingEvaluator.class,
            SingleBreakpoint.ExtraVariables.class,
            SingleBreakpoint.Frame.class,
            SingleBreakpoint.Lambdas.class,
            SingleBreakpoint.Renderer.class})
    @RunWith(JUnit3RunnerWithInners.class)
    public static class SingleBreakpoint extends AbstractKotlinEvaluateExpressionTest {
        @TestMetadata("abstractFunCall.kt")
        public void testAbstractFunCall() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/abstractFunCall.kt");
            doSingleBreakpointTest(fileName);
        }

        public void testAllFilesPresentInSingleBreakpoint() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("anonymousObjects.kt")
        public void testAnonymousObjects() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/anonymousObjects.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("arrays.kt")
        public void testArrays() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/arrays.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("callableBug.kt")
        public void testCallableBug() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/callableBug.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("classFromAnotherPackage.kt")
        public void testClassFromAnotherPackage() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/classFromAnotherPackage.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("classObjectVal.kt")
        public void testClassObjectVal() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/classObjectVal.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("collections.kt")
        public void testCollections() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/collections.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("dependentOnFile.kt")
        public void testDependentOnFile() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/dependentOnFile.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("doubles.kt")
        public void testDoubles() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/doubles.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("enums.kt")
        public void testEnums() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/enums.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("errors.kt")
        public void testErrors() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/errors.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("extractLocalVariables.kt")
        public void testExtractLocalVariables() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extractLocalVariables.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("extractThis.kt")
        public void testExtractThis() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extractThis.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("extractThisInTrait.kt")
        public void testExtractThisInTrait() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extractThisInTrait.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("extractVariablesFromCall.kt")
        public void testExtractVariablesFromCall() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extractVariablesFromCall.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("funFromSuperClass.kt")
        public void testFunFromSuperClass() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/funFromSuperClass.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("imports.kt")
        public void testImports() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/imports.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("insertInBlock.kt")
        public void testInsertInBlock() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/insertInBlock.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("kt5554OnlyIntsShouldBeCoerced.kt")
        public void testKt5554OnlyIntsShouldBeCoerced() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/kt5554OnlyIntsShouldBeCoerced.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("localVariables.kt")
        public void testLocalVariables() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/localVariables.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("methodWithBreakpoint.kt")
        public void testMethodWithBreakpoint() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/methodWithBreakpoint.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("multilineExpressionAtBreakpoint.kt")
        public void testMultilineExpressionAtBreakpoint() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/multilineExpressionAtBreakpoint.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("onClassHeader.kt")
        public void testOnClassHeader() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/onClassHeader.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("onObjectHeader.kt")
        public void testOnObjectHeader() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/onObjectHeader.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("privateMember.kt")
        public void testPrivateMember() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/privateMember.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("protectedMember.kt")
        public void testProtectedMember() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/protectedMember.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("simple.kt")
        public void testSimple() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/simple.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("stdlib.kt")
        public void testStdlib() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/stdlib.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("unsafeCall.kt")
        public void testUnsafeCall() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/unsafeCall.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("vars.kt")
        public void testVars() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/vars.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata(".kt.kt")
        public void test_kt() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/.kt.kt");
            doSingleBreakpointTest(fileName);
        }

        @TestMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/compilingEvaluator")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class CompilingEvaluator extends AbstractKotlinEvaluateExpressionTest {
            public void testAllFilesPresentInCompilingEvaluator() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/compilingEvaluator"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("ceLambda.kt")
            public void testCeLambda() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/compilingEvaluator/ceLambda.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("ceLocalClass.kt")
            public void testCeLocalClass() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/compilingEvaluator/ceLocalClass.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("ceLocalClassMembers.kt")
            public void testCeLocalClassMembers() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/compilingEvaluator/ceLocalClassMembers.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("ceLocalClassWithSuperClass.kt")
            public void testCeLocalClassWithSuperClass() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/compilingEvaluator/ceLocalClassWithSuperClass.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("ceMembers.kt")
            public void testCeMembers() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/compilingEvaluator/ceMembers.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("ceObject.kt")
            public void testCeObject() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/compilingEvaluator/ceObject.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("ceSeveralLambdas.kt")
            public void testCeSeveralLambdas() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/compilingEvaluator/ceSeveralLambdas.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("ceSuperAccess.kt")
            public void testCeSuperAccess() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/compilingEvaluator/ceSuperAccess.kt");
                doSingleBreakpointTest(fileName);
            }
        }

        @TestMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extraVariables")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class ExtraVariables extends AbstractKotlinEvaluateExpressionTest {
            public void testAllFilesPresentInExtraVariables() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extraVariables"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("evBreakpointOnPropertyDeclaration.kt")
            public void testEvBreakpointOnPropertyDeclaration() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extraVariables/evBreakpointOnPropertyDeclaration.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("evDelegatedProperty.kt")
            public void testEvDelegatedProperty() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extraVariables/evDelegatedProperty.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("evDuplicateItems.kt")
            public void testEvDuplicateItems() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extraVariables/evDuplicateItems.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("evFinalProperty.kt")
            public void testEvFinalProperty() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extraVariables/evFinalProperty.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("evLineRange.kt")
            public void testEvLineRange() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extraVariables/evLineRange.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("evProperty.kt")
            public void testEvProperty() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extraVariables/evProperty.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("evPropertyRefExpr.kt")
            public void testEvPropertyRefExpr() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extraVariables/evPropertyRefExpr.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("evSkipAnonymousObject.kt")
            public void testEvSkipAnonymousObject() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extraVariables/evSkipAnonymousObject.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("evSkipLambda.kt")
            public void testEvSkipLambda() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extraVariables/evSkipLambda.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("evSkipLocalClass.kt")
            public void testEvSkipLocalClass() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/extraVariables/evSkipLocalClass.kt");
                doSingleBreakpointTest(fileName);
            }
        }

        @TestMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class Frame extends AbstractKotlinEvaluateExpressionTest {
            public void testAllFilesPresentInFrame() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("delegatedPropertyInClass.kt")
            public void testDelegatedPropertyInClass() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/delegatedPropertyInClass.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameAnonymousObject.kt")
            public void testFrameAnonymousObject() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameAnonymousObject.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameClassObject.kt")
            public void testFrameClassObject() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameClassObject.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameClosingBracket.kt")
            public void testFrameClosingBracket() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameClosingBracket.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameExtFunExtFun.kt")
            public void testFrameExtFunExtFun() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameExtFunExtFun.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameExtensionFun.kt")
            public void testFrameExtensionFun() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameExtensionFun.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameInnerClass.kt")
            public void testFrameInnerClass() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameInnerClass.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameInnerLambda.kt")
            public void testFrameInnerLambda() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameInnerLambda.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameLambda.kt")
            public void testFrameLambda() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameLambda.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameLambdaNotUsed.kt")
            public void testFrameLambdaNotUsed() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameLambdaNotUsed.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameLocalVariable.kt")
            public void testFrameLocalVariable() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameLocalVariable.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameObject.kt")
            public void testFrameObject() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameObject.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameSharedVar.kt")
            public void testFrameSharedVar() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameSharedVar.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameSharedVarLocalVar.kt")
            public void testFrameSharedVarLocalVar() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameSharedVarLocalVar.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameSimple.kt")
            public void testFrameSimple() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameSimple.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameThis0.kt")
            public void testFrameThis0() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameThis0.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameThis0Ext.kt")
            public void testFrameThis0Ext() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameThis0Ext.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("frameThis0This0.kt")
            public void testFrameThis0This0() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/frame/frameThis0This0.kt");
                doSingleBreakpointTest(fileName);
            }
        }

        @TestMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/lambdas")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class Lambdas extends AbstractKotlinEvaluateExpressionTest {
            public void testAllFilesPresentInLambdas() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/lambdas"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("inlineLambda.kt")
            public void testInlineLambda() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/lambdas/inlineLambda.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("lambdaOnSecondLine.kt")
            public void testLambdaOnSecondLine() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/lambdas/lambdaOnSecondLine.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("oneLineLambda.kt")
            public void testOneLineLambda() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/lambdas/oneLineLambda.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("twoLambdasOnOneLineFirst.kt")
            public void testTwoLambdasOnOneLineFirst() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/lambdas/twoLambdasOnOneLineFirst.kt");
                doSingleBreakpointTest(fileName);
            }

            @TestMetadata("twoLambdasOnOneLineSecond.kt")
            public void testTwoLambdasOnOneLineSecond() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/lambdas/twoLambdasOnOneLineSecond.kt");
                doSingleBreakpointTest(fileName);
            }
        }

        @TestMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/renderer")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class Renderer extends AbstractKotlinEvaluateExpressionTest {
            public void testAllFilesPresentInRenderer() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/renderer"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("toStringRenderer.kt")
            public void testToStringRenderer() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/singleBreakpoint/renderer/toStringRenderer.kt");
                doSingleBreakpointTest(fileName);
            }
        }
    }

    @TestMetadata("idea/testData/debugger/tinyApp/src/evaluate/multipleBreakpoints")
    @TestDataPath("$PROJECT_ROOT")
    @InnerTestClasses({
            MultipleBreakpoints.Library.class})
    @RunWith(JUnit3RunnerWithInners.class)
    public static class MultipleBreakpoints extends AbstractKotlinEvaluateExpressionTest {
        public void testAllFilesPresentInMultipleBreakpoints() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/debugger/tinyApp/src/evaluate/multipleBreakpoints"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("clearCache.kt")
        public void testClearCache() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/multipleBreakpoints/clearCache.kt");
            doMultipleBreakpointsTest(fileName);
        }

        @TestMetadata("exceptions.kt")
        public void testExceptions() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/multipleBreakpoints/exceptions.kt");
            doMultipleBreakpointsTest(fileName);
        }

        @TestMetadata("funFromOuterClassInLamdba.kt")
        public void testFunFromOuterClassInLamdba() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/multipleBreakpoints/funFromOuterClassInLamdba.kt");
            doMultipleBreakpointsTest(fileName);
        }

        @TestMetadata("whenEntry.kt")
        public void testWhenEntry() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/multipleBreakpoints/whenEntry.kt");
            doMultipleBreakpointsTest(fileName);
        }

        @TestMetadata("withoutBodyFunctions.kt")
        public void testWithoutBodyFunctions() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/multipleBreakpoints/withoutBodyFunctions.kt");
            doMultipleBreakpointsTest(fileName);
        }

        @TestMetadata("withoutBodyProperties.kt")
        public void testWithoutBodyProperties() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/multipleBreakpoints/withoutBodyProperties.kt");
            doMultipleBreakpointsTest(fileName);
        }

        @TestMetadata("withoutBodyTypeParameters.kt")
        public void testWithoutBodyTypeParameters() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/multipleBreakpoints/withoutBodyTypeParameters.kt");
            doMultipleBreakpointsTest(fileName);
        }

        @TestMetadata("idea/testData/debugger/tinyApp/src/evaluate/multipleBreakpoints/library")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class Library extends AbstractKotlinEvaluateExpressionTest {
            public void testAllFilesPresentInLibrary() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/debugger/tinyApp/src/evaluate/multipleBreakpoints/library"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("customLibClassName.kt")
            public void testCustomLibClassName() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/debugger/tinyApp/src/evaluate/multipleBreakpoints/library/customLibClassName.kt");
                doMultipleBreakpointsTest(fileName);
            }
        }
    }
}
