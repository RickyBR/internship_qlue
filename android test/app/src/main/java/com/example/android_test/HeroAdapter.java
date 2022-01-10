package com.example.android_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroHolder> {

    private Context context;
    private List<Hero> heroList;

    public HeroAdapter(Context context, List<Hero> heroes){
        this.context = context;
        heroList = heroes;


    }

    @NonNull
    @Override
    public HeroHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);

        return new HeroHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroHolder heroHolder, int i) {

        Hero hero = heroList.get(i);
        heroHolder.nama.setText(hero.getNama().toString());
        heroHolder.roles.setText(hero.getRoles().toString());
        heroHolder.id.setText(hero.getId().toString());
        Glide.with(context).load(hero.getImage()).into(heroHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public class HeroHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView nama, role, id, type, attribute, health, max_attack, speed, roles;
        public HeroHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            nama = itemView.findViewById(R.id.title_tv);
            roles = itemView.findViewById(R.id.role);
            id = itemView.findViewById(R.id.tv_id);
        }
    }

}
