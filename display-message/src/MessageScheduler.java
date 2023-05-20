import java.util.Timer;
import java.util.TimerTask;
public class MessageScheduler {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new DisplayMessage(), 0, 120000); // Schedule the task to run every 2 minutes (120,000 milliseconds)
    }
}
