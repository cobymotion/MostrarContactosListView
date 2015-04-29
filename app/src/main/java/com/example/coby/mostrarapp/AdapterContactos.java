package com.example.coby.mostrarapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by coby on 4/28/15.
 */
public class AdapterContactos extends ArrayAdapter<String> {

    private Context contexto;
    private String[][] datos;

    public AdapterContactos(Context context, int resource, int textViewResourceId,
                              String[] strings) {
        super(context, resource, textViewResourceId, strings);
        this.contexto = context;
    }


    public void setDatos(String[][] datos)
    {
        this.datos = datos;
    }

    // Metodo encargado de crear la vista personalizada que sera regresada a nuestro ListView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View vistaDesdeXML = inflador.inflate(R.layout.vista_contactos, parent, false);

        TextView nombre = (TextView) vistaDesdeXML.findViewById(R.id.nombre);
        TextView telefono = (TextView) vistaDesdeXML.findViewById(R.id.telefono);

        nombre.setText(datos[position][0]);
        telefono.setText("Tel: " + datos[position][1]);
        return vistaDesdeXML;
    }
}
