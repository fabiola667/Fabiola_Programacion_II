package com.ugb.parcial1_recuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

TabHost tbh;
TextView tempVal;
Button btn;
Spinner spn;
Conversores miObj=new Conversores();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbh = findViewById(R.id.tbhParcial);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("MTS").setContent(R.id.tabMtsConsumidos).setIndicator("Mts consumidos",null));
        tbh.addTab(tbh.newTabSpec("CON").setContent(R.id.tabconversores).setIndicator("Convercion de area",null));

        btn = findViewById(R.id.btnCalcular);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempVal = findViewById(R.id.txtMtsconsumidos);
                double num = Double.parseDouble(tempVal.getText().toString());
/*  >  < */
                if (num>=1 && num<=18) {
                    double respuesta = 6;
                    Toast.makeText(getApplicationContext(),"Repuesta:"+ respuesta, Toast.LENGTH_LONG).show();
                }else if (num >= 19 && num <=28 ){
                    double respuesta =((num - 18)*0.45) +6;
                    Toast.makeText(getApplicationContext(),"Repuesta:"+ respuesta, Toast.LENGTH_LONG).show();
                }else{
                    double respuesta= (((num -28 )*0.65)+((28-18)*0.45))+6;
                    Toast.makeText(getApplicationContext(),"Repuesta:"+ respuesta, Toast.LENGTH_LONG).show();
                }

            }
        });
btn=findViewById(R.id.btnConvertirArea);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        spn=findViewById(R.id.spnDeArea);
        int de=spn.getSelectedItemPosition();

        spn=findViewById(R.id.spnAArea);
        int a=spn.getSelectedItemPosition();

        tempVal=findViewById(R.id.txtCantidadConvertir);
        double cantidad= Double.parseDouble(tempVal.getText().toString());

        double respuesta= miObj.convertir(0,de,a,cantidad);
        Toast.makeText(getApplicationContext(),"Repuesta:"+ respuesta, Toast.LENGTH_LONG).show();
    }
});
    }
}
class Conversores{
    double[][] valores= {
            {1,6988,75218.1332,10000,0.0001187,16,0.6988 }
    };
    public double convertir(int opcion,int de,int a,double cantidad ){
        return valores [opcion][a]/valores[opcion][de]*cantidad;
    }
}