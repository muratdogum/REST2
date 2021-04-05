
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
    @QueryParam("password") String password,
    @QueryParam("id") int id) throws SQLException, ClassNotFoundException {
        ArrayList list = new ArrayList();
        Users users = new Users() ;
         String  mess = "";
         StatusCode statusCode =new StatusCode();
        try {
       Connectors conn=new Connectors();
       
        list=conn.Connector(id);
         users.setEmail((String) list.get(1));
        users.setPassword((String) list.get(2));
        users.setTc((int) list.get(3));
        users.setVkn((int) list.get(4));
          if(users.getEmail().equals(email)&&users.getPassword().equals(password)){
    
          
       return Response
            .status(Response.Status.ACCEPTED)
            .type(MediaType.APPLICATION_JSON)
            .entity(statusCode.Success(users))
            .build();

        }
      else{
          mess="ŞİFRE YADA EMAİL HATALI";
          return Response
                .status(Response.Status.FORBIDDEN)
                .type(MediaType.APPLICATION_JSON)
                .entity(statusCode.Eror(mess, 403))
                .build();
        
      }
        } catch (ClassNotFoundException throttles) {
           mess=throttles.getMessage();
            return Response
                .status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON)
                .entity(statusCode.Eror(mess, 404))
                .build();
      
            }
        
    
    }
      
        
       
    }

