class Solution {
    // Number of days in each month for a non-leap year
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // Convert all date strings to day-of-year integers
        int startAlice = dateToDayOfYear(arriveAlice);
        int endAlice = dateToDayOfYear(leaveAlice);
        int startBob = dateToDayOfYear(arriveBob);
        int endBob = dateToDayOfYear(leaveBob);

        // Find the overlap interval
        int overlapStart = Math.max(startAlice, startBob);
        int overlapEnd = Math.min(endAlice, endBob);

        // Calculate the number of overlapping days
        if (overlapStart <= overlapEnd) {
            return overlapEnd - overlapStart + 1;
        }
        
        return 0;
    }

    private int dateToDayOfYear(String date) {
        // Parse month and day from the "MM-DD" format
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        // Add up the days of all previous months
        int dayOfYear = 0;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += DAYS_IN_MONTH[i];
        }

        // Add the days of the current month
        dayOfYear += day;

        return dayOfYear;
    }
}
