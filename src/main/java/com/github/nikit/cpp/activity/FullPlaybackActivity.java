package com.github.nikit.cpp.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.SeekBar;
import com.github.nikit.cpp.core.data.Playlist;
import com.github.nikit.cpp.core.data.impl.PlaylistImpl;
import org.androidannotations.annotations.*;
import org.kreed.vanilla.R;

/**
 * The primary playback screen with playback controls and large cover display.
 */
@EActivity(R.layout.full_playback)
public class FullPlaybackActivity extends FragmentActivity {


    @Bean(value = PlaylistImpl.class)
    Playlist playlist;

    ViewPager pager;
    PagerAdapter pagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @AfterViews
    void initViews() {
        pager = (ViewPager) findViewById(R.id.playback_pager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                playlist.setCurrentSong(position);

            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        int currentSong = playlist.getCurrentSongNumber();
        pager.setCurrentItem(currentSong);

    }

    @SeekBarProgressChange(R.id.seek_bar)
    void onProgressChangeOnSeekBar(SeekBar seekBar, int progress) {

    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new FullPlaybackActivityFragment();
        }

        @Override
        public int getCount() {
            return playlist.getSongsCount();
        }

    }
}
