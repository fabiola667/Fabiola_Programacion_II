package com.ugb.parcial1_recuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

TabHost tbh;
TextView tempVal;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbh = findViewById(R.id.tbhParcial);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("MTS").setContent(R.id.tabMtsConsumidos).setIndicator("Mts consumidos",null));

        btn = findViewById(R.id.btnCalcular);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempVal = findViewById(R.id.txtMtsconsumidos);
                double num = Double.parseDouble(tempVal.getText().toString());
/*  >  < */
                if (num>=1 && num<=18) {
                    double respuesta = 6;

                }
            }
        });

    }
}
