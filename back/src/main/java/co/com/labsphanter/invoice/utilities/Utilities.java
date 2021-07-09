package co.com.labsphanter.invoice.utilities;

import java.util.Base64;
import java.util.UUID;

public class Utilities {

    /*
     * Generación de ID para registrar en las tablas mongo
     */
    public static String generationId() {
        return String.valueOf(System.currentTimeMillis()) + String.valueOf(UUID.randomUUID()).replace("-", "");
    }

    /*
     * Método para encritar una cadena en base 64
     */
    public String encodedBase64(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }


    /*
     * Método para decodificar una cadena en base 64
     */
    public static String decodedBase64(String message) {
        byte[] decodedBytes = Base64.getDecoder().decode(message);
        return new String(decodedBytes);
    }
}
