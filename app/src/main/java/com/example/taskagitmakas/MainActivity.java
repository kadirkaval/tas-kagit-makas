package com.example.taskagitmakas;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button yeniOyun, btnTas, btnKagit, btnMakas;
    TextView sonuc1, sonuc2;
    ImageView sagImg, solImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Buttonlar
        yeniOyun = (Button) findViewById(R.id.yeniOyun);
        btnTas = (Button) findViewById(R.id.btnTas);
        btnKagit = (Button) findViewById(R.id.btnKagit);
        btnMakas = (Button) findViewById(R.id.btnMakas);
        // Textview
        sonuc1 = (TextView) findViewById(R.id.sonuc1);
        sonuc2 = (TextView) findViewById(R.id.sonuc2);
        //Imge
        sagImg = (ImageView) findViewById(R.id.imgSag);
        solImg = (ImageView) findViewById(R.id.imgSol);

        int[] img = new int[]{R.drawable.tasimgsol, R.drawable.kagitimgsol, R.drawable.makasimgsol};
        // 0 = taş , 1 = kağıt , 2 = makas

        //Oyuncu Skorları
        final int[] oyuncu1 = {0};
        final int[] oyuncu2 = {0};

        //Button olayları

        yeniOyun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sonuc1.setText("0");
                sonuc2.setText("0");
                sagImg.setImageResource(R.drawable.tasimgsag);
                solImg.setImageResource(img[0]);
                oyuncu1[0]=0;
                oyuncu2[0]=0;
            }
        });

        btnTas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sagImg.setImageResource(R.drawable.tasimgsag);
                int index = getRandomImg();
                solImg.setImageResource(img[index]);
                if(index==1){
                    oyuncu1[0]++;
                    sonuc1.setText(String.valueOf(oyuncu1[0]));
                } else if (index==2) {
                    oyuncu2[0]++;
                    sonuc2.setText(String.valueOf(oyuncu2[0]));
                }
            }
        });
        btnKagit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sagImg.setImageResource(R.drawable.kagitimgsag);
                int index = getRandomImg();
                solImg.setImageResource(img[index]);
                if(index==0){
                    oyuncu2[0]++;
                    sonuc2.setText(String.valueOf(oyuncu2[0]));
                } else if (index==2) {
                    oyuncu1[0]++;
                    sonuc1.setText(String.valueOf(oyuncu1[0]));
                }
            }
        });
        btnMakas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sagImg.setImageResource(R.drawable.makasimgsag);
                int index = getRandomImg();
                solImg.setImageResource(img[index]);
                if(index==0){
                    oyuncu1[0]++;
                    sonuc1.setText(String.valueOf(oyuncu1[0]));
                } else if (index==1) {
                    oyuncu2[0]++;
                    sonuc2.setText(String.valueOf(oyuncu2[0]));
                }
            }
        });
    }
    public int getRandomImg(){
        Random r=new Random(); //random sınıfı
        int a=r.nextInt(3);
        return a;
    }
}