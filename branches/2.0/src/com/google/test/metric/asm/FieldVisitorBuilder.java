/*
 * Copyright 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.test.metric.asm;

import com.google.test.metric.JavaParser;
import com.google.test.metric.Type;
import com.google.test.metric.ast.AbstractSyntaxTree;
import com.google.test.metric.ast.ClassHandle;
import com.google.test.metric.ast.Language;

import org.objectweb.asm.Opcodes;

public class FieldVisitorBuilder extends NoopFieldVisitor {

  public FieldVisitorBuilder(JavaParser parser, AbstractSyntaxTree ast, ClassHandle classHandle, int access, String name,
      String desc, String signature, Object value) {
    boolean isStatic = (access & Opcodes.ACC_STATIC) == Opcodes.ACC_STATIC;
    boolean isPrivate = Visibility.valueOf(access) == Visibility.PRIVATE;
    boolean isFinal = (access & Opcodes.ACC_FINAL) == Opcodes.ACC_FINAL;
    Type type = Type.fromDesc(desc);
    ast.createField(Language.JAVA, classHandle, name, null, type, isFinal);
    //classHandle.addField(new FieldInfo(classHandle, name, type, isFinal,
    //    isStatic, isPrivate));
  }

}
