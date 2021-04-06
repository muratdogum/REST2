
package com.rest.test;



import java.sql.*;
import java.util.ArrayList;




public class Connectors {


    public ArrayList Connector(String email) throws ClassNotFoundException {
       
        ArrayList list = new ArrayList();
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/vt";
        String user="root";
        String pass="1234m";
        int idusers;
        String email2;
        String users_tc_vkn;
        String users_pass;
        



        Connection connection;

        {
            try {
                connection = DriverManager.getConnection(url,user,pass);
                String A="SELECT * FROM user WHERE email='"+email+"'";

                Statement s = connection.createStatement();
                ResultSet resultSet;
                resultSet = s.executeQuery(A);
                 while (resultSet.next()){
                     idusers=resultSet.getInt("id");
                     email2=resultSet.getString("email");
                     users_tc_vkn=resultSet.getString("tc-vkn");
                     users_pass=resultSet.getString("password");
                     
                   
                  
                    list.add(idusers);
                    list.add(email2);
                    list.add(users_pass);
                    if(users_tc_vkn.length()==11){
                    list.add(users_tc_vkn);
                    list.add("yok");
}
                    else{
                    list.add("yok");
                    list.add(users_tc_vkn);
                    }
                }
                connection.close();
            } catch (SQLException throttles) {
            }
        }

        return list;
        }
    public String Connector2(String vkn,String tc,String email, String password) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/vt";
        String user="root";
        String pass="1234m";
       

        Connection connection;

        {
            try {
                connection = DriverManager.getConnection(url,user,pass);
                String A="INSERT INTO user ( `tc-vkn`, `email`, `password`, `date`) VALUES (?,?,?,Now())";

                PreparedStatement s = connection.prepareStatement(A);
                
                if(!"".equals(tc)){
                    s.setString(1,tc);
                }
                else{
                     s.setString(1,vkn);
                }
                s.setString(2,email);
                s.setString(3,password);
                s.executeUpdate();
                
                connection.close();
                return "201";
                
            } catch (SQLException throwables) {
                
                
                return throwables.getMessage();
            }
        }




    }

}

