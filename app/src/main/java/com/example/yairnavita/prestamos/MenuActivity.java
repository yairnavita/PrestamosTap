package com.example.yairnavita.prestamos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void agregarnuevo(View view) {
        Intent i = new Intent(this, AgregarActivity.class);
        startActivity(i);
        Toast.makeText(this, "Agregar prestamo", Toast.LENGTH_SHORT).show();

    }
    public void consulta(View view) {
        Intent i = new Intent(this, ConsultaActivity.class);
        startActivity(i);
        Toast.makeText(this, "Consultar prestamos", Toast.LENGTH_SHORT).show();

    }

    public void salir(View view){
        finish();
        Toast.makeText(this, "Hasta luego!", Toast.LENGTH_SHORT).show();

    }
    public void prestamospendientes(View view){
        Intent i=new Intent(this,PrestamosRecuperados.class);
        startActivity(i);
        Toast.makeText(this,"Prestamos finalizados",Toast.LENGTH_SHORT).show();
    }

    public void borrarregistro(View view){
        Intent i = new Intent(this, EliminarActivity.class);
        startActivity(i);
        Toast.makeText(this, "Marcar devolución", Toast.LENGTH_SHORT).show();

    }
}
