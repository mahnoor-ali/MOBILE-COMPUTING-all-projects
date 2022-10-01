package com.mano.theholyqran;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AyatListAdapter extends RecyclerView.Adapter<AyatListAdapter.AyatViewHolder> {

    List<Ayat> ayatList;
    public AyatListAdapter(List<Ayat> ayats) {
        this.ayatList = ayats;
    }

    @NonNull
    @Override
    public AyatListAdapter.AyatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_ayat_list_view, parent, false);
        return new AyatViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AyatListAdapter.AyatViewHolder holder, int position) {
        holder.data=ayatList.get(position);
        holder.ayatArabic.setText(holder.data.getArabic());
        holder.ayatEnglish.setText(holder.data.getEnglish());
        holder.ayatUrdu.setText(holder.data.getUrdu());
    }

    @Override
    public int getItemCount() {
        return ayatList.size();
    }


    public class AyatViewHolder extends RecyclerView.ViewHolder {
        TextView ayatArabic;
        TextView ayatEnglish;
        TextView ayatUrdu;
        Ayat data;
        public AyatViewHolder(@NonNull View itemView) {
            super(itemView);
            ayatArabic =  itemView.findViewById(R.id.ayatArabic);
            ayatEnglish =  itemView.findViewById(R.id.translationE);
            ayatUrdu =  itemView.findViewById(R.id.translationU);
        }
    }
}
