package com.github.nikit.cpp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.PlaylistImpl;
import org.kreed.vanilla.R;

import java.util.ArrayList;
import java.util.List;

public class SongListFragment extends ListFragment {
    private List<Song> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Заголовок 1");
        mCrimes = PlaylistImpl.getInstance().getAllSongs();
        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        // get the Crime from the adapter
        Song c = ((CrimeAdapter)getListAdapter()).getItem(position);
        // start an instance of CrimePagerActivity
        Intent i = new Intent(getActivity(), PlaybackPagerActivity.class);
        i.putExtra(PlaybackFragment.EXTRA_SONG_ID, c.getId());
        startActivityForResult(i, 0);
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
    }

    private class CrimeAdapter extends ArrayAdapter<Song> {
        public CrimeAdapter(List<Song> crimes) {
            super(getActivity(), android.R.layout.simple_list_item_1, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // if we weren't given a view, inflate one
            if (null == convertView) {
                convertView = getActivity().getLayoutInflater()
                    .inflate(R.layout.list_item_song, null);
            }

            // configure the view for this Crime
            Song c = getItem(position);

            TextView titleTextView =
                (TextView)convertView.findViewById(R.id.song_list_item_song_name_TextView);
            titleTextView.setText(c.getName());
            TextView dateTextView =
                (TextView)convertView.findViewById(R.id.song_list_item_song_artist_TextView);
            dateTextView.setText(c.getArtist());

            return convertView;
        }
    }
}

