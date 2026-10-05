package com.example.lekcja3_onclick;
import com.example.lekcja3_onclick.R;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView7);

        // Osobne podpięcie dla każdego z 10 przycisków cyfr
        findViewById(R.id.button52).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { onDigit0Click(); }
        });
        findViewById(R.id.button49).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { onDigit1Click(); }
        });
        findViewById(R.id.button50).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { onDigit2Click(); }
        });
        findViewById(R.id.button48).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { onDigit3Click(); }
        });
        findViewById(R.id.button43).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { onDigit4Click(); }
        });
        findViewById(R.id.button44).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { onDigit5Click(); }
        });
        findViewById(R.id.button45).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { onDigit6Click(); }
        });
        findViewById(R.id.button40).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { onDigit7Click(); }
        });
        findViewById(R.id.button41).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { onDigit8Click(); }
        });
        findViewById(R.id.button42).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { onDigit9Click(); }
        });
    }

    private void onDigit0Click() { appendSymbol("0"); }
    private void onDigit1Click() { appendSymbol("1"); }
    private void onDigit2Click() { appendSymbol("2"); }
    private void onDigit3Click() { appendSymbol("3"); }
    private void onDigit4Click() { appendSymbol("4"); }
    private void onDigit5Click() { appendSymbol("5"); }
    private void onDigit6Click() { appendSymbol("6"); }
    private void onDigit7Click() { appendSymbol("7"); }
    private void onDigit8Click() { appendSymbol("8"); }
    private void onDigit9Click() { appendSymbol("9"); }



    private void appendSymbol(String symbol) {
        if (display.getText().toString().equals("0")) {
            display.setText(symbol);
        } else {
            display.append(symbol);
        }
    }
}