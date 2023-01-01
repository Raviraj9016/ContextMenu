package com.example.imagesassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    final int IMAGES = 1, AUDIO = 2, VIDEO = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add(IMAGES,1,1,"Images");
        menuItem = menu.add(AUDIO,2,2,"Audio");
        menuItem = menu.add(VIDEO,3,3,"Video");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == IMAGES){
            changeActivity(R.drawable.image);
        }
        if(item.getItemId() == AUDIO){
            changeActivity(R.drawable.audio);
        }
        if(item.getItemId() == VIDEO){
            changeActivity(R.drawable.video);
        }
        return super.onOptionsItemSelected(item);
    }
    private void changeActivity(int data){
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}