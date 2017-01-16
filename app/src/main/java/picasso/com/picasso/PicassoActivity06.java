package picasso.com.picasso;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoActivity06 extends Activity {


    String internetUrl = "http://i.imgur.com/DvpvklR.png";
    ImageView mTargetImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_05);
        mTargetImageView = (ImageView) findViewById(R.id.imageview);
        resize();
//        scaleDown();
//        CenterCrop();
//        CenterInside();
//        fit();
    }

    private void resize(){
        Picasso
                .with(getApplicationContext())
                .load(internetUrl)
                .resize(600, 200) // resizes the image to these dimensions (in pixel). does not respect aspect ratio
                .into(mTargetImageView);
    }

    private void scaleDown(){
        Picasso
                .with(getApplicationContext())
                .load(internetUrl)
                .resize(6000, 2000)
                .onlyScaleDown() // the image will only be resized if it's bigger than 6000x2000 pixels.
                .into(mTargetImageView);
    }


    private void CenterCrop(){
        Picasso
                .with(getApplicationContext())
                .load("http://futurestud.io/non_existing_image.png")
                .resize(600, 200) // resizes the image to these dimensions (in pixel)
                .centerCrop()
                .into(mTargetImageView);
    }

    private void CenterInside(){
        Picasso
                .with(getApplicationContext())
                .load("http://futurestud.io/non_existing_image.png")
                .resize(600, 200) // resizes the image to these dimensions (in pixel)
                .centerInside()
                .into(mTargetImageView);
    }

    private void fit(){
        Picasso
                .with(getApplicationContext())
                .load("http://futurestud.io/non_existing_image.png")
                .fit()
                // call .centerInside() or .centerCrop() to avoid a stretched image
                .into(mTargetImageView);
    }

}
