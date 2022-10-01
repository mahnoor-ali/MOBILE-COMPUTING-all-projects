package com.mano.theholyqran;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class ViewAdapter extends ArrayAdapter<Index> {

    public ViewAdapter(@NonNull Context context, @NonNull ArrayList<Index> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Index surahIndex = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_index_list_view, parent, false);
        }
        // according to the position of the view assign the desired surah name in ENGLISH
        TextView surahNameEnglish = convertView.findViewById(R.id.NameEnglish);
        surahNameEnglish.setText(surahIndex.getNameEnglish());
         // assign the desired surah index name in URDU
        TextView surahNameUrdu = convertView.findViewById(R.id.NameUrdu);
        surahNameUrdu.setText( surahIndex.getNameUrdu());

        TextView surahId = convertView.findViewById(R.id.ID);
        String s = Integer.toString(surahIndex.getId());
        surahId.setText(s);
        return convertView;
    }
}
