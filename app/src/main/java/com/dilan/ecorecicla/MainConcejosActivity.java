package com.dilan.ecorecicla;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainConcejosActivity extends AppCompatActivity {

    VideoView videoView0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_concejos);


        videoView0 = (VideoView)findViewById(R.id.videoView0);


        videoView0.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.r2));

        videoView0.start();

    }
}