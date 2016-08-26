package com.facci.proyectojjad;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facci.proyectojjad.SQLITEOPENHELPER.DBhelper;
public class MainActivityJJAD extends AppCompatActivity  {

    DBhelper dbSQLITE;

    EditText Nombre;
    EditText Apellido;
    EditText Recinto;
    EditText Nacimiento;
    EditText ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_jjad);

        dbSQLITE = new DBhelper(this);
    }

    public void BTNingresar (View v) {
        //OBTIENE LOS  ID DE LOS TEXTO INGRESADOS
        Nombre = (EditText) findViewById(R.id.txtNombre);
        Apellido = (EditText) findViewById(R.id.txtApellido);
        Recinto = (EditText) findViewById(R.id.txtRecintoElectoral);
        Nacimiento = (EditText) findViewById(R.id.txtanoNacimiento);

        boolean Insertadatos = dbSQLITE.Insertar(Nombre.getText().toString(),Apellido.getText().toString(),Recinto.getText().toString(),Integer.parseInt(Nacimiento.getText().toString()));

        if (Insertadatos) {
            Toast.makeText(MainActivityJJAD.this, "Datos Ingresados", Toast.LENGTH_SHORT).show();
        }else{Toast.makeText(MainActivityJJAD.this,"Datos no Ingresados ocurrio un error",Toast.LENGTH_SHORT).show();}
    }

    public void BTNbuscar (View v) {
        Cursor res = dbSQLITE.VerTodos();

        if (res.getCount() == 0) {
            Mensaje("Error","No se encontraron registros");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("Id : "+res.getString(0)+"\n");
            buffer.append("Nombre : "+res.getString(1)+"\n");
            buffer.append("Apellido : "+res.getString(2)+"\n");
            buffer.append("Recinto Electoral : "+res.getString(3)+"\n");
            buffer.append("AÃ±o de Nacimiento : "+res.getInt(4)+"\n\n");
        }
        Mensaje("Registros",buffer.toString());
    }

    private void Mensaje (String titulo, String Mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(titulo);
        builder.setMessage(Mensaje);
        builder.show();
    }

    public void BTNmodificar (View v) {
        Nombre = (EditText) findViewById(R.id.txtNombre);
        Apellido = (EditText) findViewById(R.id.txtApellido);
        Recinto = (EditText) findViewById(R.id.txtRecintoElectoral);
        Nacimiento = (EditText) findViewById(R.id.txtanoNacimiento);
        ID = (EditText) findViewById(R.id.txtID);


        boolean ActualizandoDatos = dbSQLITE.ModificarRegistro(ID.getText().toString(),Nombre.getText().toString(),Apellido.getText().toString(),Recinto.getText().toString(),Integer.parseInt(Nacimiento.getText().toString()));
        if(ActualizandoDatos)
            Toast.makeText(MainActivityJJAD.this,"Datos Ingresados",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivityJJAD.this,"Lo sentimos ocurriÃ³ un error",Toast.LENGTH_SHORT).show();

    }

    public void BTNeliminar (View v) {
        ID = (EditText) findViewById(R.id.txtID);

        Integer registrosEliminados = dbSQLITE.Eliminar(ID.getText().toString());

        if(registrosEliminados > 0 ){
            Toast.makeText(MainActivityJJAD.this,"Registro(s) Eliminado(s)",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivityJJAD.this,"ERROR: Registro no eliminado",Toast.LENGTH_SHORT).show();
        }
    }



}
