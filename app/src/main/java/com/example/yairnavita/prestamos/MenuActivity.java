package com.example.yairnavita.prestamos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void agregarnuevo(View view) {
        Intent i = new Intent(this, AgregarActivity.class);
        startActivity(i);
    }
    public void consulta(View view) {
        Intent i = new Intent(this, ConsultaActivity.class);
        startActivity(i);
    }
}
