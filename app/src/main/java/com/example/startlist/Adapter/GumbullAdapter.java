package com.example.startlist.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.startlist.Bean.Gumbull;
import com.example.startlist.R;
import com.example.startlist.service.GumbullService;


import java.util.ArrayList;
import java.util.List;

public class GumbullAdapter extends RecyclerView.Adapter<GumbullAdapter.GumbullViewHolder> implements Filterable {

    private List<Gumbull> gumbulls;
    private List<Gumbull> gumbullFull;
    private Context context;

    public GumbullAdapter(List<Gumbull> list, Context context) {
        this.gumbulls = list;
        this.gumbullFull = new ArrayList<>(list);
        this.context = context;
    }

    @NonNull
    @Override
    public GumbullViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.context).inflate(R.layout.star_item, parent, false);

        final GumbullViewHolder hgumbull = new GumbullViewHolder(v);

        hgumbull.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View popup = LayoutInflater.from(context).inflate(R.layout.popup_item, null, false);
                final TextView nomp = popup.findViewById(R.id.nomp);
                final ImageView photop = popup.findViewById(R.id.photop);
                final RatingBar starp = popup.findViewById(R.id.starp);

                Gumbull gumbull = gumbulls.get(hgumbull.getAdapterPosition());
                Bitmap bitmap = ((BitmapDrawable) hgumbull.photo.getDrawable()).getBitmap();
                photop.setImageBitmap(bitmap);
                nomp.setText(gumbull.getNom());
                starp.setRating(gumbull.getStar());


                AlertDialog alertDialog = new AlertDialog.Builder(context)
                        .setTitle("Notez Gumbull:")
                        .setMessage("Donner une note entre 1 et 5 :")
                        .setView(popup)
                        .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                float r = starp.getRating();
                                gumbull.setStar(r);
                                GumbullService.getInstance().update(gumbull);
                                notifyItemChanged(hgumbull.getAdapterPosition());
                            }
                        })
                        .setNegativeButton("Annuler", null)
                        .create();

                alertDialog.show();
            }
        });
        return hgumbull;
    }

    @Override
    public void onBindViewHolder(@NonNull GumbullViewHolder holder, int position) {
        Gumbull gumbull = gumbulls.get(position); // Récupérez l'élément
        holder.nom.setText(gumbull.getNom());
        holder.star.setRating(gumbull.getStar());

        Glide.with(context)
                .load(gumbull.getPhoto())
                .centerCrop()
                .into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return gumbulls.size();
    }

    class GumbullViewHolder extends RecyclerView.ViewHolder {

        TextView nom;
        ImageView photo;
        RatingBar star;

        public GumbullViewHolder(View itemView) {
            super(itemView);

            nom = itemView.findViewById(R.id.nom);
            photo = itemView.findViewById(R.id.photo);
            star = itemView.findViewById(R.id.star);
        }
    }

    @Override
    public Filter getFilter() {
        return gumbullFilter;
    }

    private Filter gumbullFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charGumbull) {
            List<Gumbull> filteredList = new ArrayList<>();

            if (charGumbull == null || charGumbull.length() == 0) {
                filteredList.addAll(gumbullFull);
            } else {
                String filterPattern = charGumbull.toString().toLowerCase().trim();

                for (Gumbull item : gumbullFull) {
                    if (item.getNom().toLowerCase().startsWith(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            gumbulls.clear();
            gumbulls.addAll((List<Gumbull>) results.values);
            notifyDataSetChanged();
        }
    };
}
