package org.apache.maven.scm;

/*
 * Copyright 2001-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;
import java.io.IOException;

import org.apache.maven.scm.ScmTestCase;

/**
 * @author dtran
 */
public class ScmFileSetTest
    extends ScmTestCase
{
    public void testExcludes() throws IOException
    {
        String basedir = getBasedir();

        System.out.println( "basedir = " + basedir );

        ScmFileSet fileSet = new ScmFileSet( new File( basedir ), "**/**", "**/target/**" );

        File[] files = fileSet.getFiles();

        for ( int i = 0; i < files.length; ++i )
        {
            if ( files[i].getAbsolutePath().indexOf( "target" ) != -1 )
            {
                fail( "Found excludes in file set: " + files[i] );
            }
        }

    }
}