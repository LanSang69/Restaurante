package controller;
import java.security.SecureRandom;

public class RandomIdGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomId(int length) {
        StringBuilder randomId = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            randomId.append(randomChar);
        }

        return randomId.toString();
    }

    public static void main(String[] args) {
        // Example: Generate a random ID with a length of 8 characters
        String randomId = generateRandomId(8);
        System.out.println("Random ID: " + randomId);
    }
}
