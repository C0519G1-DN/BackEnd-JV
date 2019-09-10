package com.smile.mp3webservice.security;

public class JwtResponse {
    private String token;
//    private String type = "Bearer";
    private String username;
    private int id;

    public JwtResponse(String accessToken, String username, int id) {
        this.token = accessToken;
        this.username = username;
        this.id = id;
    }

    public String getAccessToken() {
        return token;
    }

//    public void setAccessToken(String accessToken) {
//        this.token = accessToken;
//    }

//    public String getTokenType() {
//        return type;
//    }

//    public void setTokenType(String tokenType) {
//        this.type = tokenType;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
