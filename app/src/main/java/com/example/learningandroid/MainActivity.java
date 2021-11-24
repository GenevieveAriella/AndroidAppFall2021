package com.example.learningandroid;

import static android.widget.Toast.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;

import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.PlayerState;
import com.spotify.protocol.types.Track;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();
        // tbd
    }
    private void connected() {
        // Tbd
    }
    @Override
    protected void onStop() {
        super.onStop();
        // tbd done
    }
    private static final String CLIENT_ID = "14fecf12fef34758ad734d913a897ec4";
    private static final String REDIRECT_URI = "http://com.yourdomain.yourapp/callback";
    private SpotifyAppRemote mSpotifyAppRemote;

//    public void nextScreen(View view) {
//        makeText(getApplicationContext(),"Next Screen", LENGTH_SHORT).show();
//    }
}

///new work for showing playlists
public void getMyPlayList(){
    Map<String, Object> options = new HashMap<>();
    options.put(SpotifyService.LIMIT, 30);

    spotifyService.getMyPlaylists(options, new SpotifyCallback<Pager<PlaylistSimple>>() {
        @Override
        public void failure(SpotifyError spotifyError) {
            Log.d("SearchPager", spotifyError.toString());
        }

        @Override
        public void success(Pager<PlaylistSimple> playlistSimplePager, Response response) {
            List<PlaylistSimple> simples = playlistSimplePager.items;

            for(PlaylistSimple simple : simples){
                Log.d("SearchPager", simple.name);
                Log.d("SearchPager", simple.images.get(1).url);
                //
            }

        }
    });
}

