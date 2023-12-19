package com.example.healthcareproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcareproject.Doctors.DoctorDetails;
import com.example.healthcareproject.Model.DoctorModel;
import com.example.healthcareproject.R;

import java.util.ArrayList;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.viewHolder> {
    ArrayList<DoctorModel>list;
    Context context;

    public DoctorAdapter(ArrayList<DoctorModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DoctorAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_list,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorAdapter.viewHolder holder, int position) {
        DoctorModel doctorModel=list.get(position);
        holder.doctorImg.setImageResource(doctorModel.getDoctorImg());
        holder.doctorDept.setText(doctorModel.getDoctorDept());

        holder.cardView.setOnClickListener(view->{
            Intent i = new Intent(context, DoctorDetails.class);
            i.putExtra("dept", doctorModel.getDoctorDept());
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class viewHolder extends RecyclerView.ViewHolder{
        ImageView doctorImg;
        TextView doctorDept;
        CardView cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            doctorImg=itemView.findViewById(R.id.doctorImg);
            doctorDept=itemView.findViewById(R.id.doctorDept);
            cardView=itemView.findViewById(R.id.cardList);
        }
    }
}
