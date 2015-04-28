package com.example.coby.mostrarapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListaContactos extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);
        String[][] datos={{"Pepe","000020"},{"Pepe","000020"},{"Pepe","000020"}};
        mostrarEnLista(datos);
    }

    private void mostrarEnLista(String[][] datos){
        ListView vista = (ListView)findViewById(R.id.listaContactos);
        String[]nombres = new String[datos.length];
        for(int i=0;i<datos.length;i++)
            nombres[i]=datos[i][0];

        AdapterContactos adapter = new AdapterContactos(this,android.R.layout.simple_list_item_1,R.id.nombre,nombres);

        adapter.setDatos(datos);

        vista.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_contactos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
