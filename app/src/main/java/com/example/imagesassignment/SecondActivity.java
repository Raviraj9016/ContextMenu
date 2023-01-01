package com.example.imagesassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        getData();
        registerForContextMenu(imageView);
    }
    private void initViews(){
        imageView = findViewById(R.id.imageView);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.content_menu, menu);
        menu.setHeaderTitle("Image Menu");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save:
                makeToast("Save Button");
                break;
            case R.id.saveAs:
                makeToast("Save as Button");
                break;
            case R.id.copy:
                makeToast("Copy Button");
                break;
            case R.id.copImageLink:
                makeToast("CopyImage Button");
                break;
            case R.id.download:
                makeToast("Download Button");
        }
        return super.onContextItemSelected(item);
    }
    private void getData(){
        Intent intent = getIntent();
        int data = intent.getIntExtra("data",1);
        if (data == R.drawable.image) {
            makeToast("Image");
        }
        if(data == R.drawable.audio){
            makeToast("Audio");
        }
        if(data == R.drawable.video){
            makeToast("Video");
        }
        imageView.setImageResource(data);
    }

    @Override
    public void onClick(View view) {
        if(view == btnBack){
            Intent intent = getIntent();
            setResult(1,intent);
            finish();

        }

    }
    private void makeToast(String text){
        Toast.makeText(SecondActivity.this, text, Toast.LENGTH_LONG).show();
    }
}