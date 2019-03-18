package com.Alatheer.alatheer.schoole.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Alatheer.alatheer.schoole.Models.School_Fees_Model;
import com.Alatheer.alatheer.schoole.R;

import java.util.ArrayList;

/**
 * Created by elashry on 3/7/2018.
 */

public class Fees_Adapter extends RecyclerView.Adapter<Fees_Adapter.Holder>{
    Context context;
    School_Fees_Model Model;
    ArrayList<School_Fees_Model> fees;


    public Fees_Adapter(Context context, ArrayList<School_Fees_Model> fees) {
        this.context = context;
        this.fees = fees;
    }

    @Override
    public Fees_Adapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_school_fees,parent,false);

        return new Fees_Adapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(Fees_Adapter.Holder holder, int position) {
        Model=fees.get(position);
        holder.linearLayout.setTag(position);

        holder.name.setText(Model.getAr_name());
        holder.tuition_fees.setText(Model.getTuition_fees());
        holder.pay.setText(Model.getTransfer_fees_1());

    }

    @Override
    public int getItemCount() {
        return  fees.size();
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, tuition_fees,pay;
        LinearLayout linearLayout;

        public Holder(View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.txt_ar_name);
            tuition_fees=itemView.findViewById(R.id.txt_transfer_fees);
            pay=itemView.findViewById(R.id.txt_pay);
            linearLayout=itemView.findViewById(R.id.linear_fees);
            linearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int position = (int) view.getTag();




        }
    }
}
