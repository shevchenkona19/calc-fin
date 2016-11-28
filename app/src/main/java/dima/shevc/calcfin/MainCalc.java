package dima.shevc.calcfin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by shevc on 24.11.2016.
 */

public class MainCalc extends AppCompatActivity{
    //Объявляем переменные
    private TextView tv_res;
    private TextView tv_res_second;

    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_0;
    private Button btn_plus;
    private Button btn_minus;
    private Button btn_dividing;
    private Button btn_mult;
    private Button btn_c;
    private Button btn_equals;
    private Button btn_del;

    private int result;

    private String str_op1, str_op2, str_result, symbol;

    private boolean bool_op1 = false;

    @Override
    protected void onCreate(Bundle savedBundleInstance){
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.activity_main_calc);
        tv_res = (TextView) findViewById(R.id.tv_res);
        tv_res_second = (TextView) findViewById(R.id.tv_res_second);

        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_dividing = (Button) findViewById(R.id.btn_dividing);
        btn_mult = (Button) findViewById(R.id.btn_mult);
        btn_c = (Button) findViewById(R.id.btn_c);
        btn_equals = (Button) findViewById(R.id.btn_equals);
        btn_del = (Button) findViewById(R.id.btn_del);

        CreateButtonListeners();

        getSupportActionBar().hide();
    }
    private int Calculate(String s1, String s2, String symbol){
        int op1, op2;
        op1 = Integer.parseInt(s1);
        op2 = Integer.parseInt(s2);
        if(symbol.equals("+")){result = op1 + op2;}
        else if(symbol.equals("-")){result = op1 - op2;}
        else if(symbol.equals("/")){result = op1 / op2;}
        else if(symbol.equals("*")){result = op1 * op2;}
        return result;
    }
    private void SymbolClick(String symbol){
        if(str_op1 != null && str_op2 == null){
            this.symbol = symbol;
            bool_op1 = true;
            tv_res.setText("");
            tv_res_second.setText(str_op1 + " " + symbol);
        }
        else if(str_op2 != null){
            str_op1 = Integer.toString(Calculate(str_op1, str_op2, this.symbol));
            str_result = str_op1;
            str_op2 = null;
            this.symbol = symbol;
            bool_op1 = true;
            tv_res.setText(str_result);
            tv_res_second.setText(str_op1 + " " + symbol);
        }
        else if(str_result != null){
            str_op1 = str_result;
            bool_op1 = true;
            this.symbol = symbol;
            str_result = null;
            tv_res.setText("");
            tv_res_second.setText(str_op1 + " " + symbol);
        }
        else{}
    }
    private void NumberClick(String number){
        if(str_op1 == null){
            str_op1 = number;
            tv_res.setText(str_op1);
        }
        else if(bool_op1 == false){
            str_op1 += number;
            tv_res.setText(str_op1);
        }
        else if(str_op2 == null){
            str_op2 = number;
            tv_res.setText(str_op2);
        }
        else if(bool_op1 == true) {
            str_op2 += number;
            tv_res.setText(str_op2);
        }
    }
    private void CreateButtonListeners(){
        //Создаём обработчики нажатий
        View.OnClickListener ocl_button = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_1:
                        //Кнопка 1
                        NumberClick("1");
                        break;
                    case R.id.btn_2:
                        //Кнопка 2
                        NumberClick("2");
                        break;
                    case R.id.btn_3:
                        //Кнопка 3
                        NumberClick("3");
                        break;
                    case R.id.btn_4:
                        //Кнопка 4
                        NumberClick("4");
                        break;
                    case R.id.btn_5:
                        //Кнопка 5
                        NumberClick("5");
                        break;
                    case R.id.btn_6:
                        //Кнопка 6
                        NumberClick("6");
                        break;
                    case R.id.btn_7:
                        //Кнопка 7
                        NumberClick("7");
                        break;
                    case R.id.btn_8:
                        //Кнопка 8
                        NumberClick("8");
                        break;
                    case R.id.btn_9:
                        //Кнопка 9
                        NumberClick("9");
                        break;
                    case R.id.btn_0:
                        //Кнопка 0
                        NumberClick("0");
                        break;
                    case R.id.btn_plus:
                        //Кнопка +
                        SymbolClick("+");
                        break;
                    case R.id.btn_minus:
                        //Кнопка -
                        SymbolClick("-");
                        break;
                    case R.id.btn_dividing:
                        //Кнопка /
                        SymbolClick("/");
                        break;
                    case R.id.btn_mult:
                        //Кнопка *
                        SymbolClick("*");
                        break;
                    case R.id.btn_equals:
                        //Кнопка =
                        if(str_op1 != null && str_op2 != null){
                            result = Calculate(str_op1, str_op2, symbol);
                            //str_op1 = null;
                            str_op2 = null;
                            symbol = null;
                            bool_op1 = false;
                            str_result = Integer.toString(result);
                            //tv_res.setText(str_result);
                            str_op1 = str_result;
                            tv_res.setText(str_op1);
                            tv_res_second.setText("");
                        }
                        else{}
                        break;
                    case R.id.btn_c:
                        //Кнопка C
                        str_op1 = null;
                        str_op2 = null;
                        str_result = null;
                        symbol = null;
                        bool_op1 = false;
                        tv_res.setText("");
                        tv_res_second.setText("");
                        break;
                    case R.id.btn_del:
                        //Кнопка Del
                        try {
                            if (symbol == null && str_op1 != null) {
                                str_op1 = str_op1.substring(0, str_op1.length() - 1);
                                tv_res.setText(str_op1);
                            } else if (str_op1 != null && str_op2 != null) {
                                str_op2 = str_op2.substring(0, str_op2.length() - 1);
                                tv_res.setText(str_op2);
                            }
                        }catch(Exception ex){
                            Toast.makeText(MainCalc.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                }
            }
        };

        //Присваиваем обработчики кнопкам
        btn_1.setOnClickListener(ocl_button);
        btn_2.setOnClickListener(ocl_button);
        btn_3.setOnClickListener(ocl_button);
        btn_4.setOnClickListener(ocl_button);
        btn_5.setOnClickListener(ocl_button);
        btn_6.setOnClickListener(ocl_button);
        btn_7.setOnClickListener(ocl_button);
        btn_8.setOnClickListener(ocl_button);
        btn_9.setOnClickListener(ocl_button);
        btn_0.setOnClickListener(ocl_button);
        btn_dividing.setOnClickListener(ocl_button);
        btn_mult.setOnClickListener(ocl_button);
        btn_minus.setOnClickListener(ocl_button);
        btn_plus.setOnClickListener(ocl_button);
        btn_equals.setOnClickListener(ocl_button);
        btn_c.setOnClickListener(ocl_button);
        btn_del.setOnClickListener(ocl_button);
    }
}
