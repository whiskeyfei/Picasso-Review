package picasso.com.picasso;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

public class PicassoActivity02 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);
        initImageFile();
        initImageRes();
        initImageURL();
    }

    private void initImageRes() {
        ImageView targetImageView = (ImageView) findViewById(R.id.imageview_res);
        int resourceId = R.mipmap.ic_launcher;
        Picasso.with(getApplicationContext())
                .load(resourceId)
                .into(targetImageView);
    }

    private void initImageFile() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Running.jpg");
        ImageView targetImageView_File = (ImageView) findViewById(R.id.imageview_file);
        Picasso.with(getApplicationContext())
                .load(file)
                .into(targetImageView_File);

    }

    private void initImageURL() {
        Uri uri = resourceIdToUri(getApplicationContext(), R.mipmap.ic_launcher);
        ImageView targetImageView_URL = (ImageView) findViewById(R.id.imageview_url);
        Picasso.with(getApplicationContext())
                .load(uri)
                .into(targetImageView_URL);
    }

    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    private static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }
}
