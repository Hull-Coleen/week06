package com.example.week06app;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> myStringArray = new ArrayList<>();
    File file;
    String filename;
    FileOutputStream outputStream;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void createFile(View view) {
        filename = "numbers.txt";
        file = new File(this.getFilesDir(), filename);

      /*  for (int i = 0; i < 10; i++) {
            try {
                outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                outputStream.write(++i);
                Thread.sleep(250);
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        for ( int i = 0;  i< 10; i++) {
            String num = String.valueOf(i+1);
            myStringArray.add(num);
        }

    }
    public void writeView(View view) {
         adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, myStringArray);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
    public void clearView(View view) {
        adapter.clear();
    }
}
