package com.example.test.Data.Entity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.test.GameActivity;
import com.example.test.GameView;
import com.example.test.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SkinAdapterRecycler extends RecyclerView.Adapter<SkinAdapterRecycler.SkinViewHolder> {

    private Context context;
    private List<Skin> listSkin = new ArrayList<>();
    private ArrayList<Integer> integerArrayList;

    public SkinAdapterRecycler(List<Skin> listSkin, Context context, ArrayList<Integer> integerArrayList) {
        this.context = context;
        this.listSkin = listSkin;
        this.integerArrayList = integerArrayList;
    }

    private AppDatabase database;
    @NonNull
    @Override
    public SkinAdapterRecycler.SkinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.skin_item, parent, false);
        return new SkinViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull SkinAdapterRecycler.SkinViewHolder holder, int position) {
        holder.bind(listSkin.get(position));
        Glide.with(context)
                .load(integerArrayList.get(position))
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return listSkin.size();

    }

    public class SkinViewHolder extends RecyclerView.ViewHolder {

        private final TextView priceText;
        private final ImageView image;
        FloatingActionButton backButton;

        public SkinViewHolder(@NonNull View itemView) {
            super(itemView);
            priceText = itemView.findViewById(R.id.coinPrice);
            image = itemView.findViewById(R.id.imageView);
            backButton = itemView.findViewById(R.id.backbtn);

        }

        private void bind(Skin skin) {
            priceText.setText(String.valueOf(skin.getPrice()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                    builder.setTitle(trimName(skin.getSkinname()));
                    String trimmedSkinName = trimName(skin.getSkinname());
                    builder.setItems(R.array.option_menu, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            switch (id) {
                                case 0:

                                    // Handle case 0
                                    if(skin.getSkin()){
                                        Toast.makeText(context, "you already own "+ trimmedSkinName + " skin", Toast.LENGTH_SHORT).show();
                                    }else {

                                        Toast.makeText(context, "you Bought own "+ trimmedSkinName + " skin", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                case 1:
                                    if(skin.getSkin()){
                                        GameView.birdSkin = trimmedSkinName;
                                        Toast.makeText(context, "you Equiped "+ trimmedSkinName + " skin", Toast.LENGTH_SHORT).show();
                                    }else {

                                        Toast.makeText(context, "you Don't own "+ trimmedSkinName + " skin", Toast.LENGTH_SHORT).show();
                                    }

                                    break;
                                default:
                                    break;
                            }
                        }
                    });
                    builder.create().show();
                }
            });

        }

        private String trimName( String fileName){
            String trimmedFileName;

            // Find the index of the dot (.) before the file extension
            int dotIndex = fileName.lastIndexOf('2');
            if (dotIndex != -1) {
                // Get the substring from the start to the dot index
                trimmedFileName = fileName.substring(0, dotIndex);
            } else {
                // If there's no dot in the file name
                trimmedFileName = fileName;
            }

            return trimmedFileName;
        }

    }
}
