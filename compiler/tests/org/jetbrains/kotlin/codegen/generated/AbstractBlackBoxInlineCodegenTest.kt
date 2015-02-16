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

package org.jetbrains.kotlin.codegen.generated

import org.jetbrains.kotlin.codegen.InlineTestUtil
import org.jetbrains.kotlin.utils.*

import java.io.File
import java.util.ArrayList
import org.jetbrains.kotlin.codegen.state.GenerationState
import com.google.common.collect.Lists
import org.jetbrains.kotlin.load.kotlin.PackageClassUtils
import org.jetbrains.kotlin.name.FqName
import com.intellij.openapi.util.io.FileUtil
import org.jetbrains.kotlin.psi.JetFile
import com.intellij.openapi.util.text.StringUtil
import java.util
import org.jetbrains.kotlin.test.InTextDirectivesUtils
import org.jetbrains.org.objectweb.asm.ClassVisitor
import com.intellij.openapi.util.Ref
import org.jetbrains.org.objectweb.asm.ClassReader
import org.jetbrains.org.objectweb.asm.Opcodes
import kotlin.test.assertEquals
import com.intellij.testFramework.UsefulTestCase
import org.junit.Assert

public abstract class AbstractBlackBoxInlineCodegenTest : AbstractBlackBoxCodegenTest() {

    public fun doTestMultiFileWithInlineCheck(firstFileName: String) {
        var firstFileName = firstFileName
        firstFileName = relativePath(File(firstFileName))
        val inputFiles = ArrayList<String>(2)
        inputFiles.add(firstFileName)
        inputFiles.add(firstFileName.substring(0, firstFileName.length() - "1.kt".length()) + "2.kt")

        doTestMultiFile(inputFiles)
        try {
            InlineTestUtil.checkNoCallsToInline(initializedClassLoader.getAllGeneratedFiles())
        }
        catch (e: Throwable) {
            System.out.println(generateToText())
            throw rethrow(e)
        }
        checkSMAP()
    }

    private fun extractSMAPFromClasses(): List<SMAPAndFile> {
        val factory = generateClassesInFile()
        val result = arrayListOf<SMAPAndFile>()
        for (outputFile in factory.asList()) {
            if (PackageClassUtils.isPackageClassFqName(FqName(FileUtil.getNameWithoutExtension(outputFile.relativePath).replace('/', '.')))) {
                // Don't test line numbers in *Package facade classes
                continue
            }
            val debugInfo = Ref<String?>()
            ClassReader(outputFile.asByteArray()).accept(object: ClassVisitor(Opcodes.ASM5) {
                override fun visitSource(source: String?, debug: String?) {
                    debugInfo.set(debug)
                }
            }, 0)
            val sourceFiles = outputFile.sourceFiles
            assert(sourceFiles.size() == 1, "Wrong number of source files ${sourceFiles.size()}")
            result.add(SMAPAndFile(debugInfo.get(), sourceFiles.first().getCanonicalPath()))
        }

        return result
    }

    private fun extractSmapFromSource(file: JetFile): String? {
        val fileContent = file.getText();
        val smapPrefix = "//SMAP"
        if (InTextDirectivesUtils.isDirectiveDefined(fileContent, smapPrefix)) {
            InTextDirectivesUtils.findLinesWithPrefixesRemoved(fileContent, smapPrefix)
            var smapData = fileContent.substring(fileContent.indexOf(smapPrefix))
            smapData = smapData.replaceAll("//","").trim()
            if (smapData.startsWith("SMAP ABSENT")) {
                return null
            }
            return smapData
        }
        return null;
    }

    fun checkSMAP() {
        val sourceData = arrayListOf<SMAPAndFile>()
        val mutableList = myFiles.getPsiFiles()
        for (file: JetFile in mutableList) {
            val smap = extractSmapFromSource(file)
            if (smap != null) {
                sourceData.add(SMAPAndFile(smap, file.getVirtualFile().getCanonicalPath()!!))
            }
        }
        val compiledData = extractSMAPFromClasses().toMap { it.sourceFile }

        for (source in sourceData) {
            val data = compiledData[source.sourceFile]
            Assert.assertEquals("Smap data differs for ${source.smap}", source.smap, data?.smap?.trim())
        }
    }

    class SMAPAndFile(val smap: String?, val sourceFile: String)
}
