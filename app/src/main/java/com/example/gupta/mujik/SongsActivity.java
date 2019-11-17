package com.example.gupta.mujik;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.List;

public class SongsActivity extends AppCompatActivity
implements DiscreteScrollView.ScrollStateChangeListener<SongAdapter.ViewHolder>,
            DiscreteScrollView.OnItemChangedListener<SongAdapter.ViewHolder>{

    List<Song> songs;
    SongView songview;
    DiscreteScrollView songpicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        songview = (SongView) findViewById(R.id.song_view);

        SongStation songst=new SongStation();
        songs = songst.getSongs();

        songpicker = (DiscreteScrollView) findViewById(R.id.song_picker);
        songpicker.setSlideOnFling(true);
        songpicker.setAdapter(new SongAdapter(songs));
        songpicker.addOnItemChangedListener(this);
        songpicker.addScrollStateChangeListener(this);
        songpicker.scrollToPosition(2);
        songpicker.setItemTransitionTimeMillis(150);
        songpicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        songview.setSong(songs.get(0));
    }

    @Override
    public void onCurrentItemChanged(@Nullable SongAdapter.ViewHolder holder, int position) {
        //viewHolder will never be null, because we never remove items from adapter's list
        if (holder != null) {
            songview.setSong(songs.get(position));
            holder.showText();
        }
    }

    @Override
    public void onScrollStart(@NonNull SongAdapter.ViewHolder holder, int position) {
        holder.hideText();
    }

    @Override
    public void onScroll(
            float position,
            int currentIndex, int newIndex,
            @Nullable SongAdapter.ViewHolder currentHolder,
            @Nullable SongAdapter.ViewHolder newHolder) {
        Song current = songs.get(currentIndex);
        if (newIndex >= 0 && newIndex < songpicker.getAdapter().getItemCount()) {
            Song next = songs.get(newIndex);
            songview.onScroll(1f - Math.abs(position), current, next);
        }
    }

    @Override
    public void onScrollEnd(@NonNull SongAdapter.ViewHolder holder, int position) {

    }
}
