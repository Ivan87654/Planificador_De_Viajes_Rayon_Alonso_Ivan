package es.ies.claudiomoyano.dam2.pmdm.planificador_de_viajes_rayon_alonso_ivan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvViajes;
    private AdaptadorViajes adaptadorViajes;
    private List<Viaje> listaViajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvViajes = findViewById(R.id.rv_viajes);


        listaViajes = new ArrayList<>();
        cargarViajesEjemplo();


        rvViajes.setLayoutManager(new LinearLayoutManager(this));


        adaptadorViajes = new AdaptadorViajes(listaViajes);
        rvViajes.setAdapter(adaptadorViajes);


        adaptadorViajes.setOnItemClickListener(new AdaptadorViajes.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Viaje viajeSeleccionado = listaViajes.get(position);

                Intent intent = new Intent(MainActivity.this, ActividadDetalleViaje.class);
                intent.putExtra("titulo", viajeSeleccionado.getTitulo());
                intent.putExtra("fecha", viajeSeleccionado.getFechaSalida());
                intent.putExtra("imagen", viajeSeleccionado.getIdRecursoImagen());

                startActivity(intent);
            }
        });


        adaptadorViajes.setOnItemMenuListener(new AdaptadorViajes.OnItemMenuListener() {
            @Override
            public void onEditar(int position) {


                Viaje viajeSeleccionado = listaViajes.get(position);

                Intent intent = new Intent(MainActivity.this, ActividadDetalleViaje.class);
                intent.putExtra("titulo", viajeSeleccionado.getTitulo());
                intent.putExtra("fecha", viajeSeleccionado.getFechaSalida());
                intent.putExtra("imagen", viajeSeleccionado.getIdRecursoImagen());

                startActivity(intent);
            }

            @Override
            public void onEliminar(int position) {

                listaViajes.remove(position);
                adaptadorViajes.notifyItemRemoved(position);
            }
        });
    }


    private void cargarViajesEjemplo() {
        int imagen = R.drawable.ic_launcher_foreground;

        listaViajes.add(new Viaje("Roma", "12/04/2025", imagen));
        listaViajes.add(new Viaje("París", "20/07/2025", imagen));
        listaViajes.add(new Viaje("Londres", "05/10/2025", imagen));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.opcion_nuevo_viaje) {
            Intent intent = new Intent(MainActivity.this, ActividadNuevoViaje.class);
            startActivity(intent);
            return true;
        }


        if (id == R.id.opcion_acerca_de) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}