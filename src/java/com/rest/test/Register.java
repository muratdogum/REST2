
package com.rest.test;



import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("useradd")
public class Register {
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response postValueMethod(
            @QueryParam("tc") int tc,
            @QueryParam("vkn") int vkn,
            @QueryParam("email") String  email,
            @QueryParam("password") String password) throws ClassNotFoundException{
                Connectors conn=new Connectors();
                String  message=conn.Connector2(vkn, tc, email, password);
                Users users = new Users() ;
                users.setEmail(email);
                users.setPassword(password);
                users.setTc(tc);
                users.setVkn(vkn);
                StatusCode statusCode =new StatusCode();
                if(message.equals("200")){
                    return Response
            .status(Response.Status.CREATED)
            .type(MediaType.APPLICATION_JSON)
            .entity(statusCode.Success(users))
            .build();
                }
                else{
                String Eror=message;
                int Code=404;
                return Response
                .status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON)
                .entity(statusCode.Eror(Eror, Code))
                .build();
                }
        
        
       
    }
   

   }
