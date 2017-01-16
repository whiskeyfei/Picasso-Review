package picasso.com.picasso;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoActivity01 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01);

        ImageView targetImageView = (ImageView) findViewById(R.id.imageview);
        String internetUrl = "http://i.imgur.com/DvpvklR.png";
        Picasso.with(getApplicationContext())
                .load(internetUrl)
                .into(targetImageView);
    }
}
