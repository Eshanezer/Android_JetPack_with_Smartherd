package com.ezer.jetpack.lifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.ezer.jetpack.R;

public class MainActivity extends AppCompatActivity {

    String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*------------------------------------------------------ LIFECYCLE MANAGEMENT ------------------
    ---------------------------------------------------------------------------------------------*/

/*These components help you produce better-organized, and often lighter-weight code, that is easier to maintain.*/

// OnCreate OnPause OnResume OnDestroy
        /*Api android developments waladi life cycle manage karana widihak
        * Observer ekak hadala lifecycle management karannath puluwan
        * Annotation use karala eka karanne
        * SCREEN ROTATION waladi palaweniyata observer eka call wela thmai Activity eke lifecycle event call wenne
        * ADVANTAGES -
        *              * Less Code
        *              * Screen Rotation lifecycle manage karanna lesi
        *
        * DISADVANTAGES -
        *              * Wada Wadi
        * */


        Log.i(TAG, "OWNER - OBSERVER CREATED");
        getLifecycle().addObserver(new MainActivityObserver());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "OWNER - OBSERVER ON PAUSED CREATED");
    }
}
