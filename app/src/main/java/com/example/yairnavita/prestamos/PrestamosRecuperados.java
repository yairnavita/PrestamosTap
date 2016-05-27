package com.example.yairnavita.prestamos;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class PrestamosRecuperados extends AppCompatActivity {
    String[] arreglo;
    ListView lista;
    private EditText COD;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eliminar);
        borrarregistro();
        lista = (ListView) findViewById(R.id.listaregistroseliminar);
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        COD = (EditText)findViewById(R.id.campoeliminar);

    }
    public void borrarregistro(){
        BDDPrestamos prestamo = new BDDPrestamos(this,"RegistrosPrestamos", null, 1);
        SQLiteDatabase bd = prestamo.getWritableDatabase();

        if(bd!=null){
            Cursor c=bd.rawQuery("Select * From Registros",null);
            int cantidad = c.getCount();
            int i=0;
            arreglo = new String[cantidad];
            if (c.moveToFirst()){
                do {
                    String linea = "Codigo: "+c.getString(0)+"\nNombre Objeto: "+c.getString(1)+"\nCantidad: "+c.getString(2)+"\n¿A Quién se lo Preste?: "+c.getString(3);
                    arreglo[i] = linea;
                    i++;
                }while (c.moveToNext());
            }
            ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arreglo);
            ListView lista = (ListView) findViewById(R.id.listaregistroseliminar);
            lista.setAdapter(adapter);
        }

    }

    public void eliminarboton(View v) {
        BDDPrestamos prestamo = new BDDPrestamos(this,"RegistrosPrestamos", null, 1);
        SQLiteDatabase bd = prestamo.getWritableDatabase();
        String cod = COD.getText().toString();
        int cant = bd.delete("Registros", "Id=" + cod, null);
        bd.close();
        COD.setText("");
        Intent i = new Intent(this, EliminarActivity.class);
        this.finish();
        startActivity(i);
        if (cant == 1){Toast.makeText(this, "Se Borro el Registro Exitosamente", Toast.LENGTH_SHORT).show();}
        else{Toast.makeText(this, "No Existe Registro con el código Ingresado",Toast.LENGTH_SHORT).show();}
    }
}
