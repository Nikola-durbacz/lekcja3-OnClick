
package com.example.lekcja_03onclick;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.textView7);

        int[] digitButtonIds = {
                R.id.button52,
                R.id.button49,
                R.id.button50,
                R.id.button48,
                R.id.button43,
                R.id.button44,
                R.id.button45,
                R.id.button40,
                R.id.button41,
                R.id.button42
        };

        View.OnClickListener digitListener = v -> {
            Button clickedButton = (Button) v;
            appendSymbol(clickedButton.getText().toString());
        };

        for (int id : digitButtonIds) {
            findViewById(id).setOnClickListener(digitListener);
        }

        findViewById(R.id.button46).setOnClickListener(v -> appendComma());

        findViewById(R.id.button35).setOnClickListener(v -> setOperator("+"));
        findViewById(R.id.button37).setOnClickListener(v -> setOperator("-"));
        findViewById(R.id.button38).setOnClickListener(v -> setOperator("*"));
        findViewById(R.id.button36).setOnClickListener(v -> setOperator("/"));

        findViewById(R.id.button47).setOnClickListener(v -> calculate());

        findViewById(R.id.button54).setOnClickListener(v -> clear());
    }

    private void appendSymbol(String symbol) {
        String currentText = tvDisplay.getText().toString();

        if (startNewNumber || currentText.equals("0") || currentText.equals("Błąd")) {
            tvDisplay.setText(symbol);
            startNewNumber = false;
        } else {
            tvDisplay.setText(currentText + symbol);
        }
    }

    private void appendComma() {
        String currentText = tvDisplay.getText().toString();

        if (startNewNumber || currentText.equals("Błąd")) {
            tvDisplay.setText("0,");
            startNewNumber = false;
        } else if (!currentText.contains(",")) {
            tvDisplay.setText(currentText + ",");
        }
    }

    private void setOperator(String selectedOperator) {
        try {
            firstNumber = parseNumber(tvDisplay.getText().toString());
            operator = selectedOperator;
            startNewNumber = true;
        } catch (NumberFormatException e) {
            tvDisplay.setText("Błąd");
            startNewNumber = true;
        }
    }

    private void calculate() {
        if (operator.isEmpty()) {
            return;
        }

        try {
            double secondNumber = parseNumber(tvDisplay.getText().toString());
            double result;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber == 0) {
                        tvDisplay.setText("Nie można dzielić przez 0");
                        operator = "";
                        startNewNumber = true;
                        return;
                    }
                    result = firstNumber / secondNumber;
                    break;
                default:
                    return;
            }

            if (result == (long) result) {
                tvDisplay.setText(String.valueOf((long) result));
            } else {
                tvDisplay.setText(String.valueOf(result).replace(".", ","));
            }

            operator = "";
            startNewNumber = true;

        } catch (NumberFormatException e) {
            tvDisplay.setText("Błąd");
            operator = "";
            startNewNumber = true;
        }
    }

    private double parseNumber(String number) {
        return Double.parseDouble(number.replace(",", "."));
    }

    private void clear() {
        tvDisplay.setText("0");
        firstNumber = 0;
        operator = "";
        startNewNumber = true;
    }
}
