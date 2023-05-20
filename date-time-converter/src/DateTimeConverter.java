import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateTimeConverter {

    //method to convert local date and time to UTC
    public static LocalDateTime toUTC(LocalDateTime localDateTime, ZoneId zoneId){
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        return zonedDateTime.withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime();

    }

    //method to convert UTC to local date and time
    public static LocalDateTime fromUTC(LocalDateTime utcDateTime, ZoneId zoneId) {
        ZonedDateTime zonedDateTime = utcDateTime.atZone(ZoneOffset.UTC);
        return zonedDateTime.withZoneSameInstant(zoneId).toLocalDateTime();
    }

    }
