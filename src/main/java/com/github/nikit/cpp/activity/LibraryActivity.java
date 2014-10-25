package com.github.nikit.cpp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import com.github.nikit.cpp.aa.PlayListAdapter;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.SongImpl;
import org.androidannotations.annotations.*;
import org.kreed.vanilla.R;
import org.parceler.Parcels;

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
        Intent intent = new Intent(this, FullPlaybackActivity_.class);

        intent.putExtra(Song.class.getCanonicalName(), Parcels.wrap(song));

        startActivity(intent);
    }

}