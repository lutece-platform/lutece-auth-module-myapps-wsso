/*
 * Copyright (c) 2002-2013, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.myapps.modules.wsso.service;

import fr.paris.lutece.plugins.myapps.business.MyApps;
import fr.paris.lutece.plugins.myapps.business.MyAppsUser;
import fr.paris.lutece.plugins.myapps.modules.wsso.business.MyAppsWSSO;
import fr.paris.lutece.plugins.myapps.modules.wsso.business.MyAppsWSSOUser;
import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.sort.AttributeComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * MyAppsWSSOService
 *
 */
public final class MyAppsWSSOService
{
    private static final String MYAPPS_WSSO_APP = "myapps-wsso.app.";
    private static final String ID = ".id";
    private static final String GUID = ".guid";
    private static final String NAME = ".name";
    private static final String DESCRIPTION = ".description";
    private static final String URL = ".url";
    private static final String PARAMETER_NAME = "name";
    private static MyAppsWSSOService _singleton;

    /**
    * Initialize the MyAppsWSSOService
    */
    public void init(  )
    {
    }

    /**
     * Returns the instance of the singleton
     *
     * @return The instance of the singleton
     */
    public static synchronized MyAppsWSSOService getInstance(  )
    {
        if ( _singleton == null )
        {
            _singleton = new MyAppsWSSOService(  );
        }

        return _singleton;
    }

    /**
     * Returns an instance of a myApps whose identifier is specified in parameter
     *
     * @param nMyAppId The myApps primary key
     * @param plugin the Plugin
     * @return an instance of MyApps
     */
    public MyApps findByPrimaryKey( int nMyAppId, Plugin plugin )
    {
        // TODO : It is a Mock. Use a webservice to fetch the MyApp
        int nId = AppPropertiesService.getPropertyInt( MYAPPS_WSSO_APP + nMyAppId + ID, 1 );
        String strGuid = AppPropertiesService.getProperty( MYAPPS_WSSO_APP + nMyAppId + GUID );
        String strName = AppPropertiesService.getProperty( MYAPPS_WSSO_APP + nMyAppId + NAME );
        String strDescription = AppPropertiesService.getProperty( MYAPPS_WSSO_APP + nMyAppId + DESCRIPTION );
        String strUrl = AppPropertiesService.getProperty( MYAPPS_WSSO_APP + nMyAppId + URL );
        MyAppsWSSO myApp = new MyAppsWSSO(  );
        myApp.setIdApplication( nId );
        myApp.setGuid( strGuid );
        myApp.setName( strName );
        myApp.setDescription( strDescription );
        myApp.setUrl( strUrl );

        return myApp;
    }

    /**
     * Loads a list of myApps belonging to a user
     *
     * @param strUserName the user name
     * @param bIsAscSort true if it is sorted ascendly, false otherwise
     * @param plugin the Plugin
     * @return the collection which contains the data of all the myApps
     */
    public List<MyApps> getMyAppsListByUser( String strUserName, boolean bIsAscSort, Plugin plugin )
    {
        // TODO : It is a Mock. Fetch the MyApps from a webservice
        List<MyApps> listMyApps = new ArrayList<MyApps>(  );

        for ( int i = 1; i < 5; i++ )
        {
            MyApps myApp = findByPrimaryKey( i, plugin );
            listMyApps.add( myApp );
        }

        Collections.sort( listMyApps, new AttributeComparator( PARAMETER_NAME, bIsAscSort ) );

        return listMyApps;
    }

    /**
     * Loads the data of all the myAppsUsers and returns them in form of a collection
     *
     * @param nMyAppId the ID of the appication
     * @param strUserName the user name
     * @param plugin the Plugin
     * @return a {@link MyAppsUser}
     *
     */
    public MyAppsUser getCredential( int nMyAppId, String strUserName, Plugin plugin )
    {
        // TODO : It is a Mock. Fetch the MyAppsUser from a webservice
        MyAppsUser myAppsUser = new MyAppsWSSOUser(  );

        return myAppsUser;
    }
}
