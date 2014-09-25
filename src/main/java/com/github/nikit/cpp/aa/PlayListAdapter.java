package com.github.nikit.cpp.aa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.github.nikit.cpp.core.data.Playlist;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.PlaylistImpl;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import com.github.nikit.cpp.aa.PersonItemView_;

import java.util.List;

/**
 * Created by Ник on 25.09.14.
 */
@EBean
public class PlayListAdapter extends BaseAdapter {

    List<Song> persons;

    @Bean(PlaylistImpl.class)
    Playlist personFinder;

    @RootContext
    Context context;

    @AfterInject
    void initAdapter() {
        persons = personFinder.findAll();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PersonItemView personItemView;
        if (convertView == null) {
            personItemView = PersonItemView_.build(context);
        } else {
            personItemView = (PersonItemView) convertView;
        }

        personItemView.bind(getItem(position));

        return personItemView;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Song getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}