
package com.rest.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("userlogin")
public class LogIn {

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getValueMethod(
    @QueryParam("email") String  email,
    @QueryParam("password") String password) throws SQLException, ClassNotFoundException {
        String  mess = "";
        int id;
        StatusCode statusCode =new StatusCode();
        try {
            ArrayList list = new ArrayList();
        Users users = new Users() ;
         
         
       Connectors conn=new Connectors();
       
         list=conn.Connector(email);
         users.setEmail((String) list.get(1));
        users.setPassword((String) list.get(2));
        users.setTc((String) list.get(3));
        users.setVkn((String) list.get(4));
       id=  (int) list.get(0);
          if(users.getPassword().equals(password)){
    
          
       return Response
            .status(Response.Status.OK)
            .type(MediaType.APPLICATION_JSON)
            .entity(statusCode.Success(users,id))
            .build();

        }
      else{
          mess="ŞİFRE HATALI";
          return Response
                .status(Response.Status.FORBIDDEN)
                .type(MediaType.APPLICATION_JSON)
                .entity(statusCode.Eror(mess, 403))
                .build();
        
      }
        } catch (Exception throttles) {
           mess="KULLANICI BULUNAMADI";
            return Response
                .status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON)
                .entity(statusCode.Eror(throttles.getMessage(), 404))
                .build();
      
            }
        
    
    }
      
        
       
    }

