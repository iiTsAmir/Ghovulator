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



public class NokhActivity extends AppCompatActivity {

    Float ratio = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nokh);

        Objects.requireNonNull(getSupportActionBar()).hide();

        EditText no_all           = (EditText) findViewById(R.id.no_all       );
        EditText no_sugar         = (EditText) findViewById(R.id.no_sugar     );
        EditText no_nokhod        = (EditText) findViewById(R.id.no_nokhod    );
        EditText no_nargil        = (EditText) findViewById(R.id.no_nargil    );
        EditText no_hels          = (EditText) findViewById(R.id.no_hels      );
        EditText no_all_NS        = (EditText) findViewById(R.id.no_all_NS    );

        Button no_btnchel         = (Button) findViewById(R.id.no_btnchel);
        Button no_btnkhash        = (Button) findViewById(R.id.no_btnkhash);
        Button no_calculate       = (Button) findViewById(R.id.no_calculate);
        Button no_clear           = (Button) findViewById(R.id.no_clear);

        no_btnchel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NokhActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                NokhActivity.this.finish();
            }
        });

        no_btnkhash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NokhActivity.this, KhashActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                NokhActivity.this.finish();
            }
        });
        no_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                find(no_all     .getText()+"",      2.765f);//کل
                find(no_sugar   .getText()+"",        1.5f);//شکر
                find(no_nokhod  .getText()+"",           1);//نخود
                find(no_nargil  .getText()+"",       0.25f);//پودر نارگیل
                find(no_hels    .getText()+"",      0.015f);//هل سبز
                find(no_all_NS  .getText()+"",      1.265f);//بدون شکر

                if (ratio != null) {
                    no_all     .setText(decimal3(ratio * 2.765f));
                    no_sugar   .setText(decimal3(ratio *   1.5f));
                    no_nokhod  .setText(decimal3(ratio *      1));
                    no_nargil  .setText(decimal3(ratio *  0.25f));
                    no_hels    .setText(decimal3(ratio * 0.015f));
                    no_all_NS  .setText(decimal3(ratio * 1.265f));
                }else
                    Toast.makeText(NokhActivity.this
                            ,"یکی از جا های خالی را پر کنید!"
                            ,Toast.LENGTH_LONG).show();
            }
        });
        no_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                no_all     .setText("");
                no_sugar   .setText("");
                no_nokhod  .setText("");
                no_nargil  .setText("");
                no_hels    .setText("");
                no_all_NS  .setText("");
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