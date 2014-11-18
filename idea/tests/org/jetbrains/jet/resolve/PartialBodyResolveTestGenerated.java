/*
 * Copyright 2010-2014 JetBrains s.r.o.
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

package org.jetbrains.jet.resolve;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.jet.JUnit3RunnerWithInners;
import org.jetbrains.jet.JetTestUtils;
import org.jetbrains.jet.test.InnerTestClasses;
import org.jetbrains.jet.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.jet.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("idea/testData/resolve/partialBodyResolve")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class PartialBodyResolveTestGenerated extends AbstractPartialBodyResolveTest {
    public void testAllFilesPresentInPartialBodyResolve() throws Exception {
        JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/resolve/partialBodyResolve"), Pattern.compile("^(.+)\\.kt$"), true);
    }

    @TestMetadata("As.kt")
    public void testAs() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/As.kt");
        doTest(fileName);
    }

    @TestMetadata("BangBang.kt")
    public void testBangBang() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/BangBang.kt");
        doTest(fileName);
    }

    @TestMetadata("DeclarationsBefore.kt")
    public void testDeclarationsBefore() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/DeclarationsBefore.kt");
        doTest(fileName);
    }

    @TestMetadata("For.kt")
    public void testFor() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/For.kt");
        doTest(fileName);
    }

    @TestMetadata("IfBranchesAutoCasts.kt")
    public void testIfBranchesAutoCasts() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/IfBranchesAutoCasts.kt");
        doTest(fileName);
    }

    @TestMetadata("IfBranchesAutoCasts2.kt")
    public void testIfBranchesAutoCasts2() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/IfBranchesAutoCasts2.kt");
        doTest(fileName);
    }

    @TestMetadata("IfBranchesSmartCast.kt")
    public void testIfBranchesSmartCast() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/IfBranchesSmartCast.kt");
        doTest(fileName);
    }

    @TestMetadata("IfEqAutoCast.kt")
    public void testIfEqAutoCast() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/IfEqAutoCast.kt");
        doTest(fileName);
    }

    @TestMetadata("IfNotIsReturn.kt")
    public void testIfNotIsReturn() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/IfNotIsReturn.kt");
        doTest(fileName);
    }

    @TestMetadata("IfNotIsReturn2.kt")
    public void testIfNotIsReturn2() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/IfNotIsReturn2.kt");
        doTest(fileName);
    }

    @TestMetadata("IfNotIsThrow.kt")
    public void testIfNotIsThrow() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/IfNotIsThrow.kt");
        doTest(fileName);
    }

    @TestMetadata("IfNotNullElseReturn.kt")
    public void testIfNotNullElseReturn() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/IfNotNullElseReturn.kt");
        doTest(fileName);
    }

    @TestMetadata("IfNullBreak.kt")
    public void testIfNullBreak() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/IfNullBreak.kt");
        doTest(fileName);
    }

    @TestMetadata("IfNullContinue.kt")
    public void testIfNullContinue() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/IfNullContinue.kt");
        doTest(fileName);
    }

    @TestMetadata("IfNullPrint.kt")
    public void testIfNullPrint() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/IfNullPrint.kt");
        doTest(fileName);
    }

    @TestMetadata("IfNullReturn.kt")
    public void testIfNullReturn() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/IfNullReturn.kt");
        doTest(fileName);
    }

    @TestMetadata("IfReturn.kt")
    public void testIfReturn() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/IfReturn.kt");
        doTest(fileName);
    }

    @TestMetadata("InIfExpressionElse.kt")
    public void testInIfExpressionElse() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/InIfExpressionElse.kt");
        doTest(fileName);
    }

    @TestMetadata("Lambda.kt")
    public void testLambda() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/Lambda.kt");
        doTest(fileName);
    }

    @TestMetadata("Simple.kt")
    public void testSimple() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/partialBodyResolve/Simple.kt");
        doTest(fileName);
    }
}