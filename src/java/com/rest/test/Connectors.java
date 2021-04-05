
package com.rest.test;



import java.sql.*;
import java.util.ArrayList;




public class Connectors {


    public ArrayList Connector(int id) throws ClassNotFoundException {
       
        ArrayList list = new ArrayList();
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/vt";
        String user="root";
        String pass="1234m";
        int idusers;
        String email2;
        int users_tc;
        String users_pass;
        int vkn;



        Connection connection;

        {
            try {
                connection = DriverManager.getConnection(url,user,pass);
                String A="SELECT * FROM users WHERE idusers="+id;

                Statement s = connection.createStatement();
                ResultSet resultSet;
                resultSet = s.executeQuery(A);
                 while (resultSet.next()){
                     idusers=resultSet.getInt("idusers");
                     email2=resultSet.getString("users_email");
                     users_tc=resultSet.getInt("users_tc");
                     users_pass=resultSet.getString("users_password");
                     vkn=resultSet.getInt("users_vkn");
                   
                  
                    list.add(idusers);
                    list.add(email2);
                    list.add(users_pass);
                    list.add(users_tc);
                    list.add(vkn);

                }
                connection.close();
            } catch (SQLException throttles) {
            }
        }

        return list;
        }
    public String Connector2(int vkn,int tc,String email, String password) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/vt";
        String user="root";
        String pass="1234m";
       int tcId=tc+1;

        Connection connection;

        {
            try {
                connection = DriverManager.getConnection(url,user,pass);
                String A="INSERT INTO users (`idusers`, `users_tc`, `users_vkn`, `users_email`, `users_password`, `userscol`) VALUES (?,?,?,?,?,?)";

                PreparedStatement s = connection.prepareStatement(A);
                s.setInt(1,tcId);
                s.setInt(2,tc);
                s.setInt(3,vkn);
                s.setString(4,email);
                s.setString(5,password);
                s.setString(6,password);
                s.executeUpdate();
                
                connection.close();
                return "200";
                
            } catch (SQLException throwables) {
                
                
                return throwables.getMessage();
            }
        }




    }

}

