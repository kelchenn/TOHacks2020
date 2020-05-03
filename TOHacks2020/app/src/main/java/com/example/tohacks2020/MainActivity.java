package com.example.tohacks2020;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tohacks2020.R;

public class MainActivity extends AppCompatActivity {

    List<String> activities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonRandomize = (Button) findViewById(R.id.randomizeButton);
        final TextView randomActivity = (TextView) findViewById(R.id.activityText);

        try {
            File f = new File(MainActivity.this.getFilesDir() + "/text");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                activities.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final Random r = new Random();
        randomActivity.setText(activities.get(r.nextInt((activities.size()))));

        buttonRandomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomActivity.setText(activities.get(r.nextInt((activities.size()))));
            }
        });
    }
}
