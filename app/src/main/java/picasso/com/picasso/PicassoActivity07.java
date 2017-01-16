package picasso.com.picasso;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoActivity07 extends Activity {


    String internetUrl = "http://i.imgur.com/DvpvklR.png";
    ImageView mTargetImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_05);
        mTargetImageView = (ImageView) findViewById(R.id.activity_request_priority_hero);
        initheroImage();
        initimageViewLowPrioLeft();
        imageViewLowPrioRight();
    }

    private void initheroImage(){
        Picasso
                .with(getApplicationContext())
                .load(internetUrl)
                .fit()
                .priority(Picasso.Priority.HIGH)
                .into(mTargetImageView);
    }

    private void initimageViewLowPrioLeft(){
       ImageView imageViewLowPrioLeft = (ImageView) findViewById(R.id.activity_request_priority_low_left);
        Picasso
                .with(getApplicationContext())
                .load(internetUrl)
                .fit()
                .priority(Picasso.Priority.LOW)
                .into(imageViewLowPrioLeft);
    }


    private void imageViewLowPrioRight(){
        ImageView imageViewLowPrioRight = (ImageView) findViewById(R.id.activity_request_priority_low_right);
        Picasso
                .with(getApplicationContext())
                .load(internetUrl)
                .fit()
                .priority(Picasso.Priority.LOW)
                .into(imageViewLowPrioRight);
    }


}
