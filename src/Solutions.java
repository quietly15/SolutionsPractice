import java.util.*;

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


    /*
        Task

        Find all integers between m and n (m and n integers such as 1 <= m <= n) such that the sum of their squared divisors is itself a square.

        We will return an array of subarrays or of tuples (in C an array of Pair) or a string. The subarrays
        (or tuples or Pairs) will have two elements: first the number the squared divisors of which is a square and then the sum of the squared divisors.
    */


    public static String listSquared(long m, long n) {

        StringBuilder result = new StringBuilder("[");

        for (long i = m; i <= n; i++) {
            String a = findDivisors(i);

            assert a != null;

            if (i != n) result.append(a);
        }

        return    result.length() == 1 ?
                  result.append(']').toString() :
                  result.deleteCharAt(result.length() - 1)
                        .deleteCharAt(result.length() - 1)
                        .append(']').toString();
    }

    private static String findDivisors (long target) {

        ArrayList<Long> divisors = new ArrayList<>();

        long sum = 0;

        for (long i = 1; i <= target; i++) {
            if (target % i == 0) divisors.add(i);
        }

        for (Long i: divisors) {
            sum += Math.pow((double) i, 2);
        }

        return (long) Math.sqrt(sum) * Math.sqrt(sum) == sum ?
                String.format("[%d, %d], ", target, sum)
                : null;
    }
}

class Kata {

    public static int[] take (int[] arr, int n) {
        int[] result = new int[n];

        if (n >= 0) System.arraycopy(arr, 0, result, 0, n);

        return result;
    }

    public static String updateLight(String current) {
        return switch (current) {
            case "green" -> "yellow";
            case "yellow" -> "red";
            case "red" -> "green";
            default -> null;
        };
    }


    public static double findUnique(double[] arr) {
        Arrays.sort(arr);
        return arr[0] != arr[1] ? arr[0] : arr[arr.length - 1];
    }

    public static int solve (int[] arr) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i : arr) a.add(i);

        for (int i: a)
            if (!a.contains(-i)) return i;

        return 0;
    }
}
