
package com.example.lekcja_03onclick;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.textView7);

        Button btn0 = findViewById(R.id.button52);
        Button btn1 = findViewById(R.id.button49);
        Button btn2 = findViewById(R.id.button50);
        Button btn3 = findViewById(R.id.button48);
        Button btn4 = findViewById(R.id.button43);
        Button btn5 = findViewById(R.id.button44);
        Button btn6 = findViewById(R.id.button45);
        Button btn7 = findViewById(R.id.button40);
        Button btn8 = findViewById(R.id.button41);
        Button btn9 = findViewById(R.id.button42);

        btn0.setOnClickListener(v -> append0());
        btn1.setOnClickListener(v -> append1());
        btn2.setOnClickListener(v -> append2());
        btn3.setOnClickListener(v -> append3());
        btn4.setOnClickListener(v -> append4());
        btn5.setOnClickListener(v -> append5());
        btn6.setOnClickListener(v -> append6());
        btn7.setOnClickListener(v -> append7());
        btn8.setOnClickListener(v -> append8());
        btn9.setOnClickListener(v -> append9());
    }

    private void append0() {
        appendSymbol("0");
    }

    private void append1() {
        appendSymbol("1");
    }

    private void append2() {
        appendSymbol("2");
    }

    private void append3() {
        appendSymbol("3");
    }

    private void append4() {
        appendSymbol("4");
    }

    private void append5() {
        appendSymbol("5");
    }

    private void append6() {
        appendSymbol("6");
    }

    private void append7() {
        appendSymbol("7");
    }

    private void append8() {
        appendSymbol("8");
    }

    private void append9() {
        appendSymbol("9");
    }

    private void appendSymbol(String symbol) {
        tvDisplay.setText(tvDisplay.getText().toString() + symbol);
    }
}
