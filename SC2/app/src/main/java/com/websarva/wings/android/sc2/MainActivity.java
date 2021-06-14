package com.example.sc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//①ボタンを押した時に画面遷移するように下記のコードを修正してください
public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ボタンを設定
        //1-1 activity_main.xmlに用意されているボタンを宣言しなさい。
        /*ここに記述*/
        
        //ボタンに対するリスナを設定
        button1.setOnClickListener((View v) -> {
                //1-2 intentクラスを生成し、遷移先画面を指定してください。
                //point 第1引数はgetApplication()を使用してください。
                /*ここに記述*/

                //1-3 1-1で生成したintentクラスを使用し、遷移先の画面を起動する処理を記述してください
                /*ここに記述*/
                
        });
    }
}
