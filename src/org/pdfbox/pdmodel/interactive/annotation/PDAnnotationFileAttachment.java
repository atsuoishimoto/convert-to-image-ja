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
package org.pdfbox.pdmodel.interactive.annotation;

import java.io.IOException;

import org.pdfbox.cos.COSDictionary;
import org.pdfbox.cos.COSName;
import org.pdfbox.pdmodel.common.filespecification.PDFileSpecification;

/**
 * This is the class that represents a file attachement.
 *
 * @author <a href="mailto:ben@benlitchfield.com">Ben Litchfield</a>
 * @version $Revision: 1.2 $
 */
public class PDAnnotationFileAttachment extends PDAnnotation
{
    /**
     * See get/setAttachmentName.
     */
    public static final String ATTACHMENT_NAME_PUSH_PIN = "PushPin";
    /**
     * See get/setAttachmentName.
     */
    public static final String ATTACHMENT_NAME_GRAPH = "Graph";
    /**
     * See get/setAttachmentName.
     */
    public static final String ATTACHMENT_NAME_PAPERCLIP = "Paperclip";
    /**
     * See get/setAttachmentName.
     */
    public static final String ATTACHMENT_NAME_TAG = "Tag";

    /**
     * The type of annotation.
     */
    public static final String SUB_TYPE = "FileAttachment";

    /**
     * Constructor.
     */
    public PDAnnotationFileAttachment()
    {
        super();
        getDictionary().setItem( COSName.SUBTYPE, COSName.getPDFName( SUB_TYPE ) );
    }

    /**
     * Creates a Link annotation from a COSDictionary, expected to be
     * a correct object definition.
     *
     * @param field the PDF objet to represent as a field.
     */
    public PDAnnotationFileAttachment(COSDictionary field)
    {
        super( field );
    }

    /**
     * Return the attached file.
     *
     * @return The attached file.
     *
     * @throws IOException If there is an error creating the file spec.
     */
    public PDFileSpecification getFile() throws IOException
    {
        return PDFileSpecification.createFS( getDictionary().getDictionaryObject( "FS" ) );
    }

    /**
     * Set the attached file.
     *
     * @param file The file that is attached.
     */
    public void setFile( PDFileSpecification file )
    {
        getDictionary().setItem( "FS", file );
    }

    /**
     * This is the name used to draw the type of attachment.
     * See the ATTACHMENT_NAME_XXX constants.
     *
     * @return The name that describes the visual cue for the attachment.
     */
    public String getAttachmentName()
    {
        return getDictionary().getNameAsString( "Name", ATTACHMENT_NAME_PUSH_PIN );
    }

    /**
     * Set the name used to draw the attachement icon.
     * See the ATTACHMENT_NAME_XXX constants.
     *
     * @param name The name of the visual icon to draw.
     */
    public void setAttachementName( String name )
    {
        getDictionary().setName( "Name", name );
    }
}
