/*
 Copyright 2016 Goldman Sachs.
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */

package com.gs.fw.common.mithra.generator.databasetype;

public interface CommonDatabaseType
{
    String getSqlDataTypeForNullableBoolean();

    String getSqlDataTypeForBoolean();

    String getSqlDataTypeForTimestamp();

    String getSqlDataTypeForTime();

    String getSqlDataTypeForTinyInt();

    String getSqlDataTypeForVarBinary();

    String getSqlDataTypeForByte();

    String getSqlDataTypeForChar();

    String getSqlDataTypeForDateTime();

    String getSqlDataTypeForDouble();

    String getSqlDataTypeForFloat();

    String getSqlDataTypeForInt();

    String getSqlDataTypeForLong();

    String getSqlDataTypeForShortJava();

    String getSqlDataTypeForString();

    String getSqlDataTypeForBigDecimal();

    String getJavaTypeFromSql(String sql, Integer precision, Integer decimal);

}
