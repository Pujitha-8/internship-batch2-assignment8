import java.util.HashMap;
import java.util.Map;

class Movie {
    private String title;
    private String rating;
    private double ratingValue;

    public Movie(String title, String rating, double ratingValue) {
        this.title = title;
        this.rating = rating;
        this.ratingValue = ratingValue;
    }

    public String getRating() {
        return rating;
    }

    public double getRatingValue() {
        return ratingValue;
    }
}

public class Main {
    public static void main(String[] args) {
        Movie[] movies = {
                new Movie("Movie 1", "PG", 4.5),
                new Movie("Movie 2", "PG-13", 3.8),
                new Movie("Movie 3", "R", 4.0),
                new Movie("Movie 4", "PG", 4.2),
                new Movie("Movie 5", "PG-13", 3.9),
                new Movie("Movie 6", "R", 4.3),
                new Movie("Movie 7", "PG", 4.7)
        };

        Map<String, Integer> movieCountByRating = new HashMap<>();
        Map<String, Double> averageRatingByRating = new HashMap<>();

        for (Movie movie : movies) {
            String rating = movie.getRating();
            double ratingValue = movie.getRatingValue();

            // Update movie count for the rating
            movieCountByRating.put(rating, movieCountByRating.getOrDefault(rating, 0) + 1);

            // Update total rating for the rating
            averageRatingByRating.put(rating, averageRatingByRating.getOrDefault(rating, 0.0) + ratingValue);
        }

        // Calculate average rating for each rating category
        for (String rating : averageRatingByRating.keySet()) {
            double totalRating = averageRatingByRating.get(rating);
            int count = movieCountByRating.get(rating);
            double averageRating = totalRating / count;
            averageRatingByRating.put(rating, averageRating);
        }

        // Display the results
        for (String rating : movieCountByRating.keySet()) {
            System.out.println("Rating: " + rating);
            System.out.println("Number of movies: " + movieCountByRating.get(rating));
            System.out.println("Average rating: " + averageRatingByRating.get(rating));
            System.out.println();
        }
    }
}
