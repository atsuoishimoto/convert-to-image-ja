/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pdfbox.pdmodel.graphics;

import org.pdfbox.cos.COSArray;
import org.pdfbox.cos.COSBase;
import org.pdfbox.cos.COSDictionary;
import org.pdfbox.cos.COSFloat;
import org.pdfbox.cos.COSNumber;

import org.pdfbox.pdmodel.common.COSObjectable;

import org.pdfbox.pdmodel.font.PDFont;
import org.pdfbox.pdmodel.font.PDFontFactory;

import java.io.IOException;

/**
 * This class represents a font setting used for the graphics state.  A font setting is a font and a
 * font size.  Maybe there is a better name for this?
 *
 * @author <a href="mailto:ben@benlitchfield.com">Ben Litchfield</a>
 * @version $Revision: 1.4 $
 */
public class PDFontSetting implements COSObjectable
{
    private COSArray fontSetting = null;

    /**
     * Creates a blank font setting, font will be null, size will be 1.
     */
    public PDFontSetting()
    {
        fontSetting = new COSArray();
        fontSetting.add( null );
        fontSetting.add( new COSFloat( 1 ) );
    }

    /**
     * Constructs a font setting from an existing array.
     *
     * @param fs The new font setting value.
     */
    public PDFontSetting( COSArray fs )
    {
        fontSetting = fs;
    }

    /**
     * {@inheritDoc}
     */
    public COSBase getCOSObject()
    {
        return fontSetting;
    }

    /**
     * This will get the font for this font setting.
     *
     * @return The font for this setting of null if one was not found.
     *
     * @throws IOException If there is an error getting the font.
     */
    public PDFont getFont() throws IOException
    {
        PDFont retval = null;
        COSBase font = fontSetting.get( 0 );
        if( font instanceof COSDictionary )
        {
            retval = PDFontFactory.createFont( (COSDictionary)font );
        }
        return retval;
    }

    /**
     * This will set the font for this font setting.
     *
     * @param font The new font.
     */
    public void setFont( PDFont font )
    {
        fontSetting.set( 0, font );
    }

    /**
     * This will get the size of the font.
     *
     * @return The size of the font.
     */
    public float getFontSize()
    {
        COSNumber size = (COSNumber)fontSetting.get( 1 );
        return size.floatValue();
    }

    /**
     * This will set the size of the font.
     *
     * @param size The new size of the font.
     */
    public void setFontSize( float size )
    {
        fontSetting.set( 1, new COSFloat( size ) );
    }
}
