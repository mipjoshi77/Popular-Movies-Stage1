package nanodegree.udacity.popular_movies_stage1.model;

public class Movie {

    private String originalTitle;
    private String rating;
    private String overview;
    private String releaseDate;
    private String moviePoster;

    public Movie (String originalTitle, String rating, String overview, String releaseDate, String moviePoster) {
        this.originalTitle = originalTitle;
        this.rating = rating;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.moviePoster = moviePoster;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getRating() {
        return rating;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getMoviePoster() {
        return moviePoster;
    }
}
