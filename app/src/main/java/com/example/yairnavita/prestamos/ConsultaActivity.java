package com.example.yairnavita.prestamos;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ConsultaActivity extends Activity  {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta);
        cargar();;
    }
    public void cargar(){
        BDDPrestamos prestamo = new BDDPrestamos(this,"RegistrosPrestamos", null, 1);
        SQLiteDatabase bd = prestamo.getReadableDatabase();

        if(bd!=null){
            Cursor c=bd.rawQuery("Select * From Registros",null);
            int cantidad = c.getCount();
            int i=0;
            String[] arreglo = new String[cantidad];
            if (c.moveToFirst()){
                do {
                    String linea = "Nombre Objeto: "+c.getString(1)+"\nCantidad: "+c.getString(2)+"\n¿A Quién se lo Preste?: "+c.getString(3)+"\nTeléfono: "+c.getString(4)+"\nFecha Prestamo: "+c.getString(5)+"\nFecha Devolución: "+c.getString(6)+"\nDescripción: "+c.getString(7);
                    arreglo[i] = linea;
                    i++;
                }while (c.moveToNext());
            }
            ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arreglo);
            ListView lista = (ListView) findViewById(R.id.listaregistros);
            lista.setAdapter(adapter);
        }

    }
}