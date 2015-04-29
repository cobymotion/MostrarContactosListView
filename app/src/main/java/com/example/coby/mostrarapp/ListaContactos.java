package com.example.coby.mostrarapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;


public class ListaContactos extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_my_toolbar);
        toolbar.setTitle("Usuarios de la libreta");
        Bitmap nuevo = BitmapFactory.decodeResource(getResources(),R.drawable.usuario);
        Bitmap resized = Bitmap.createScaledBitmap(nuevo, 56, 56, true);
        Drawable logo = new BitmapDrawable(getResources(),resized);
        toolbar.setLogo(logo);
        setSupportActionBar(toolbar);
        String[][] datos={{"Pepe","000020"},{"Pepe","000020"},{"Pepe","000020"}};
        mostrarEnLista(datos);
        FloatingActionButton boton = (FloatingActionButton)findViewById(R.id.boton_flota);
        boton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(ListaContactos.this,"Presiono",Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    public void hacer(View v)
    {
        Toast.makeText(ListaContactos.this,"Presiono",Toast.LENGTH_LONG).show();
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
