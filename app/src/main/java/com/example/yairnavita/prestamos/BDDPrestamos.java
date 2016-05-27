package com.example.yairnavita.prestamos;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by YairNavita on 25/05/16.
 */
public class BDDPrestamos extends SQLiteOpenHelper{
    String tabla="CREATE TABLE Registros(Id INTEGER PRIMARY KEY AUTOINCREMENT,Nombre Text,Cantidad Text,PersonaPrestamo Text,Telefono Text,FechaP Text,FechaD Text,Descripcion Text,devuelto int)";
    public BDDPrestamos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
