package com.example.tjjcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView viewToSolve;

    TextView resultsView;

    String Display = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            viewToSolve = (TextView)findViewById(R.id.toSolve);
            resultsView = (TextView)findViewById(R.id.result);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }



    private void setDisplay(String btnClicked){
        Display = Display + btnClicked;
        viewToSolve.setText(Display);
    }
    public void Clear(View view) {

        viewToSolve.setText("0");
        resultsView.setText("0");
        Display="";
    }
    public void percent(View view) {
        Double forPercent;
        forPercent = Double.parseDouble(Display) * .01;
        resultsView.setText(String.valueOf(forPercent));
    }
    public void delete(View view) {
        String lstDigit = viewToSolve.getText().toString().trim();

        if(lstDigit.length()!=0){
            lstDigit  = lstDigit.substring( 0, lstDigit.length() - 1 );

            viewToSolve.setText ( lstDigit );
        }
        String afterTrimming = Display;

        if(afterTrimming.length()!=0){
            afterTrimming  = afterTrimming.substring( 0, afterTrimming.length() - 1 );

            Display = afterTrimming ;
        }
    }

    public void divide(View view) {
        setDisplay("÷");
    }

    public void sevenBtn(View view) {
        setDisplay("7");
    }

    public void eightBtn(View view) {
        setDisplay("8");
    }

    public void nineBtn(View view) {
        setDisplay("9");
    }

    public void multiplyBtn(View view) {
        setDisplay("*");
    }

    public void fourBtn(View view) {
        setDisplay("4");
    }

    public void fiveBtn(View view) {
        setDisplay("5");
    }

    public void sixBtn(View view) {
        setDisplay("6");
    }

    public void subtractBtn(View view) {
        setDisplay("-");
    }

    public void addBtn(View view) {
        setDisplay("+");
    }

    public void oneBtn(View view) {
        setDisplay("1");
    }

    public void threeBtn(View view) {
        setDisplay("3");
    }

    public void twoBtn(View view) {
        setDisplay("2");
    }

    public void doubleZeroBtn(View view) {
        setDisplay("00");
    }

    public void zeroBtn(View view) {
        setDisplay("0");
    }

    public void decimalBtn(View view) {
        setDisplay(".");
    }

    public void equalBtn(View view) {

        Double myResult = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            myResult = (double) engine.eval(Display);
        } catch(ScriptException e){
            Toast.makeText(this,"Invalid Input", Toast.LENGTH_SHORT).show();
        }
        if(myResult != null)
            resultsView.setText(String.valueOf(myResult.doubleValue()));
    }
}