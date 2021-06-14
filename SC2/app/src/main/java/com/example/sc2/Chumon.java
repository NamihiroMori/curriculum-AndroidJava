package com.example.sc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chumon extends AppCompatActivity {

    //合計金額用のプロパティ
    int num;
    //spinnerの値用のプロパティ
    int s1;
    int s2;

    //スピナーリセット用のリスト
    List<Spinner> arr = new ArrayList<>();
    //金額算出用のメソッド
    public void math(int a, int b, int c){
        if(a < b) {
            num += ((b - a)*c);
        }else if(a > b){
            num -= ((a - b)*c);
            //負の値を取らないための処理
            if(num < 0){
                num = 0;
            }
        }
    }

    //②料理の種類と数を指定して注文する処理を記述しなさい
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chumon);

        //2-1 デザインに用意されているButtonとSpinnerをそれぞれ宣言しなさい。
        //point idは属性をそれぞれ使用すること
        //注意 spinnerの変数名はそれぞれspinner1,spinner2にしてください。

        //テキストビューの設定
        final TextView textView = findViewById(R.id.textView);

        //ボタンの設定(2個)
        /*ここに記述
        ここに記述*/
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        //Spinnerオブジェクトを取得(2個)
        /*ここに記述
        ここに記述*/
        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);

        //spinnerを配列に追加してまとめて処理
        arr.add(spinner1);
        arr.add(spinner2);

        //スピナーのリスナ設定(回鍋肉)
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //spinnerを取得
                Spinner spinner = (Spinner)parent;

                //spinnerオブジェクトをString型に変換
                String item = (String) spinner.getSelectedItem();

                //Stringに変換したspinnerをint型に変換
                int i = Integer.parseInt(item);

                //2-2 上で用意されている金額算出用のメソッドを呼び出しなさい。下にもあります！
                //point 第1、第2引数にはフィールド変数、第3引数はstring.xmlを確認し、回鍋肉の金額を入れてください。
                /*ここに記述*/
                String strPrice1 = getString(R.string.price1).replace("円", "");
                int price1 = Integer.parseInt(strPrice1);
                math(s1, i, price1);

                //合計金額をStringに変換
                String s = String.valueOf(num);

                //金額をテキストビューにセット
                textView.setText(s);

                //フィールド変数にspinnerの値を代入
                s1 = i;
            }

            //何もなかった場合の処理
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });

        //スピナーのリスナ設定(唐揚げ)
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner)parent;
                String item = (String) spinner.getSelectedItem();

                int i = Integer.parseInt(item);

                //2-2 金額算出用のメソッドの呼びだし
                //第３引数にはstring.xmlを確認し唐揚げの金額を入れてください。
                /*ここに記述*/
                String strPrice2 = getString(R.string.price2).replace("円", "");
                int price2 = Integer.parseInt(strPrice2);
                math(s2, i, price2);

                String s = String.valueOf(num);

                textView.setText(s);
                s2 = i;
            }
            //何も選択されなかった場合の処理
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });
        //注文に進むボタン
        button2.setOnClickListener((View v) -> {

                //格納されたspinnerの値をstringに変換
                String s3 = String.valueOf(s1);
                String s4 = String.valueOf(s2);

                //intentクラスの生成
                final Intent intent = new Intent(getApplication(), com.example.sc2.kart.class);

                //spinnerの値をkart.javaに渡しなさい。
                //注意 渡す際のキーは上からDATA1、DATA2にしてください。
                intent.putExtra("DATA1", s3);
                intent.putExtra("DATA2", s4);

                //遷移先画面の起動
                startActivity(intent);
        });

        //クリアボタンの処理
        button3.setOnClickListener((View v) -> {

                //注文金額をリセットする
                num = 0;
                String s = String.valueOf(num);
                textView.setText(s);

                //スピナーの値をsetSelectionでリセットする
                for(int i = 0; i < arr.size(); i++){
                    arr.get(i).setSelection(0);
                }
        });
    }
}
