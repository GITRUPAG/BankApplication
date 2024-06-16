import java.util.Random;

public class GenerateId {
    private static final String PREFIX = "USR";
    private static final int MAX_RANDOM_NUMBER = 10000;

    public static String generateUserId() {
        String userId;
        boolean isUnique = false;
        Random random = new Random();

        do {
            int randomNumber = random.nextInt(MAX_RANDOM_NUMBER);
            userId = PREFIX + String.format("%04d", randomNumber); // Ensures 4-digit random number
            // Check uniqueness (e.g., against database)

            if (isUniqueId(userId)) {
                isUnique = true;
            }
        } while (!isUnique);

        return userId;
    }

    // Placeholder method to check uniqueness (e.g., query database)
    private static boolean isUniqueId(String userId) {
        // Assume this method checks against existing user IDs in the database
        return true; // Return true for now; replace with actual implementation
    }


}
