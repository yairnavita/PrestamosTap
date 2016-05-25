package com.example.yairnavita.prestamos;
 import android.app.Activity;
 import android.app.DatePickerDialog;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;
 import android.widget.DatePicker;
 import android.widget.TextView;
 import java.text.DateFormat;
 import java.util.Calendar;
 import java.util.GregorianCalendar;


public class AgregarActivity extends Activity implements View.OnClickListener {
    DateFormat formate = DateFormat.getDateInstance();
    Calendar calendar = Calendar.getInstance();
    TextView label;
    Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar);
        label = (TextView) findViewById(R.id.FD);
        btn = (Button)this.findViewById(R.id.calD);
        btn.setOnClickListener(this);
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
}
