package com.otb.strawberryroad;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MobilesAdapter extends RecyclerView.Adapter <MobilesAdapter.MobilesViewHolder> {
    private Context mCtx;
    private List<Mobile> mobileList;

    public MobilesAdapter(Context mCtx, List<Mobile> mobileList) {
        this.mCtx = mCtx;
        this.mobileList = mobileList;
    }

    @Override
    public MobilesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_mobiles, parent, false);
        return new MobilesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MobilesViewHolder holder, int position) {
        Mobile m = mobileList.get(position);
        holder.textViewNumber.setText(m.getNumber());


        if (m.getDefault_one())
            holder.textViewDefault.setText("Default");
        else
            holder.textViewDefault.setText("Not Default");

        if (m.getVerified())
            holder.textViewDefault.setText("Verified");
        else
            holder.textViewDefault.setText("Not Verified");
    }

    @Override
    public int getItemCount() {
        return mobileList.size();
    }


    class MobilesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewNumber, textViewDefault, textViewVerified;

        public MobilesViewHolder(View itemView) {
            super(itemView);

            textViewNumber = itemView.findViewById(R.id.textViewNumber);
            textViewDefault = itemView.findViewById(R.id.textViewDefault);
            textViewVerified = itemView.findViewById(R.id.textViewVerified);



            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //Mobile m = mobileList.get(getAdapterPosition());

            //Intent intent = new Intent(mCtx, UpdateMobileActivity.class);
            //intent.putExtra("task", task);

            //mCtx.startActivity(intent);
        }
    }
}
