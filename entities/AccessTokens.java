package entities;

import java.sql.Timestamp;

public class AccessTokens {

    private String accessToken;
    private String compartmentId;
    private Timestamp expirationTime; // Optional: You can add an expiration time for the access token

    public AccessTokens(String compartmentId) {
        this.accessToken = Math.random() + "-" + System.currentTimeMillis(); // Simple random token generation
        this.compartmentId = compartmentId;
        this.expirationTime = new Timestamp(System.currentTimeMillis() + 5 * 1000); // Token valid for 5 seconds
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getCompartmentId() {
        return compartmentId;
    }

    public Timestamp getExpirationTime() {
        return expirationTime;
    }
}
