package picasso.com.picasso;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

public class PicassoActivity04 extends Activity {
    public static String[] eatFoodyImages = {
            "http://i.imgur.com/rFLNqWI.jpg",
            "http://i.imgur.com/C9pBVt7.jpg",
            "http://i.imgur.com/rT5vXE1.jpg",
            "http://i.imgur.com/aIy5R2k.jpg",
            "http://i.imgur.com/MoJs9pT.jpg",
            "http://i.imgur.com/S963yEM.jpg",
            "http://i.imgur.com/rLR2cyc.jpg",
            "http://i.imgur.com/SEPdUIx.jpg",
            "http://i.imgur.com/aC9OjaM.jpg",
            "http://i.imgur.com/76Jfv9b.jpg",
            "http://i.imgur.com/fUX7EIB.jpg",
            "http://i.imgur.com/syELajx.jpg",
            "http://i.imgur.com/COzBnru.jpg",
            "http://i.imgur.com/Z3QjilA.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_04);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new SimpleImageListAdapter(getApplicationContext(), eatFoodyImages));
    }

    public class SimpleImageListAdapter extends ArrayAdapter {
        private Context context;
        private LayoutInflater inflater;

        private String[] imageUrls;

        public SimpleImageListAdapter(Context context, String[] imageUrls) {
            super(context, R.layout.listview_item_image, imageUrls);

            this.context = context;
            this.imageUrls = imageUrls;

            inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (null == convertView) {
                convertView = inflater.inflate(R.layout.listview_item_image, parent, false);
            }

            ImageView imageView = (ImageView) convertView;
            if (TextUtils.isEmpty(imageUrls[position])) {
                // option 1: cancel Picasso request and clear ImageView
                Picasso
                        .with(context)
                        .cancelRequest(imageView);

                imageView.setImageDrawable(null);

                // option 2: load placeholder with Picasso
                /*
                Picasso
                        .with(context)
                        .load(R.drawable.floorplan)
                        .into(imageView);
                */
            } else {
                Picasso
                        .with(context)
                        .load(imageUrls[position])
                        .fit() // will explain later
                        .into(imageView);
            }
            return convertView;
        }
    }
}
