package com.example.healthcareproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcareproject.Articles.HealthArticlesDetails;
import com.example.healthcareproject.Model.ArticleModel;
import com.example.healthcareproject.R;

import java.util.ArrayList;


public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.viewHolder> {
    ArrayList<ArticleModel> list;
    Context context;

    private final int[][] img = {
            {R.drawable.walk},
            {R.drawable.covid19},
            {R.drawable.smok},
            {R.drawable.cramps},
            {R.drawable.health},
            {R.drawable.workout},
    };

    public ArticleAdapter(ArrayList<ArticleModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ArticleAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.articles_list, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.viewHolder holder, int position) {
        ArticleModel articleModel = list.get(position);
        holder.img.setImageResource(articleModel.getImg());
        holder.title.setText(articleModel.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, HealthArticlesDetails.class);
                i.putExtra("imgArt", articleModel.getImg());
                i.putExtra("titleArt", articleModel.getTitle());
                // Pass the image resource for this article
                i.putExtra("desImg", img[position][0]); // Assuming each article has one image
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.line_q);
            title = itemView.findViewById(R.id.line_p);
        }
    }
}
