package com.example.nigma.resepmakanan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LinkedList<ModelMasakan> listMasakan;
    private LayoutInflater mInflater;
    private Context context;

    public WordListAdapter(Context context, LinkedList<ModelMasakan> listMasakan) {
        mInflater = LayoutInflater.from(context);
        this.listMasakan = listMasakan;
        this.context = context;
    }
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        ModelMasakan masakan = listMasakan.get(position);
        holder.titleView.setText(masakan.getTitle());
        holder.descView.setText(masakan.getDesc());
    }

    @Override
    public int getItemCount() {
        return listMasakan.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView titleView;
        public final TextView descView;
        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.title);
            descView = (TextView) itemView.findViewById(R.id.desc);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // get data model yang dipilih
            ModelMasakan masakan = listMasakan.get(mPosition);
            // parsing data ke activity ResepPreview
            Intent intent = new Intent(context,ResepPreview.class);
            intent.putExtra("title",masakan.getTitle());
            intent.putExtra("image",masakan.getImage());
            intent.putExtra("bahan",masakan.getBahan());
            intent.putExtra("tahap",masakan.getTahap());
            context.startActivity(intent);

            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }
}

