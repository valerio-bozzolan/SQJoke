/*
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/


package com.example.doc_antony.sqjoke;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean clicked = false;
    boolean paused = false;
    MediaPlayer player;
    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (ImageButton) findViewById(R.id.ib1);
        button.setBackgroundResource(R.drawable.play);
        player = MediaPlayer.create(MainActivity.this, R.raw.music);
        Toast.makeText(getBaseContext(), "Have Fun :) !", Toast.LENGTH_SHORT).show();
    }

    // this is the code from android "immersive mode"
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            getWindow().getDecorView()
                    .setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    );
        }
    }


    void buttonClicked(View v) {

        if (!clicked) {
            clicked = true;
            player.start();
            button.setBackgroundResource(R.drawable.pause);

        } else {
            if (!paused) {
                paused = true;
                player.pause();
                button.setBackgroundResource(R.drawable.play);
            } else {
                player.start();
                paused = false;
                button.setBackgroundResource(R.drawable.play);

            }
        }

        if (player.isPlaying()) button.setBackgroundResource(R.drawable.pause);
        else button.setBackgroundResource(R.drawable.play);


    }


}
