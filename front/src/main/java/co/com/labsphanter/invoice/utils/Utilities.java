package co.com.labsphanter.invoice.utils;

import java.util.Base64;

public class Utilities {
	
	
	/*
     * Método para decodificar una cadena en base 64
     */
    public static String decodedBase64(String message) {
        byte[] decodedBytes = Base64.getDecoder().decode(message);
        return new String(decodedBytes);
    }
    
    
    /*
     * Método para codificar una cadena en base 64
     */
    public static String encodeBase64(String message) {
        String encodedString = Base64.getEncoder().encodeToString(message.getBytes());
        return new String(encodedString);
    }

}
