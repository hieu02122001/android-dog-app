package com.example.dogapp.viewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogapp.R;
import com.example.dogapp.model.DogBreed;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder>{


    private static ArrayList<DogBreed> dogs;

    public DogAdapter(ArrayList<DogBreed> dogs) {
        this.dogs = dogs;
    }

    @NonNull
    @Override
    public DogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dog_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(dogs.get(position).getName());
        holder.tvOrigin.setText(dogs.get(position).getOrigin());
        Picasso.get().load(dogs.get(position).getUrl()).into(holder.ivDog);
    }

    @Override
    public int getItemCount() {
        return dogs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivDog;
        public TextView tvName;
        public TextView tvOrigin;
        public ViewHolder(View view) {
            super(view);

            tvName = view.findViewById(R.id.tv_name);
            tvOrigin = view.findViewById(R.id.tv_origin);
            ivDog = view.findViewById(R.id.iv_dogimg);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DogBreed dog = dogs.get(getAdapterPosition());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("dogBreed",dog);
                    Navigation.findNavController(view).navigate(R.id.detailFragment, bundle);
                }
            });
        }
    }
}
