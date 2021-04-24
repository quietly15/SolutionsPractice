public class Solutions {

    // A method that formats seconds into days, hours, minutes and seconds
    
    public static String timeFormat (int sec) {

        final int secondsInDays = 86400;
        final int secondsInHours = 3600;
        final int secondsInMinutes = 60;

        int allSeconds = sec;

        int day = allSeconds / secondsInDays;
        allSeconds -= day * secondsInDays;

        int hour = allSeconds / secondsInHours;
        allSeconds -= hour * secondsInHours;

        int minute = allSeconds / secondsInMinutes;
        allSeconds -= minute * secondsInMinutes;

        return String.format("Result: %d day(s) %s hour(s) %s minute(s) %s second(s)",
                day,
                hour        < 10 ? "0" + hour : hour,
                minute      < 10 ? "0" + minute : minute,
                allSeconds  < 10 ? "0" + allSeconds : allSeconds
        );
    }

    public static void main(String[] args) {
        System.out.println(timeFormat(60));
    }
}
