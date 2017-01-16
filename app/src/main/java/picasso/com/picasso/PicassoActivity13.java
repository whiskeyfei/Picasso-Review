package picasso.com.picasso;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoActivity13 extends Activity {


    String internetUrl = "http://i.imgur.com/DvpvklR.png";
    ImageView mTargetImageView;
    Picasso mPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_05);
        mTargetImageView = (ImageView) findViewById(R.id.imageview);
        mPicasso = Picasso.with(getApplicationContext());
        //or
        Picasso.Builder picassoBuilder = new Picasso.Builder(getApplicationContext());
//        picassoBuilder.downloader(new OkHttpDownloader(new OkHttpClient()));
        mPicasso.setIndicatorsEnabled(true);
        mPicasso = picassoBuilder.build();
        mPicasso.setLoggingEnabled(true);
        noCaching();
        setSingletonInstance(mPicasso);
    }

    private void noCaching(){
        mPicasso.with(getApplicationContext())
                .load(internetUrl)
                .into(mTargetImageView);
    }

    private void setSingletonInstance(Picasso picasso){
        try {
            Picasso.setSingletonInstance(picasso);
        }catch (IllegalStateException e){
            e.printStackTrace();
            // Picasso instance was already set
            // cannot set it after Picasso.with(Context) was already in use
        }
    }

}
