package com.example.listadecontactos;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

  //  private lista_Contactos[] listdata;
  private ArrayList<lista_Contactos>listdata;


    public ContactAdapter(ArrayList<lista_Contactos> arr) {
        this.listdata = arr;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.contactos_car,parent,false);
        ContactAdapter.ViewHolder viewHolder=new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        final lista_Contactos c = listdata.get(position);

        holder.tvNombre.setText(listdata.get(position).getNombre());
        holder.ivPersona.setImageResource(listdata.get(position).getFoto());
        if(listdata.get(position).getFlag() == 1){
            holder.ivPersona.setImageURI(listdata.get(position).getImagen());
        }else if(listdata.get(position).getFlag() == 0){
            holder.ivPersona.setImageResource(listdata.get(position).getFoto());
        }
        holder.tvNumero.setText(listdata.get(position).getNumTelf());
        holder.tvCorreo.setText(listdata.get(position).getCorreo());
        holder.btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
            holder.btnLlamar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String telf=listdata.get(position).getNumTelf();
                    //TODO ACCEDER A LA APP DE LLAMADAS DEL DISPOSITIVO MOVIL
                }
            });

        //holder.imageView.setImageResource(listdata[position].getImgvw());

        holder.llTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), c.getNombre(),Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public int getItemCount() {

        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivPersona;
        public TextView tvNombre,tvNumero,tvCorreo;
        public Button btnBorrar,btnLlamar;
        public LinearLayout llTotal;

        public ViewHolder(View itemview){
            super(itemview);

            this.ivPersona=(ImageView) itemView.findViewById(R.id.imageView);
            this.tvNombre=(TextView) itemView.findViewById(R.id.tvNombre);
            this.tvNumero=(TextView) itemView.findViewById(R.id.tvNumero);
            this.tvCorreo=(TextView) itemView.findViewById(R.id.tvCorreo);

            this.btnBorrar=(Button)itemview.findViewById(R.id.btBorrar);
            this.btnLlamar=(Button)itemview.findViewById(R.id.btnLlamar);           


            this.llTotal=(LinearLayout) itemview.findViewById(R.id.llTotal);

        }

    }
}
