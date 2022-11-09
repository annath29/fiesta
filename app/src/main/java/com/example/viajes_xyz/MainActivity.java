package com.example.viajes_xyz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText jetcantidad;
    RadioButton jrbcartagena,jrbpuntacana,jrbleticia;
    TextView jtvtotal,jtvciudad,jtvguia,jtvvehiculo;
    CheckBox jcbguia,jcbvehiculo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ocultrar barra de titulo y asociar objetos java y xml
        getSupportActionBar().hide();

        jetcantidad=findViewById(R.id.etcantidad);
        jrbpuntacana=findViewById(R.id.rbpuntacana);
        jrbcartagena=findViewById(R.id.rbcartagenta);
        jrbleticia=findViewById(R.id.rbleticia);
        jtvciudad=findViewById(R.id.tvciudad);
        jtvguia=findViewById(R.id.tvguia);
        jtvvehiculo=findViewById(R.id.tvvehiculo);
        jtvtotal=findViewById(R.id.tvtotal);
        jcbguia=findViewById(R.id.cbguia);
        jcbvehiculo=findViewById(R.id.cbvehiculo);
    }

    public void calcular_valor_viaje(View view){
        String cant_personas=jetcantidad.getText().toString();
        if (cant_personas.isEmpty()){
            Toast.makeText(this, "la cantidad de personas es requerida", Toast.LENGTH_SHORT).show();
            jetcantidad.requestFocus();
        }
        else
        {
            int cantidad,valor_ciudad = 0,valor_guia,valor_vehiculo,valor_total;
            cantidad=Integer.parseInt(cant_personas);
            if (cantidad<1)
            {
                Toast.makeText(this, "la cantidad de personas debe ser mayor a 1", Toast.LENGTH_SHORT).show();
                jetcantidad.requestFocus();
            }
            else
            {
                if (jrbcartagena.isChecked()){
                    jtvciudad.setText("900000");
                    valor_ciudad=900000;
                }
                else{
                    if (jrbleticia.isChecked())
                    {
                        jtvciudad.setText("2000000");
                        valor_ciudad=2000000;
                    }
                    else{
                        jtvciudad.setText("3000000");
                        valor_ciudad=3000000;
                    }
                }
            }
            if (jcbvehiculo.isChecked())
            {
                jtvvehiculo.setText("300000");
                valor_vehiculo=300000;
            }
            else
            {
                jtvvehiculo.setText("0");
                valor_vehiculo=0;
            }

            if (jcbguia.isChecked())
            {
                jtvguia.setText("100000");
                valor_guia=100000;
            }
            else{
                jtvguia.setText("0");
                valor_guia=0;
            }
            valor_total=cantidad*valor_ciudad+valor_guia+valor_vehiculo;
            jtvtotal.setText(String.valueOf(valor_total));
        }
    }
    public void limpiar(View view){
        jtvtotal.setText("0");
        jetcantidad.setText("");
        jtvciudad.setText("900000");
        jtvguia.setText("0");
        jtvvehiculo.setText("0");
        jrbcartagena.setChecked(true);
        jcbguia.setChecked(false);
        jcbvehiculo.setChecked(false);
    }
}