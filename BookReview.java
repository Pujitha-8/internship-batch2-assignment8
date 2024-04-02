import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BookReview {
    private String title;
    private int rating;

    public BookReview(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}

public class Main {
    public static void main(String[] args) {
        BookReview[] bookReviews = {
                new BookReview("Book 1", 4),
                new BookReview("Book 2", 7),
                new BookReview("Book 3", 10),
                new BookReview("Book 4", 2),
                new BookReview("Book 5", 6),
                new BookReview("Book 6", 8),
                new BookReview("Book 7", 3)
        };

        // Define rating ranges
        int[][] ratingRanges = {
                {1, 5},   // 1-5 stars
                {6, 10}   // 6-10 stars
        };

        // Initialize counts for positive, neutral, and negative reviews
        int positiveCount = 0;
        int neutralCount = 0;
        int negativeCount = 0;

        // Initialize counts for each rating range
        Map<String, Integer> ratingRangeCounts = new HashMap<>();
        for (int[] range : ratingRanges) {
            ratingRangeCounts.put(range[0] + "-" + range[1], 0);
        }

        for (BookReview review : bookReviews) {
            int rating = review.getRating();

            // Check if the rating is positive, neutral, or negative
            if (rating >= 7) {
                positiveCount++;
            } else if (rating >= 4 && rating <= 6) {
                neutralCount++;
            } else {
                negativeCount++;
            }

            // Check which rating range the review falls into
            for (int[] range : ratingRanges) {
                if (rating >= range[0] && rating <= range[1]) {
                    String key = range[0] + "-" + range[1];
                    ratingRangeCounts.put(key, ratingRangeCounts.get(key) + 1);
                    break;
                }
            }
        }

        // Display the results
        System.out.println("Number of books reviewed within specified rating ranges:");
        for (String key : ratingRangeCounts.keySet()) {
            System.out.println(key + " stars: " + ratingRangeCounts.get(key));
        }

        System.out.println("\nCount of books with positive, neutral, and negative reviews:");
        System.out.println("Positive reviews: " + positiveCount);
        System.out.println("Neutral reviews: " + neutralCount);
        System.out.println("Negative reviews: " + negativeCount);
    }
}
