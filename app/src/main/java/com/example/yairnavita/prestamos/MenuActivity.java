package com.example.yairnavita.prestamos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.AlertDialog;
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
        Toast.makeText(this, "Agregar Registro", Toast.LENGTH_SHORT).show();

    }
    public void consulta(View view) {
        Intent i = new Intent(this, ConsultaActivity.class);
        startActivity(i);
        Toast.makeText(this, "Consultar Registros", Toast.LENGTH_SHORT).show();

    }

    public void salir(View view){
        finish();
        Toast.makeText(this, "Adios", Toast.LENGTH_SHORT).show();

    }

}
