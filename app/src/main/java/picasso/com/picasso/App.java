package picasso.com.picasso;

import android.app.Application;
import android.content.Context;

/**
 * Created by whiskeyfei on 17/1/16.
 */

public class App extends Application{


    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
