package com.example.yairnavita.prestamos;
 import android.app.Activity;
 import android.app.DatePickerDialog;
 import android.content.ContentValues;
 import android.database.sqlite.SQLiteDatabase;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;
 import android.widget.DatePicker;
 import android.widget.EditText;
 import android.widget.TextView;
 import android.widget.Toast;

 import java.text.DateFormat;
 import java.util.Calendar;
 import java.util.GregorianCalendar;


public class AgregarActivity extends Activity implements View.OnClickListener {
    DateFormat formate = DateFormat.getDateInstance();
    Calendar calendar = Calendar.getInstance();
    TextView label;
    Button btn;
    EditText NO,Cant,AP,Tel,FechP,FechD,Desc;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar);
        label = (TextView) findViewById(R.id.FD);
        btn = (Button)this.findViewById(R.id.calD);
        btn.setOnClickListener(this);

        NO=(EditText)findViewById(R.id.nombreobjeto);
        Cant=(EditText)findViewById(R.id.cantidadobjeto);
        AP=(EditText)findViewById(R.id.aquienpreste);
        Tel=(EditText)findViewById(R.id.telefono);
        FechP=(EditText)findViewById(R.id.FP);
        FechD=(EditText)findViewById(R.id.FD);
        Desc=(EditText)findViewById(R.id.Descripcion);
    }
    public void updatedate(){
        label.setText(formate.format(calendar.getTime()));
    }

    public void setDate()
    {
        new DatePickerDialog(AgregarActivity.this, this.d, this.calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener(){

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            updatedate();
        }
    };
    public void onClick(View v) {
        this.setDate();
    }

    ////////////_________////////////__________/////////////

    Calendar fecha = new GregorianCalendar();
    int año = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);

    public void BotonFP (View view){
        TextView mensaje = (TextView) findViewById(R.id.FP);
        mensaje.setText(""+dia+"/"+(mes+1)+"/"+año);
    }

    public void GuardarRegistro(View v) {
        //Variables para obtener contenido de la vista
        String nomObj = NO.getText().toString();
        float cantidad = Float.parseFloat(Cant.getText().toString());
        String pre = AP.getText().toString();
        int tel = Integer.parseInt(Tel.getText().toString());
        String fechap = FechP.getText().toString();
        String fechad = FechD.getText().toString();
        String descrip = Desc.getText().toString();

        BDDPrestamos prestamo = new BDDPrestamos(this,"RegistrosPrestamos", null, 1);
        SQLiteDatabase bd = prestamo.getWritableDatabase();

        if(bd!=null){
            ContentValues nuevoregistro = new ContentValues();
            nuevoregistro.put("Nombre", nomObj);
            nuevoregistro.put("Cantidad", cantidad);
            nuevoregistro.put("PersonaPrestamo", pre);
            nuevoregistro.put("Telefono", tel);
            nuevoregistro.put("FechaP",fechap);
            nuevoregistro.put("FechaD",fechad);
            nuevoregistro.put("Descripcion",descrip);
            long i = bd.insert("Registros", null, nuevoregistro);
            if(i>0){
                Toast.makeText(this, "Prestamo Registrado",Toast.LENGTH_SHORT).show();
                bd.close();
                NO.setText("");
                Cant.setText("");
                AP.setText("");
                Tel.setText("");
                FechP.setText("");
                FechD.setText("");
                Desc.setText("");
            }
            else{Toast.makeText(this, "hdp",Toast.LENGTH_SHORT).show();}
        }



    }
}
