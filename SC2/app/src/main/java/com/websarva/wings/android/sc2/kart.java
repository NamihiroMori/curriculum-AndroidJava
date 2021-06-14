package com.example.sc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class kart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kart);

        //戻るボタンの設定
        Button button = findViewById(R.id.back_button);

        //3-1 intentを使用してデータを受け取る処理を記述してください。
        /*ここに記述*/

        String num1 = intent.getStringExtra("DATA1");
        String num2 = intent.getStringExtra("DATA2");

        //テキストビューの設定
        final TextView price = findViewById(R.id.send_price);
        final TextView price2 = findViewById(R.id.send_price2);
        final TextView t_price = findViewById(R.id.num);
        final TextView t_price2 = findViewById(R.id.num2);
        final TextView all_price = findViewById(R.id.total_price);

        //価格の算出
        //注意 色が変わってる部分がありますがスルーして大丈夫です。

        //回鍋肉の価格
        int i = Integer.parseInt(num1);
        int send_price = i * 800;
        String s = String.valueOf(send_price);

        //唐揚げの価格
        int j = Integer.parseInt(num2);
        int send_price2 = j * 650;
        String t = String.valueOf(send_price2);

        //合計金額の算出
        int total_price = send_price + send_price2;
        String u = String.valueOf(total_price);

        //3-2 金額と個数を適切なテキストビューにセットしてください。
        [ここを修正].setText(u);
        [ここを修正].setText(num1);
        [ここを修正].setText(num2);
        [ここを修正].setText(s);
        [ここを修正].setText(t);

        //戻るボタンを押した時の処理
        button.setOnClickListener((View v) -> {
                finish();
        });
    }
}
