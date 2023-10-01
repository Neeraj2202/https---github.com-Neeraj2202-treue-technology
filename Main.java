package MovieRecommendation;

import java.util.*;

class Movie {
    private String title;
    private List<String> genres;

    public Movie(String title, List<String> genres) {
        this.title = title;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }
}

class User {
    private Map<Movie, Double> ratings;

    public User(String name) {
        this.ratings = new HashMap<>();
    }

    public void rateMovie(Movie movie, double rating) {
        ratings.put(movie, rating);
    }

    public Map<Movie, Double> getRatings() {
        return ratings;
    }
}

class MovieRecommendationSystem {
    private List<Movie> movies;
    private List<User> users;

    public MovieRecommendationSystem() {
        movies = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<Movie> recommendMovies(User user) {
        // Implement recommendation logic here (e.g., collaborative or content-based filtering)
        // For simplicity, we'll return a random list of movies for demonstration purposes.
        List<Movie> recommendedMovies = new ArrayList<>();
        Random rand = new Random();

        while (recommendedMovies.size() < 5) {
            int index = rand.nextInt(movies.size());
            Movie randomMovie = movies.get(index);
            if (!user.getRatings().containsKey(randomMovie)) {
                recommendedMovies.add(randomMovie);
            }
        }

        return recommendedMovies;
    }
}

public class Main {
    public static void main(String[] args) {
        MovieRecommendationSystem recommendationSystem = new MovieRecommendationSystem();

        // Create and add movies
        Movie movie1 = new Movie("Movie 1", Arrays.asList("Action", "Adventure"));
        Movie movie2 = new Movie("Movie 2", Arrays.asList("Drama", "Romance"));
        Movie movie3 = new Movie("Movie 3", Arrays.asList("Comedy"));
        recommendationSystem.addMovie(movie1);
        recommendationSystem.addMovie(movie2);
        recommendationSystem.addMovie(movie3);

        // Create and add users
        User user1 = new User("User 1");
        User user2 = new User("User 2");
        recommendationSystem.addUser(user1);
        recommendationSystem.addUser(user2);

        // User 1 rates movie1 and movie2
        user1.rateMovie(movie1, 4.5);
        user1.rateMovie(movie2, 3.0);

        // User 2 rates movie2 and movie3
        user2.rateMovie(movie2, 4.0);
        user2.rateMovie(movie3, 3.5);

        // Recommend movies to User 1
        List<Movie> recommendedMovies = recommendationSystem.recommendMovies(user1);

        // Print recommended movies
        System.out.println("Recommended Movies for User 1:");
        for (Movie movie : recommendedMovies) {
            System.out.println(movie.getTitle());
        }
    }
}
