package com.github.nikit.cpp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.kreed.vanilla.R;

/**
 * The primary playback screen with playback controls and large cover display.
 */
@EActivity(R.layout.full_playback)
public class FullPlaybackActivity extends Activity {

    /*@ViewById
    TextView elapsed;*/

    /*@Override public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView( R.layout.full_playback);
    }*/
    /*@AfterViews
    void initViews() {
        elapsed.setText("elapsed");
    }*/
}
