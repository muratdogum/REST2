
package com.rest.test;

public class Users {
    private int tc;
    private int vkn;
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

    public Users(int tc, int vkn, String email, String password) {
        this.tc = tc;
        this.vkn = vkn;
        this.email = email;
        this.password = password;
    }

    public Users() {
    }

   
    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

    public int getVkn() {
        return vkn;
    }

    public void setVkn(int vkn) {
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
