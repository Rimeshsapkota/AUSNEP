import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        //Get current date and time
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local date and time : " +localDateTime);

        //convert to UTC
        LocalDateTime utcDateTime = DateTimeConverter.toUTC(localDateTime, ZoneId.systemDefault());
        System.out.println("UTC date and time: " + utcDateTime);

        // Convert back to local date and time
        LocalDateTime convertedDateTime = DateTimeConverter.fromUTC(utcDateTime, ZoneId.systemDefault());
        System.out.println("Converted local date and time: " + convertedDateTime);

    }
}