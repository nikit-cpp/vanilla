package com.github.nikit.cpp.aa;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.nikit.cpp.core.data.Song;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.kreed.vanilla.R;

/**
 * Created by Ник on 25.09.14.
 */
@EViewGroup(R.layout.library_song_item)
public class PersonItemView extends LinearLayout {

    @ViewById
    TextView nameView;

    @ViewById
    TextView artistView;

    public PersonItemView(Context context) {
        super(context);
    }

    public void bind(Song song) {
        nameView.setText(song.getName());
        artistView.setText(song.getArtist());
    }
}