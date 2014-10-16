package com.github.nikit.cpp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.github.nikit.cpp.aa.PlayListAdapter;
import com.github.nikit.cpp.core.data.Song;
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
    void bindAdapter(){
        listContent.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @ItemClick
    public void listContentItemClicked(Song song){
        // переходим на FullPlaybackActivity
        Toast.makeText(LibraryActivity.this, song.getName(), Toast.LENGTH_SHORT).show();
    }

}