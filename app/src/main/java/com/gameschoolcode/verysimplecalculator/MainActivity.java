package com.gameschoolcode.verysimplecalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //views
    private TextView screenBtn;
    private Button mcBtn;
    private Button mrBtn;
    private Button msBtn;
    private Button mBtn;
    private ImageButton undoBtn;
    private Button ceBtn;
    private Button cBtn;
    private Button signBtn;
    private Button n7Btn;
    private Button n8Btn;
    private Button n9Btn;
    private Button n4Btn;
    private Button n5Btn;
    private Button n6Btn;
    private Button n1Btn;
    private Button n2Btn;
    private Button n3Btn;
    private Button n0Btn;
    private Button divBtn;
    private Button mulBtn;
    private Button minusBtn;
    private Button plusBtn;
    private Button dotBtn;
    private Button equalBtn;
    //id
    private int screenId;
    private int undoId;
    private int cId;
    private int mcId;
    private int mrId;
    private int msId;
    private int mId;
    private int ceId;
    private int changeSignId;
    private int sevenId;
    private int eightId;
    private int nineId;
    private int fourId;
    private int fiveId;
    private int sixId;
    private int oneId;
    private int twoId;
    private int threeId;
    private int zeroId;
    private int divId;
    private int mulId;
    private int minusId;
    private int plusId;
    private int dotId;
    private int equalId;
    //variable
    private String input = "";
    private  double num1 , num2;
    private char opr=' ';
    private boolean equalFlage=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //code
        initID();
        initUI();
        setListener();
    }

    private void initID() {
        screenId = R.id.screen;
        undoId = R.id.undo;
        cId = R.id.c;
        mcId = R.id.mc;
        mrId = R.id.mr;
        msId = R.id.ms;
        mId = R.id.m;
        ceId = R.id.ce;
        changeSignId = R.id.changeSign;
        sevenId = R.id.seven;
        eightId = R.id.eight;
        nineId = R.id.nine;
        fourId = R.id.four;
        fiveId = R.id.five;
        sixId = R.id.six;
        oneId = R.id.one;
        twoId = R.id.two;
        threeId = R.id.three;
        zeroId = R.id.zero;
        divId = R.id.div;
        mulId = R.id.mul;
        minusId = R.id.minus;
        plusId = R.id.plus;
        dotId = R.id.dot;
        equalId = R.id.equal;
    }

    private void initUI() {
        screenBtn = (TextView) findViewById(screenId);
        undoBtn = (ImageButton) findViewById(undoId);
        cBtn = (Button) findViewById(cId);
        mcBtn = (Button) findViewById(mcId);
        mrBtn = (Button) findViewById(mrId);
        msBtn = (Button) findViewById(msId);
        mBtn = (Button) findViewById((mId));
        ceBtn = (Button) findViewById(ceId);
        signBtn = (Button) findViewById(changeSignId);
        n7Btn = (Button) findViewById(sevenId);
        n8Btn = (Button) findViewById(eightId);
        n9Btn = (Button) findViewById(nineId);
        n4Btn = (Button) findViewById(fourId);
        n5Btn = (Button) findViewById(fiveId);
        n6Btn = (Button) findViewById(sixId);
        n1Btn = (Button) findViewById(oneId);
        n2Btn = (Button) findViewById(twoId);
        n3Btn = (Button) findViewById(threeId);
        n0Btn = (Button) findViewById(zeroId);
        divBtn = (Button) findViewById(divId);
        mulBtn = (Button) findViewById(mulId);
        minusBtn = (Button) findViewById(minusId);
        plusBtn = (Button) findViewById(plusId);
        dotBtn = (Button) findViewById(dotId);
        equalBtn = (Button) findViewById(equalId);
    }

    private void setListener() {
        n1Btn.setOnClickListener(this);
        n2Btn.setOnClickListener(this);
        n3Btn.setOnClickListener(this);
        n4Btn.setOnClickListener(this);
        n5Btn.setOnClickListener(this);
        n6Btn.setOnClickListener(this);
        n7Btn.setOnClickListener(this);
        n8Btn.setOnClickListener(this);
        n9Btn.setOnClickListener(this);
        n0Btn.setOnClickListener(this);
        divBtn.setOnClickListener(this);
        mulBtn.setOnClickListener(this);
        minusBtn.setOnClickListener(this);
        plusBtn.setOnClickListener(this);
        equalBtn.setOnClickListener(this);
        dotBtn.setOnClickListener(this);
        cBtn.setOnClickListener(this);
        undoBtn.setOnClickListener(this);
        signBtn.setOnClickListener(this);
        mcBtn.setOnClickListener(this);
        ceBtn.setOnClickListener(this);
        mrBtn.setOnClickListener(this);
        msBtn.setOnClickListener(this);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                writeOnScreen("1");
                break;
            case R.id.two:
                writeOnScreen("2");
                break;
            case R.id.three:
                writeOnScreen("3");
                break;
            case R.id.four:
                writeOnScreen("4");
                break;
            case R.id.five:
                writeOnScreen("5");
                break;
            case R.id.six:
                writeOnScreen("6");
                break;
            case R.id.seven:
                writeOnScreen("7");
                break;
            case R.id.eight:
                writeOnScreen("8");
                break;
            case R.id.nine:
                writeOnScreen("9");
                break;
            case R.id.zero:
                writeOnScreen("0");
                break;
            case R.id.c:
                clear();
                break;
            case R.id.dot:
                writeDot();
                break;
            case R.id.undo:
                undoAction();
                break;
            case R.id.changeSign:
                changeNumberSign();
                break;
            case R.id.plus:
                setOperation('+');
                break;
            case R.id.minus:
                setOperation('-');
                break;
            case R.id.mul:
                setOperation('*');
                break;
            case R.id.div:
                setOperation('/');
                break;
            case R.id.equal:
                getResult();
                break;
        }
    }
        //setInput

   private void writeOnScreen(String n) {

       if(zeroTest() || equalFlage) {
           screenBtn.setText(n);
           equalFlage=false;
       }
       else
           screenBtn.append(n);
    }

    private void clear() {
        screenBtn.setText("");
        opr=' ';
        equalFlage=false;
    }

    private void undoAction() {
        if(equalFlage){
            clear();
            equalFlage=false;
        }
        else {
            getInput();
            if (!input.isEmpty()) {
                input = input.substring(0, input.length() - 1);
                screenBtn.setText(input);
            }
        }
    }
    //getInput
    private void getInput(){
        input = screenBtn.getText().toString();
    }

    private boolean zeroTest(){
        boolean res=false;
        getInput();
        if(input.length()==1 && input.charAt(0)=='0')
            res=true;
        return res;
    }

    private void  writeDot(){
            getInput();
            if (input.isEmpty() || equalFlage){
                screenBtn.setText("0.");
                equalFlage=false;
            }
            else if (!input.contains("."))
                screenBtn.append(".");
        }

    private void changeNumberSign(){
        getInput();
        if(!zeroTest() && !input.isEmpty()) {
                if (input.charAt(0) == '-')
                    screenBtn.setText(input.substring(1));
                else {
                    input = "-" + input;
                    screenBtn.setText(input);
                }
        }

    }

   private void setOperation(char ch){
        getInput();
       if(!input.isEmpty() && opr==' '){
           num1= Double.parseDouble(input);
           clear();
           opr=ch;
       }
    }

    boolean hasOperator(){
        if(opr !=' ')
            return true;
        else
            return false;
    }
    private  void getResult(){
        double result;
        getInput();
        if(input.isEmpty() && hasOperator()){
            result=num1;
            getResultHelper(result);
        }

        else if(!input.isEmpty() && !hasOperator()){
            num1=Double.parseDouble(input);
            result=num1;
            getResultHelper(result);
        }
        else if(!input.isEmpty()&& hasOperator()){
            num2=Double.parseDouble(input);
            switch (opr){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    if(num2==0){
                        result=Double.NaN;
                        Toast.makeText(this,Double.toString(result),Toast.LENGTH_LONG);
                    }
                    else
                        result=num1/num2;
                    break;
                default:
                    result=0;
            }
            getResultHelper(result);
        }


    }

    private void getResultHelper(double result){
        clear();
        input=Double.toString(result);
        screenBtn.setText(input);
        opr=' ';
        equalFlage=true;
    }

}


