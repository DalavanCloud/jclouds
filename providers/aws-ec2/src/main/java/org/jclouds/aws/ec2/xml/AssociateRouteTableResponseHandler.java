/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.aws.ec2.xml;

import org.jclouds.http.functions.ParseSax;

public class AssociateRouteTableResponseHandler extends ParseSax.HandlerWithResult<String> {

   private StringBuilder currentText = new StringBuilder();
   private String value;

   public String getResult() {
      return value;
   }

   public void endElement(String uri, String name, String qName) {
      if (qName.equalsIgnoreCase("associationId")) {
         this.value = currentText.toString().trim();
      }
      currentText.setLength(0);
   }

   public void characters(char[] ch, int start, int length) {
      currentText.append(ch, start, length);
   }
}
