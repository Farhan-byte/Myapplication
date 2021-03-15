package com.example.simplesignup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class labtask3 extends AppCompatActivity {
 private Button btcamera;
private ImageView ivcapture;
private int reqcode=14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_open);
        btcamera=findViewById(R.id.button6);
        ivcapture=findViewById(R.id.imageView);
        btcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkSelfPermission()) {
                    requestpermission();}
                else {
                    Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(in, reqcode);
                }

            }
        });
    }
    public boolean checkSelfPermission(){
        if( ActivityCompat.checkSelfPermission(labtask3.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            return true;}
        else {
            return false;
        }
    }private void requestpermission(){
        ActivityCompat.requestPermissions(labtask3.this, new String[]{Manifest.permission.CAMERA},reqcode);
    }
    @Override
    protected void  onActivityResult(int requestCode, int resultCode, @Nullable Intent data) //requestcode=reqcode, resultcode if image tick or cross,intentdata=image captured
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==reqcode){
            if(resultCode==RESULT_OK){
                Bundle bundle=data.getExtras();
                Bitmap img=(Bitmap)bundle.get("data");
                ivcapture.setImageBitmap(img);
            }
        }
    }

}