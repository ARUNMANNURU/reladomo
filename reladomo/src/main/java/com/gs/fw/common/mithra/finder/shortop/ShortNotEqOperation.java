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

package com.gs.fw.common.mithra.finder.shortop;

import com.gs.fw.common.mithra.attribute.ShortAttribute;
import com.gs.fw.common.mithra.extractor.Extractor;
import com.gs.fw.common.mithra.extractor.ShortExtractor;
import com.gs.fw.common.mithra.finder.AtomicNotEqualityOperation;
import com.gs.fw.common.mithra.finder.SqlParameterSetter;
import com.gs.fw.common.mithra.finder.SqlQuery;
import com.gs.fw.common.mithra.finder.paramop.OpWithShortParam;
import com.gs.fw.common.mithra.finder.paramop.OpWithShortParamExtractor;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShortNotEqOperation extends AtomicNotEqualityOperation implements SqlParameterSetter, OpWithShortParam
{
    private short parameter;

    public ShortNotEqOperation(ShortAttribute attribute, short parameter)
    {
        super(attribute);
        this.parameter = parameter;
    }

    @Override
    protected Extractor getStaticExtractor()
    {
        return OpWithShortParamExtractor.INSTANCE;
    }

    @Override
    protected boolean matchesWithoutDeleteCheck(Object o, Extractor extractor)
    {
        ShortExtractor shortAttribute = (ShortExtractor) extractor;
        if (shortAttribute.isAttributeNull(o)) return false;
        return shortAttribute.shortValueOf(o) != parameter;
    }

    public int setSqlParameters(PreparedStatement pstmt, int startIndex, SqlQuery query) throws SQLException
    {
        pstmt.setShort(startIndex, parameter);
        return 1;
    }

    public int hashCode()
    {
        return ~(this.getAttribute().hashCode() ^ this.parameter);
    }

    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj instanceof ShortNotEqOperation)
        {
            ShortNotEqOperation other = (ShortNotEqOperation) obj;
            return this.parameter == other.parameter && this.getAttribute().equals(other.getAttribute());
        }
        return false;
    }

    @Override
    public Object getParameterAsObject()
    {
        return Short.valueOf(this.parameter);
    }

    public short getParameter()
    {
        return parameter;
    }
}
