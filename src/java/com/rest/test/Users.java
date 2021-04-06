
package com.rest.test;

public class Users {
    private String tc;
    private String vkn;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "Users{" +
                "tc=" + tc +
                ", vkn=" + vkn +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Users(String tc, String vkn, String email, String password) {
        this.tc = tc;
        this.vkn = vkn;
        this.email = email;
        this.password = password;
    }

    public Users() {
    }

   
    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getVkn() {
        return vkn;
    }

    public void setVkn(String vkn) {
        this.vkn = vkn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
