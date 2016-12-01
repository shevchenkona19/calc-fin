package dima.shevc.calcfin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by shevc on 24.11.2016.
 */

public class MainConv extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spConvInput;
    private Spinner spConvOutput;

    private TextView tvConvInput;
    private TextView tvConvOutput;

    private Button btnConv1;
    private Button btnConv2;
    private Button btnConv3;
    private Button btnConv4;
    private Button btnConv5;
    private Button btnConv6;
    private Button btnConv7;
    private Button btnConv8;
    private Button btnConv9;
    private Button btnConv0;
    private Button btnConvDel;
    private Button btnConvC;

    private View.OnClickListener onClickListener;

    private String INPUT_SELECTED_NAME = "Millimeters";
    private String OUTPUT_SELECTED_NAME = "Millimeters";

    @Override
    protected void onCreate(Bundle savedBundleInstance){
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.activity_eng_calc);

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btn_conv_0:
                        tvConvInput.setText(tvConvInput.getText().toString() + "0");
                        convert(INPUT_SELECTED_NAME, OUTPUT_SELECTED_NAME);
                        break;
                    case R.id.btn_conv_1:
                        tvConvInput.setText(tvConvInput.getText().toString() + "1");
                        convert(INPUT_SELECTED_NAME, OUTPUT_SELECTED_NAME);
                        break;
                    case R.id.btn_conv_2:
                        tvConvInput.setText(tvConvInput.getText().toString() + "2");
                        convert(INPUT_SELECTED_NAME, OUTPUT_SELECTED_NAME);
                        break;
                    case R.id.btn_conv_3:
                        tvConvInput.setText(tvConvInput.getText().toString() + "3");
                        convert(INPUT_SELECTED_NAME, OUTPUT_SELECTED_NAME);
                        break;
                    case R.id.btn_conv_4:
                        tvConvInput.setText(tvConvInput.getText().toString() + "4");
                        convert(INPUT_SELECTED_NAME, OUTPUT_SELECTED_NAME);
                        break;
                    case R.id.btn_conv_5:
                        tvConvInput.setText(tvConvInput.getText().toString() + "5");
                        convert(INPUT_SELECTED_NAME, OUTPUT_SELECTED_NAME);
                        break;
                    case R.id.btn_conv_6:
                        tvConvInput.setText(tvConvInput.getText().toString() + "6");
                        convert(INPUT_SELECTED_NAME, OUTPUT_SELECTED_NAME);
                        break;
                    case R.id.btn_conv_7:
                        tvConvInput.setText(tvConvInput.getText().toString() + "7");
                        convert(INPUT_SELECTED_NAME, OUTPUT_SELECTED_NAME);
                        break;
                    case R.id.btn_conv_8:
                        tvConvInput.setText(tvConvInput.getText().toString() + "8");
                        convert(INPUT_SELECTED_NAME, OUTPUT_SELECTED_NAME);
                        break;
                    case R.id.btn_conv_9:
                        tvConvInput.setText(tvConvInput.getText().toString() + "9");
                        convert(INPUT_SELECTED_NAME, OUTPUT_SELECTED_NAME);
                        break;
                    case R.id.btn_conv_del:
                        if(tvConvInput.getText().toString().equals("0")) {
                            break;
                        }
                        try {
                            tvConvInput.setText(tvConvInput.getText().toString().substring(0, tvConvInput.getText().toString().length() - 1));
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        convert(INPUT_SELECTED_NAME, OUTPUT_SELECTED_NAME);
                        break;
                    case R.id.btn_conv_c:
                        tvConvInput.setText("");
                        convert(INPUT_SELECTED_NAME, OUTPUT_SELECTED_NAME);
                        break;
                }
            }
        };

        spConvInput = (Spinner) findViewById(R.id.sp_conv_input);
        spConvOutput = (Spinner) findViewById(R.id.sp_conv_output);

        tvConvInput = (TextView) findViewById(R.id.tv_conv_input);
        tvConvOutput = (TextView) findViewById(R.id.tv_conv_output);

        btnConv0 = (Button) findViewById(R.id.btn_conv_0);
        btnConv1 = (Button) findViewById(R.id.btn_conv_1);
        btnConv2 = (Button) findViewById(R.id.btn_conv_2);
        btnConv3 = (Button) findViewById(R.id.btn_conv_3);
        btnConv4 = (Button) findViewById(R.id.btn_conv_4);
        btnConv5 = (Button) findViewById(R.id.btn_conv_5);
        btnConv6 = (Button) findViewById(R.id.btn_conv_6);
        btnConv7 = (Button) findViewById(R.id.btn_conv_7);
        btnConv8 = (Button) findViewById(R.id.btn_conv_8);
        btnConv9 = (Button) findViewById(R.id.btn_conv_9);
        btnConvDel = (Button) findViewById(R.id.btn_conv_del);
        btnConvC = (Button) findViewById(R.id.btn_conv_c);

        btnConv0.setOnClickListener(onClickListener);
        btnConv1.setOnClickListener(onClickListener);
        btnConv2.setOnClickListener(onClickListener);
        btnConv3.setOnClickListener(onClickListener);
        btnConv4.setOnClickListener(onClickListener);
        btnConv5.setOnClickListener(onClickListener);
        btnConv6.setOnClickListener(onClickListener);
        btnConv7.setOnClickListener(onClickListener);
        btnConv8.setOnClickListener(onClickListener);
        btnConv9.setOnClickListener(onClickListener);
        btnConvDel.setOnClickListener(onClickListener);
        btnConvC.setOnClickListener(onClickListener);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_values, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item_layout);

        spConvInput.setAdapter(adapter);
        spConvOutput.setAdapter(adapter);

        spConvInput.setOnItemSelectedListener(this);
        spConvOutput.setOnItemSelectedListener(this);

        getSupportActionBar().hide();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()){
            case R.id.sp_conv_input:
                INPUT_SELECTED_NAME = adapterView.getSelectedItem().toString();
                break;
            case R.id.sp_conv_output:
                OUTPUT_SELECTED_NAME = adapterView.getSelectedItem().toString();
                break;
        }
        convert(INPUT_SELECTED_NAME, OUTPUT_SELECTED_NAME);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "Nothing was selected", Toast.LENGTH_LONG).show();
    }

    private void convert(String metric1, String metric2){
        double convertValue1 = 0;
        double convertValue2 = 0;

        switch (metric1){
            case "Millimeters":
                try {
                    convertValue1 = Double.parseDouble(tvConvInput.getText().toString()) * 0.001;
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case "Centimeters":
                try {
                    convertValue1 = Double.parseDouble(tvConvInput.getText().toString()) * 0.01;
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case "Meters":
                try {
                    convertValue1 = Double.parseDouble(tvConvInput.getText().toString());
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
        switch (metric2){
            case "Millimeters":
                convertValue2 = 1000;
                break;
            case "Centimeters":
                convertValue2 = 100;
                break;
            case "Meters":
                convertValue2 = 1;
                break;
        }
        tvConvOutput.setText(Double.toString(convertValue1*convertValue2));
    }
}