package es.ies.claudiomoyano.dam2.pmdm.planificador_de_viajes_rayon_alonso_ivan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorViajes extends RecyclerView.Adapter<AdaptadorViajes.ViajeViewHolder> {

    private List<Viaje> listaViajes;

    public AdaptadorViajes(List<Viaje> listaViajes) {
        this.listaViajes = listaViajes;
    }

    @NonNull
    @Override
    public ViajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vistaItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_viaje, parent, false);
        return new ViajeViewHolder(vistaItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViajeViewHolder holder, int position) {

        Viaje viaje = listaViajes.get(position);


        holder.txtTitulo.setText(viaje.getTitulo());
        holder.txtFecha.setText(viaje.getFechaSalida());
        holder.imgPortada.setImageResource(viaje.getIdRecursoImagen());
    }

    @Override
    public int getItemCount() {
        return listaViajes.size();
    }


    public static class ViajeViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPortada;
        TextView txtTitulo;
        TextView txtFecha;

        public ViajeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPortada = itemView.findViewById(R.id.img_portada_item);
            txtTitulo = itemView.findViewById(R.id.txt_titulo_item);
            txtFecha = itemView.findViewById(R.id.txt_fecha_item);
        }
    }
}
