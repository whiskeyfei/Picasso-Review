package picasso.com.picasso;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class PicassoActivity11 extends Activity {


    String internetUrl = "http://i.imgur.com/DvpvklR.png";
    ImageView mTargetImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_05);
        mTargetImageView = (ImageView) findViewById(R.id.imageview);
        noCaching();
    }

    private void noCaching(){
        Picasso
                .with(getApplicationContext())
                .load(internetUrl)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(mTargetImageView);
    }

    private void noDiskCache(){
        Picasso
                .with(getApplicationContext())
                .load(internetUrl)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(mTargetImageView);
    }

    private void noAllCache() {
        Picasso
                .with(getApplicationContext())
                .load(internetUrl)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(mTargetImageView);
    }


}
