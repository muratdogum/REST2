
package com.rest.test;



import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class StatusCode {


    public String Success(Users users) {
        String encoding="Basic ";
        try {
            encoding += Base64.getEncoder().encodeToString((users.getPassword()+":"+users.getPassword()).getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "{\"data\": {" +
                "\"id\"=" + (users.getTc()+1) +
                ",\"tc\"=" + users.getTc() +
                ", \"vkn\"=" + users.getVkn() +
                ", \"password\"=\"" + users.getPassword() + '\"' +
                ", \"email\"=\"" + users.getEmail() + '\"' +
                ", \"authorization\"=\"" + encoding + '\"' +
                "}"+
                ",\"success\":{"+
                "\"statuscode\"=200"+
                "}}";
    }

    




    public String Eror(String Eror,int Code) {
        return "{\"error\": {" +
                "\"statuscode\"=\"" + Code + '\"' +
                ", \"mesagge\"=\"" + Eror + '\"' +
                "}}";
    }
 }

