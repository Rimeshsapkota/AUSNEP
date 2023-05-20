import java.util.Random;
import java.util.stream.Collectors;

public class RandomAlphaNumericGenerator {
    private static final String ALPHA_NUMERIC_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static void main(String[] args) {
        int length = 10; // Desired length of the random string

        String randomString = generateRandomAlphaNumericString(length);
        System.out.println("Random Alphanumeric String: " + randomString);
    }

    public static String generateRandomAlphaNumericString(int length) {
        Random random = new Random();

        String randomString = random.ints(length, 0, ALPHA_NUMERIC_CHARS.length())
                .mapToObj(ALPHA_NUMERIC_CHARS::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());

        return randomString;
    }
}
