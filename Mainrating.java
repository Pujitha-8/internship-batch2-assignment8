import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] ratings = {3, 7, 5, 9, 4, 8, 6, 10, 2, 8};

        // Define rating ranges
        int[][] ratingRanges = {
                {1, 5},   // 1-5 stars
                {6, 10}   // 6-10 stars
        };

        // Initialize counts for each rating range
        Map<String, Integer> ratingRangeCounts = new HashMap<>();
        for (int[] range : ratingRanges) {
            ratingRangeCounts.put(range[0] + "-" + range[1], 0);
        }

        // Initialize total ratings for each rating range
        Map<String, Integer> totalRatingsByRange = new HashMap<>();
        for (int[] range : ratingRanges) {
            totalRatingsByRange.put(range[0] + "-" + range[1], 0);
        }

        // Count the number of restaurants and calculate total ratings for each range
        for (int rating : ratings) {
            for (int[] range : ratingRanges) {
                if (rating >= range[0] && rating <= range[1]) {
                    String key = range[0] + "-" + range[1];
                    ratingRangeCounts.put(key, ratingRangeCounts.get(key) + 1);
                    totalRatingsByRang
