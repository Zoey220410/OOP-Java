public class TimeCalculator {
    public static void main(String[] args){
        double homeworkTime = 3.99;
        double lectureTime = 1.25;
        int numLectures = 4;
        double breakTime = 0.53;
        double TravelAdjustment = 0.08;
        double timeTotal = 0.0;

        timeTotal += homeworkTime / 2 + lectureTime * numLectures;
        timeTotal -= breakTime * 3;
        timeTotal *= 1 + TravelAdjustment;

        double timeTotalTrunc = (int) (timeTotal * 100) / 100.0;
        System.out.println("You're busy for " + timeTotalTrunc + " hours.");

        int totalHours = 24;
        totalHours -= timeTotalTrunc;
        System.out.println("You have " + totalHours + " hours remaining in the day.");

    }
}
