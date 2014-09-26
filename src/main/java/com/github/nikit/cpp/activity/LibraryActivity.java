package com.github.nikit.cpp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import com.github.nikit.cpp.aa.PlayListAdapter;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.kreed.vanilla.R;

/**
 * Created by Ник on 24.09.14.
 */
@EActivity(R.layout.library_content)
public class LibraryActivity extends Activity {
    @ViewById
    ListView listContent;

    /*@Override public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView( R.layout.full_playback);
    }*/

    @Bean
    PlayListAdapter adapter;

    @AfterViews
    void bindAdapter() {
        listContent.setAdapter(adapter);
    }

    @AfterViews
    void initViews() {

    }
}