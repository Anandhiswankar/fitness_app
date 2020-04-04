package com.ananddevelopment.fitness_care;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tx;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);


        tx = (TextView) findViewById(R.id.textView3);

        et = (EditText) findViewById(R.id.editText);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toast();

            }
        });
    }


    public void toast()
    {
        Toast.makeText(this,"temp",Toast.LENGTH_SHORT).show();
    }

}
