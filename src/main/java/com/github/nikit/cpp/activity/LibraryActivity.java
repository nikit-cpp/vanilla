package com.github.nikit.cpp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import com.github.nikit.cpp.aa.PlayListAdapter;
import com.github.nikit.cpp.core.data.Playlist;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.PlaylistImpl;
import com.github.nikit.cpp.core.data.impl.SongImpl;
import org.androidannotations.annotations.*;
import org.kreed.vanilla.R;
import static org.parceler.Parcels.*;
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

    @Bean(value = PlaylistImpl.class)
    Playlist playlist;

    @AfterViews
    void bindAdapter(){
        listContent.setAdapter(adapter);
    }

    @ItemClick
    public void listContentItemClicked(int position){
        playlist.setCurrentSong(position);
        Intent intent = new Intent(this, FullPlaybackActivity_.class);
        startActivity(intent);
    }

}