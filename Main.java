import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testScores = {85, 92, 78, 90, 88, 75, 82, 95, 70, 86};

        // Calculate average score
        double averageScore = calculateAverage(testScores);

        // Calculate median score
        double medianScore = calculateMedian(testScores);

        // Count number of students above, at, and below the average
        int aboveAverageCount = countAboveAverage(testScores, averageScore);
        int atAverageCount = countAtAverage(testScores, averageScore);
        int belowAverageCount = countBelowAverage(testScores, averageScore);

        // Display results
        System.out.println("Number of students who scored above the average: " + aboveAverageCount);
        System.out.println("Median score for students who scored above the average: " + medianScore);
        System.out.println();
        System.out.println("Number of students who scored at the average: " + atAverageCount);
        System.out.println("Median score for students who scored at the average: " + medianScore);
        System.out.println();
        System.out.println("Number of students who scored below the average: " + belowAverageCount);
        System.out.println("Median score for students who scored below the average: " + medianScore);
    }

    public static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    public static double calculateMedian(int[] scores) {
        Arrays.sort(scores);
        if (scores.length % 2 == 0) {
            int middleIndex1 = scores.length / 2 - 1;
            int middleIndex2 = scores.length / 2;
            return (double) (scores[middleIndex1] + scores[middleIndex2]) / 2;
        } else {
            int middleIndex = scores.length / 2;
            return scores[middleIndex];
        }
    }

    public static int countAboveAverage(int[] scores, double average) {
        int count = 0;
        for (int score : scores) {
            if (score > average) {
                count++;
            }
        }
        return count;
    }

    public static int countAtAverage(int[] scores, double average) {
        int count = 0;
        for (int score : scores) {
            if (score == average) {
                count++;
