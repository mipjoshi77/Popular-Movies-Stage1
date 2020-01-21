package nanodegree.udacity.popular_movies_stage1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.movie_poster)
    ImageView movieImage;
    @BindView(R.id.movie_rating_value)
    TextView movieRatingValue;
    @BindView(R.id.movie_release_date_value)
    TextView movieReleaseDateValue;
    @BindView(R.id.movie_overview_value)
    TextView movieOverviewValue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        Intent intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity != null) {
            String moviePoster = intentThatStartedThisActivity.getStringExtra("poster");
            String title = intentThatStartedThisActivity.getStringExtra("title");
            String rating = intentThatStartedThisActivity.getStringExtra("rate");
            String release = intentThatStartedThisActivity.getStringExtra("release");
            String overview = intentThatStartedThisActivity.getStringExtra("overview");

            setTitle(title);
            movieRatingValue.setText(rating);
            movieReleaseDateValue.setText(release);
            movieOverviewValue.setText(overview);

            Picasso.get()
                    .load(moviePoster)
                    .fit()
                    .into(movieImage);
        }
    }
}
