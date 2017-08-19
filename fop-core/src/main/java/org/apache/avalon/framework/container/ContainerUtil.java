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
package org.apache.avalon.framework.container;

import org.apache.avalon.framework.activity.Initializable;
import org.apache.avalon.framework.configuration.Configurable;
import org.apache.avalon.framework.configuration.Configuration;
import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.avalon.framework.logger.LogEnabled;
import org.apache.avalon.framework.logger.Logger;

/**
 * Utility class that makes it easier to transfer
 * a component throught it's lifecycle stages.
 *
 * @author <a href="mailto:dev@avalon.apache.org">Avalon Development Team</a>
 * @version $Id: ContainerUtil.java 506231 2007-02-12 02:36:54Z crossley $
 */
public final class ContainerUtil
{
    /**
     * Private constructor to block instantiation.
     */
    private ContainerUtil()
    {
    }

    /**
     * Supply specified object with Logger if it implements the
     * {@link LogEnabled} interface.
     *
     * @param object the object to Start
     * @param logger the logger to enable component with. May be null
     *        in which case the specified object must not implement LogEnabled.
     * @throws IllegalArgumentException if the object is LogEnabled but Logger is null
     */
    public static void enableLogging( final Object object,
                                      final Logger logger )
    {
        if( object instanceof LogEnabled )
        {
            if( null == logger )
            {
                final String message = "logger is null";
                throw new IllegalArgumentException( message );
            }
            ( (LogEnabled)object ).enableLogging( logger );
        }
    }

    /**
     * Configure specified object if it implements the
     * {@link Configurable} interface.
     *
     * @param object the object to Start
     * @param configuration the configuration object to use during
     *        configuration. May be null in which case the specified object
     *        must not implement Configurable
     * @throws ConfigurationException if there is a problem Configuring object,
     *         or the object is Configurable but Configuration is null
     * @throws IllegalArgumentException if the object is Configurable but
     *         Configuration is null
     */
    public static void configure( final Object object,
                                  final Configuration configuration )
        throws ConfigurationException
    {
        if( object instanceof Configurable )
        {
            if( null == configuration )
            {
                final String message = "configuration is null";
                throw new IllegalArgumentException( message );
            }
            ( (Configurable)object ).configure( configuration );
        }
    }

    /**
     * Initialize specified object if it implements the
     * {@link Initializable} interface.
     *
     * @param object the object to Initialize
     * @throws Exception if there is a problem Initializing object
     */
    public static void initialize( final Object object )
        throws Exception
    {
        if( object instanceof Initializable )
        {
            ( (Initializable)object ).initialize();
        }
    }

}
