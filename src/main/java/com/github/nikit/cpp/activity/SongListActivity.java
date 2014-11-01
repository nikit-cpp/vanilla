package com.github.nikit.cpp.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;

/**
 * Created by Ник on 24.09.14.
 */
public class SongListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new SongListFragment();
    }
}