package es.ies.claudiomoyano.dam2.pmdm.planificador_de_viajes_rayon_alonso_ivan;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActividadDetalleViaje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_detalle_viaje);


        ImageView imgPortada = findViewById(R.id.img_portada_detalle);
        TextView txtTitulo = findViewById(R.id.txt_titulo_detalle);
        TextView txtFecha = findViewById(R.id.txt_fecha_detalle);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String titulo = extras.getString("titulo");
            String fecha = extras.getString("fecha");
            int imagen = extras.getInt("imagen");


            txtTitulo.setText(titulo);
            txtFecha.setText(fecha);
            imgPortada.setImageResource(imagen);
        }
    }
}