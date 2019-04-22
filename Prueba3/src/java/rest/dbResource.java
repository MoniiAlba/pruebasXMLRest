/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.DataBase;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author soeur
 */
@Path("db")
public class dbResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of dbResource
     */
    public dbResource() {
    }

    /**
     * Retrieves representation of an instance of rest.dbResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        return "";
    }

    /**
     * PUT method for updating or creating an instance of dbResource
     * @param content representation for the resource
     */
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    public  DataBase putXml(@FormParam("dbName")String dbName, @FormParam("userName")String userName, @FormParam("password")String psswrd) throws Exception {
        //TODO return proper representation object
        ArrayList <String> ans = getTableName(dbName, userName, psswrd);
        System.out.println("Resp: "+ans.toString());
        DataBase db = new DataBase();
        db.setName(dbName);
        db.setTables(ans);
        System.out.println("Base a responder: "+db.toString());
        return db;
    }


    private static java.util.ArrayList<java.lang.String> getTableName(java.lang.String dbName, java.lang.String userName, java.lang.String password) {
        wsclientnew.DBWS_Service service = new wsclientnew.DBWS_Service();
        wsclientnew.DBWS port = service.getDBWSPort();
        return (ArrayList<String>) port.getTableName(dbName, userName, password);
    }
}
