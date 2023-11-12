package com.example.ghovulator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Objects;
import java.util.regex.Pattern;

public class KhashActivity extends AppCompatActivity {

    Float ratio = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khash);

        Objects.requireNonNull(getSupportActionBar()).hide();

        EditText kh_all         = (EditText) findViewById(R.id.kh_all);
        EditText kh_sugar       = (EditText) findViewById(R.id.kh_sugar);
        EditText kh_khashkhash  = (EditText) findViewById(R.id.kh_khashkhash);
        EditText kh_jo          = (EditText) findViewById(R.id.kh_jo);
        EditText kh_gandom      = (EditText) findViewById(R.id.kh_gandom);
        EditText kh_all_NS      = (EditText) findViewById(R.id.kh_all_NS);

        Button   btnchel        = (Button) findViewById(R.id.btnchel);
        Button   btnnokh        = (Button) findViewById(R.id.btnnokh);
        Button   calculate      = (Button) findViewById(R.id.calculate);
        Button   clear          = (Button) findViewById(R.id.clear);

        btnchel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KhashActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                KhashActivity.this.finish();
            }
        });

        btnnokh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KhashActivity.this, NokhActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                KhashActivity.this.finish();
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                find(kh_all         .getText()+"",      22);//کل
                find(kh_sugar       .getText()+"",      10);//شکر
                find(kh_khashkhash  .getText()+"",      10);//خشخاش
                find(kh_jo          .getText()+"",       1);//جو
                find(kh_gandom      .getText()+"",       1);//گندم
                find(kh_all_NS      .getText()+"",      12);//بدون شکر

                if (ratio != null) {
                    kh_all         .setText(decimal3(ratio * 22));
                    kh_sugar       .setText(decimal3(ratio * 10));
                    kh_khashkhash  .setText(decimal3(ratio * 10));
                    kh_jo          .setText(decimal3(ratio *  1));
                    kh_gandom      .setText(decimal3(ratio *  1));
                    kh_all_NS      .setText(decimal3(ratio * 12));
                }else
                    Toast.makeText(KhashActivity.this
                            ,"یکی از جا های خالی را پر کنید!"
                            ,Toast.LENGTH_LONG).show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kh_all         .setText("");
                kh_sugar       .setText("");
                kh_khashkhash  .setText("");
                kh_jo          .setText("");
                kh_gandom      .setText("");
                kh_all_NS      .setText("");
                ratio = null;
            }
        });
    }

    private void find (String input,float unit) {
        if (Pattern.matches("[0-9]+[.]?[0-9]*",input+""))
            ratio = Float.parseFloat(input) / unit;
    }

    private String decimal3 (float input){
        String result;
        if (Pattern.matches("[0-9]+[.]+0*",input+""))
            result = (String.format("%.0f", input));
        else
            result = (String.format("%.3f", input));
        return result;
    }
}