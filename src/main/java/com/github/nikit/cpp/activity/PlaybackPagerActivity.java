package com.github.nikit.cpp.activity;

import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.SeekBar;
import com.github.nikit.cpp.core.data.Playlist;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.PlaylistImpl;
import org.kreed.vanilla.R;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The primary playback screen with playback controls and large cover display.
 */
public class PlaybackPagerActivity extends FragmentActivity {

    ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);

        final List<Song> crimes = PlaylistImpl.getInstance().getAllSongs();

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public int getCount() {
                return crimes.size();
            }
            @Override
            public Fragment getItem(int pos) {
                return PlaybackFragment.newInstance(pos);
            }
        });

        int crimeId = getIntent().getIntExtra(PlaybackFragment.EXTRA_SONG_ID, 0);
        mViewPager.setCurrentItem(crimeId);
    }
}
