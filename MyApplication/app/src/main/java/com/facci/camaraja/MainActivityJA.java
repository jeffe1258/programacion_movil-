package com.facci.camaraja;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
//import android.provider.MediaStore;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivityJA extends AppCompatActivity {

    Intent intent;
    Button boton;
    Button botoon;
    ImageView imagen;
     Bitmap btma;
    final static  int cons = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_j);

        boton=(Button)findViewById(R.id.fotoBT);
        botoon=(Button)findViewById(R.id.amacenarBT);
        imagen=(ImageView) findViewById(R.id.imagenCapturadaIV);


    }
    public void Click1(View v){
        int botones =v.getId();
        switch (botones){
            case R.id.fotoBT :
                 intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, cons);
                break;
            case R.id.amacenarBT:
                File imagesFolder = new File(
                        Environment.getExternalStorageDirectory(), "Tutorialeshtml5");
                imagesFolder.mkdirs();
                //añadimos el nombre de la imagen
                File image = new File(imagesFolder, "foto.jpg");
                Uri uriSavedImage = Uri.fromFile(image);
                //Le decimos al Intent que queremos grabar la imagen
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);

                Toast.makeText(MainActivityJA.this,"bien",Toast.LENGTH_LONG).show();


                        break;
        }

    }
    @Override
    protected  void onActivityResult(int requestCode,int resultCode,Intent data){
           super.onActivityResult(requestCode,resultCode,data);
       if(resultCode == Activity.RESULT_OK){
            Bundle ext= data.getExtras();
            btma =(Bitmap)ext.get("data");
            imagen.setImageBitmap(btma);
        }

    }
    @SuppressLint("SimpleDateFormat")
      private String getCode()
     {
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
          String date = dateFormat.format(new Date() );
          String photoCode = "pic_" + date;
           return photoCode;
         }
    @Override
      public boolean onCreateOptionsMenu(Menu menu) {
           // Inflate the menu; this adds items to the action bar if it is present.
           getMenuInflater().inflate(R.menu.main, menu);
           return true;
          }

}
