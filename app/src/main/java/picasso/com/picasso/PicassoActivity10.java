package picasso.com.picasso;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PicassoActivity10 extends Activity {


    String internetUrl = "http://i.imgur.com/DvpvklR.png";
    ImageView mTargetImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_05);
        mTargetImageView = (ImageView) findViewById(R.id.imageview);
//        SimpleRotation();
        placeholder();
    }

    private void SimpleRotation(){
        Picasso
                .with(getApplicationContext())
                .load(internetUrl)
//                .rotate(90f)
                .rotate(45f, 200f, 100f)//Complex Rotation
                .into(mTargetImageView);
    }

    private void placeholder(){
        Picasso
                .with(getApplicationContext())
                .load(internetUrl)
                .transform(new GrayscaleTransformation(Picasso.with(getApplicationContext())))
                .into(mTargetImageView);
    }

    private void noPlaceholder(){
        Picasso
                .with(getApplicationContext())
                .load(internetUrl)
                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .into(mTargetImageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        // once the image is loaded, load the next image
                        Picasso
                                .with(getApplicationContext())
                                .load(internetUrl)
                                .noPlaceholder() // but don't clear the imageview or set a placeholder; just leave the previous image in until the new one is ready
                                .into(mTargetImageView);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    private void error(){
        Picasso
                .with(getApplicationContext())
                .load("http://futurestud.io/non_existing_image.png")
                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .error(R.mipmap.ic_launcher) // will be displayed if the image cannot be loaded
                .into(mTargetImageView);
    }

    private void noFade(){
        Picasso
                .with(getApplicationContext())
                .load("http://futurestud.io/non_existing_image.png")
                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .error(R.mipmap.ic_launcher) // will be displayed if the image cannot be loaded
                .noFade()
                .into(mTargetImageView);
    }
}
