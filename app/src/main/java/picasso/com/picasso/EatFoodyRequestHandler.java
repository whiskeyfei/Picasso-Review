package picasso.com.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;
import com.squareup.picasso.RequestHandler;

import java.io.IOException;


/**
 * Created by whiskeyfei on 17/1/16.
 */

public class EatFoodyRequestHandler extends RequestHandler {

    private static final String EAT_FOODY_RECIPE_SCHEME = "eatfoody";

    @Override
    public boolean canHandleRequest(Request data) {
        return EAT_FOODY_RECIPE_SCHEME.equals(data.uri.getScheme());
    }

    @Override
    public Result load(Request request, int networkPolicy) throws IOException {
        // do whatever is necessary here to load the image
        // important: you can only return a Result object
        // the constructor takes either a Bitmap or InputStream object, nothing else!

        // get the key for the requested image
        // if the schema is "eatfoody://cupcake", it'd return "cupcake"
        String imageKey = request.uri.getHost();

        Bitmap bitmap;
        if (imageKey.contentEquals("cupcake")) {
            bitmap = BitmapFactory.decodeResource(App.getContext().getResources(), R.mipmap.ic_launcher);
        }
        else if (imageKey.contentEquals("full_cake")) {
            bitmap = BitmapFactory.decodeResource(App.getContext().getResources(), R.mipmap.ic_launcher);
        }
        else {
            // fallback image
            bitmap = BitmapFactory.decodeResource(App.getContext().getResources(), R.mipmap.ic_launcher);
        }

        // return the result with the bitmap and the source info
        return new Result(bitmap, Picasso.LoadedFrom.DISK);
    }
}
