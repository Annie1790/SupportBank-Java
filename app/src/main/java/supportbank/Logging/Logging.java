package supportbank.Logging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {
    private static final Logger logger = LogManager.getLogger();
    String pattern = "MM/dd/yyyy HH:mm:ss";
    DateFormat df = new SimpleDateFormat(pattern);
    Date today = Calendar.getInstance().getTime();
    String todayAsString = df.format(today);

    public void programStart() {
        logger.info("User is running the program at " + todayAsString);
    }

    public void mainMenu() {
        logger.info("User is in main screen at" + todayAsString);
    }

    public void wrongPrompt() {
        logger.error("User entered a wrong prompt at " + todayAsString);
    }

    public void programExit() {
        logger.info("User exited the program at " + todayAsString);
    }

}
