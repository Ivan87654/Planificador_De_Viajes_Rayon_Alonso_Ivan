package es.ies.claudiomoyano.dam2.pmdm.planificador_de_viajes_rayon_alonso_ivan;

import android.os.Bundle;

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
    }


    private void cargarViajesEjemplo() {
        int imagen = R.drawable.ic_launcher_foreground;

        listaViajes.add(new Viaje("Roma en primavera", "12/04/2025", imagen));
        listaViajes.add(new Viaje("París en verano", "20/07/2025", imagen));
        listaViajes.add(new Viaje("Londres en otoño", "05/10/2025", imagen));
    }
}