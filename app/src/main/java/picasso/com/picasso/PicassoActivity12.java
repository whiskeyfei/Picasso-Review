package picasso.com.picasso;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.StatsSnapshot;

import static com.squareup.picasso.Picasso.with;

public class PicassoActivity12 extends Activity {


    String internetUrl = "http://i.imgur.com/DvpvklR.png";
    ImageView mTargetImageView;
    Picasso mPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_05);
        mTargetImageView = (ImageView) findViewById(R.id.imageview);
        mPicasso = Picasso
                .with(getApplicationContext());
        mPicasso.setIndicatorsEnabled(true);
        mPicasso.setLoggingEnabled(true);
        noCaching();
        statsSnapshot();
    }

    private void noCaching(){
        with(getApplicationContext())
                .load(internetUrl)
                .into(mTargetImageView);
    }

    private void statsSnapshot(){
        StatsSnapshot picassoStats = Picasso.with(getApplicationContext()).getSnapshot();
        Log.d("Picasso Stats", "Picasso Stats:"+picassoStats.toString());
    }

}
