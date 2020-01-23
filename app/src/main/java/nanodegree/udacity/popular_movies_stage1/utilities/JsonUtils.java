package nanodegree.udacity.popular_movies_stage1.utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import nanodegree.udacity.popular_movies_stage1.model.Movie;

public final class JsonUtils {

    private static final String BASE_URL = "https://image.tmdb.org/t/p/";
    private static final String POSTER_SIZE = "w185";

    private static final String RESULTS = "results";
    private static final String POSTER_PATH = "poster_path";
    private static final String ORIGINAL_TITLE = "title";
    private static final String RATING = "vote_average";
    private static final String OVERVIEW = "overview";
    private static final String RELEASE_DATE = "release_date";

    public static List<Movie>parseMovieDbJson (String json) {

        try {
            JSONObject baseJSONRespone = new JSONObject(json);
            JSONArray resultsArray = baseJSONRespone.getJSONArray(RESULTS);

            List<Movie> movieList = new ArrayList<>();

            for (int i=0; i<resultsArray.length(); i++) {
                JSONObject resultsObject = resultsArray.getJSONObject(i);

                String constructedBasePath = BASE_URL + POSTER_SIZE + resultsObject.optString(POSTER_PATH);
                Movie movie = new Movie(resultsObject.optString(ORIGINAL_TITLE), resultsObject.optString(RATING), resultsObject.optString(OVERVIEW), resultsObject.optString(RELEASE_DATE), constructedBasePath);

                movieList.add(movie);
            }

            return movieList;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
