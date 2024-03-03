package com.shouryashrey.sUrl.Service;

import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class ShortyUtils {
    public String generateHash(String longUrl) {
        try {
            // Create a MessageDigest object for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Update the digest with the input bytes
            byte[] hash = digest.digest(longUrl.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString().substring(0,7);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
            return null;
        }
    }

    public Boolean isValidUrl(String urlString) {
        try {
            new URL(urlString);
            return true;
        }
        catch (MalformedURLException e) {
            return false;
        }
    }
}
