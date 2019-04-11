
package com.numberintowords;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText enteredNum;
    Button btnConvert;
    Abd_NumWord Abd_NumWord =new Abd_NumWord();


    TextView result;
    private static final String[] tensNames = { "", " Ten", " Twenty", " Thirty", " Forty",
            " Fifty", " Sixty", " Seventy", " Eighty", " Ninety" };

    private static final String[] numNames = { "", " One", " Two", " Three", " Four", " Five",
            " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen",
            " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredNum=findViewById(R.id.etEnterNum);
        btnConvert =findViewById(R.id.btnConvert);
        result =findViewById(R.id.tvMyresult);

        btnConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(enteredNum.getText().toString())) {
            enteredNum.setError("Please Enter a number 0 to 999");
            return;
        }

        Abd_NumWord.setNumber(enteredNum.getText().toString());
        result.setText(convertLessThanOneThousand(Integer.parseInt(Abd_NumWord.getNumber())));

    }
    private static String convertLessThanOneThousand(int number)
    {
        String theRange;

        if (number % 100 < 20)
        {
            theRange = numNames[number % 100];
            number /= 100;
        } else
        {
            theRange = numNames[number % 10];
            number /= 10;

            theRange = tensNames[number % 10] + theRange;
            number /= 10;
        }
        if (number == 0)
            return theRange;
        return numNames[number] + " Hundred" + theRange;
    }

}


