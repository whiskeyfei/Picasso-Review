package picasso.com.picasso;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class PicassoActivity09 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);
        initTarget();
    }

    private void initTarget() {
        final ImageView targetImageView = (ImageView) findViewById(R.id.imageview);
        String internetUrl = "http://i.imgur.com/DvpvklR.png";
        Picasso.with(getApplicationContext())
                .load(internetUrl)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                targetImageView.setImageBitmap(bitmap);
                            }
                        });
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {

                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });
    }
}
