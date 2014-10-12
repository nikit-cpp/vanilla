package com.github.nikit.cpp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import com.github.nikit.cpp.aa.PlayListAdapter;
import org.androidannotations.annotations.*;
import org.kreed.vanilla.R;

/**
 * Created by Ник on 24.09.14.
 */
@EActivity(R.layout.library_content)
public class LibraryActivity extends Activity {
    @ViewById
    ListView listContent;

    @Bean
    PlayListAdapter adapter;

    @AfterViews
    void refresh(){
        listContent.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @AfterInject
    void bindAdapter() {

    }
}