package org.apache.ddlutils.task;

/*
 * Copyright 1999-2005 The Apache Software Foundation.
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

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.apache.ddlutils.PlatformUtils;
import org.apache.tools.ant.BuildException;

/**
 * Encloses the platform configuration for the Ant tasks.
 * 
 * @author Thomas Dudziak
 * @version $Revision: 329426 $
 */
public class PlatformConfiguration
{
    /** The type of the database. */
    private String _databaseType;
    /** The data source to use for accessing the database. */
    private BasicDataSource _dataSource;
    /** Whether to use delimited SQL identifiers. */
    private boolean _useDelimitedSqlIdentifiers = true;

    /**
     * Returns the database type.
     * 
     * @return The database type
     */
    public String getDatabaseType()
    {
        return _databaseType;
    }

    /**
     * Sets the database type.
     * 
     * @param type The database type
     */
    public void setDatabaseType(String type)
    {
        _databaseType = type;
    }

    /**
     * Returns the data source to use for accessing the database.
     * 
     * @return The data source
     */
    public BasicDataSource getDataSource()
    {
        return _dataSource;
    }

    /**
     * Sets the data source to use for accessing the database.
     * 
     * @param dataSource The data source pointing to the database
     */
    public void setDataSource(BasicDataSource dataSource)
    {
        _dataSource = dataSource;
    }

    /**
     * Determines whether delimited SQL identifiers shall be used (the default).
     *
     * @return <code>true</code> if delimited SQL identifiers shall be used
     */
    public boolean isUseDelimitedSqlIdentifiers()
    {
        return _useDelimitedSqlIdentifiers;
    }

    /**
     * Specifies whether delimited SQL identifiers shall be used.
     *
     * @param useDelimitedSqlIdentifiers <code>true</code> if delimited SQL identifiers shall be used
     */
    public void setUseDelimitedSqlIdentifiers(boolean useDelimitedSqlIdentifiers)
    {
        _useDelimitedSqlIdentifiers = useDelimitedSqlIdentifiers;
    }

    /**
     * Creates the platform for the configured database.
     * 
     * @return The platform
     */
    public Platform getPlatform() throws BuildException
    {
        Platform platform = null;

        if (_databaseType == null)
        {
            if (_dataSource == null)
            {
                throw new BuildException("No database specified.");
            }
            if (_databaseType == null)
            {
                _databaseType = new PlatformUtils().determineDatabaseType(_dataSource.getDriverClassName(),
                                                                          _dataSource.getUrl());
            }
            if (_databaseType == null)
            {
                _databaseType = new PlatformUtils().determineDatabaseType(_dataSource);
            }
        }
        try
        {
            platform = PlatformFactory.createNewPlatformInstance(_databaseType);
        }
        catch (Exception ex)
        {
            throw new BuildException("Database type "+_databaseType+" is not supported.", ex);
        }
        if (platform == null)
        {
            throw new BuildException("Database type "+_databaseType+" is not supported.");
        }
        platform.setDataSource(_dataSource);
        platform.getPlatformInfo().setUseDelimitedIdentifiers(isUseDelimitedSqlIdentifiers());

        return platform;
    }
}