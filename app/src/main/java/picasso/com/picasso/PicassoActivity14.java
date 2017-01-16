package picasso.com.picasso;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoActivity14 extends Activity {


    String internetUrl = "http://i.imgur.com/DvpvklR.png";
    ImageView mTargetImageView;
    Picasso mPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_05);
        mTargetImageView = (ImageView) findViewById(R.id.imageview);
        Picasso.Builder picassoBuilder = new Picasso.Builder(getApplicationContext());
        picassoBuilder.addRequestHandler(new EatFoodyRequestHandler());

        mPicasso.setIndicatorsEnabled(true);
        mPicasso = picassoBuilder.build();
        mPicasso.setLoggingEnabled(true);
        load();
        setSingletonInstance(mPicasso);
    }

    private void load(){
        mPicasso.with(getApplicationContext())
//                .load("eatfoody://cupcake")
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
