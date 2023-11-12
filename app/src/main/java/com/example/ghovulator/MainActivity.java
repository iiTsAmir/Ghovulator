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

public class MainActivity extends AppCompatActivity {

    Float ratio = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();

        EditText ch_all         = (EditText) findViewById(R.id.ch_all       );
        EditText ch_sugar       = (EditText) findViewById(R.id.ch_sugar     );
        EditText ch_khashkhash  = (EditText) findViewById(R.id.ch_khashkhash);
        EditText ch_khorfe      = (EditText) findViewById(R.id.ch_khorfe    );
        EditText ch_gandom      = (EditText) findViewById(R.id.ch_gandom    );
        EditText ch_jo          = (EditText) findViewById(R.id.ch_jo        );
        EditText ch_konjed      = (EditText) findViewById(R.id.ch_konjed    );
        EditText ch_katan       = (EditText) findViewById(R.id.ch_katan     );
        EditText ch_kanaf       = (EditText) findViewById(R.id.ch_kanaf     );
        EditText ch_ghahve      = (EditText) findViewById(R.id.ch_ghahve    );
        EditText ch_aftaab      = (EditText) findViewById(R.id.ch_aftaab    );
        EditText ch_moordane    = (EditText) findViewById(R.id.ch_moordane  );
        EditText ch_kaahoo      = (EditText) findViewById(R.id.ch_kaahoo    );
        EditText ch_geshniz     = (EditText) findViewById(R.id.ch_geshniz   );
        EditText ch_siyahdane   = (EditText) findViewById(R.id.ch_siyahdane );
        EditText ch_raziyane    = (EditText) findViewById(R.id.ch_raziyane  );
        EditText ch_hel         = (EditText) findViewById(R.id.ch_hel       );
        EditText ch_jadva       = (EditText) findViewById(R.id.ch_jadva     );
        EditText ch_tiiz        = (EditText) findViewById(R.id.ch_tiiz      );
        EditText ch_all_NS      = (EditText) findViewById(R.id.ch_all_NS    );

        Button ch_btnkhash      = (Button) findViewById(R.id.ch_btnkhash    );
        Button ch_btnnokh       = (Button) findViewById(R.id.ch_btnnokh     );
        Button ch_calculate     = (Button) findViewById(R.id.ch_calculate   );
        Button ch_clear         = (Button) findViewById(R.id.ch_clear       );

        ch_btnkhash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, KhashActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });

        ch_btnnokh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NokhActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });

        ch_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                find(ch_all         .getText()+"",           56.2f);//کل
                find(ch_sugar       .getText()+"",           28.1f);//شکر
                find(ch_khashkhash  .getText()+"",               4);//خشخاش
                find(ch_khorfe      .getText()+"",               5);//خرفه
                find(ch_gandom      .getText()+"",               4);//گندم
                find(ch_jo          .getText()+"",               4);//جو
                find(ch_konjed      .getText()+"",            2.5f);//کنجد
                find(ch_katan       .getText()+"",               2);//بذر کتان
                find(ch_kanaf       .getText()+"",            1.5f);//کنف
                find(ch_ghahve      .getText()+"",            1.5f);//قهوه
                find(ch_aftaab      .getText()+"",               1);//آفتاب
                find(ch_moordane    .getText()+"",            0.5f);//موردانه
                find(ch_kaahoo      .getText()+"",            0.5f);//کاهو
                find(ch_geshniz     .getText()+"",            0.5f);//گشنیز
                find(ch_siyahdane   .getText()+"",            0.5f);//سیاهدانه
                find(ch_raziyane    .getText()+"",            0.5f);//رازیانه
                find(ch_hel         .getText()+"",           0.03f);//هل
                find(ch_jadva       .getText()+"",           0.02f);//جدوا
                find(ch_tiiz        .getText()+"",           0.05f);//تیز
                find(ch_all_NS      .getText()+"",           28.1f);//بدون شکر

                if (ratio != null) {
                    ch_all         .setText(decimal3(ratio *     56.2f));
                    ch_sugar       .setText(decimal3(ratio *     28.1f));
                    ch_khashkhash  .setText(decimal3(ratio *         4));
                    ch_khorfe      .setText(decimal3(ratio *         5));
                    ch_gandom      .setText(decimal3(ratio *         4));
                    ch_jo          .setText(decimal3(ratio *         4));
                    ch_konjed      .setText(decimal3(ratio *      2.5f));
                    ch_katan       .setText(decimal3(ratio *         2));
                    ch_kanaf       .setText(decimal3(ratio *      1.5f));
                    ch_ghahve      .setText(decimal3(ratio *      1.5f));
                    ch_aftaab      .setText(decimal3(ratio *         1));
                    ch_moordane    .setText(decimal3(ratio *      0.5f));
                    ch_kaahoo      .setText(decimal3(ratio *      0.5f));
                    ch_geshniz     .setText(decimal3(ratio *      0.5f));
                    ch_siyahdane   .setText(decimal3(ratio *      0.5f));
                    ch_raziyane    .setText(decimal3(ratio *      0.5f));
                    ch_hel         .setText(decimal3(ratio *     0.03f));
                    ch_jadva       .setText(decimal3(ratio *     0.02f));
                    ch_tiiz        .setText(decimal3(ratio *     0.05f));
                    ch_all_NS      .setText(decimal3(ratio *     28.1f));
                    ratio = null;
                }else
                    Toast.makeText(MainActivity.this
                            ,"یکی از جا های خالی را پر کنید!"
                            ,Toast.LENGTH_LONG).show();
            }
        });

        ch_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch_all          .setText("");
                ch_sugar        .setText("");
                ch_khashkhash   .setText("");
                ch_khorfe       .setText("");
                ch_gandom       .setText("");
                ch_jo           .setText("");
                ch_konjed       .setText("");
                ch_katan        .setText("");
                ch_kanaf        .setText("");
                ch_ghahve       .setText("");
                ch_aftaab       .setText("");
                ch_moordane     .setText("");
                ch_kaahoo       .setText("");
                ch_geshniz      .setText("");
                ch_siyahdane    .setText("");
                ch_raziyane     .setText("");
                ch_hel          .setText("");
                ch_jadva        .setText("");
                ch_tiiz         .setText("");
                ch_all_NS       .setText("");
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