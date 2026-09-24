package services;

import entities.AccessTokens;
import entities.Compartment;

public class DeliveryAndCollectionService {

    public AccessTokens generateAccessToken(Compartment compartment) {
        // Generate a unique access token for the compartment
        AccessTokens accessToken = new AccessTokens(compartment.getId());
        // In a real application, you would store this token in a database or cache with an expiration time
        System.out.println("Access token generated for compartment: " + compartment.getId() + " Token: " + accessToken.getAccessToken());
        return accessToken;
    }

    public void collectPackage(AccessTokens accessToken, Compartment compartment) {
        // Validate the access token
        if (accessToken == null || !accessToken.getCompartmentId().equals(compartment.getId())) {
            throw new IllegalArgumentException("Invalid access token for the compartment.");
        }

        // Check if the access token has expired
        if (System.currentTimeMillis() > accessToken.getExpirationTime().getTime()) {
            compartment.setOccupied(false); // doing this to ensure the compartment is marked as unoccupied if the token has expired
            throw new IllegalArgumentException("Access token has expired.");
        }

        System.out.println("Package collected from compartment: " + compartment.getId() + " using access token: " + accessToken.getAccessToken());

        // Mark the compartment as unoccupied after collecting the package
        compartment.setOccupied(false);
    }

}
