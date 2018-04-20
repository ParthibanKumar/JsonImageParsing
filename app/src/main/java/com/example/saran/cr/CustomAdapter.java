package com.example.saran.cr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>
{
        StringRequest stringRequest;
        RequestQueue requestQueue;


    Context context;
    ArrayList<ListClass> arrayList =new ArrayList<>();

    public CustomAdapter(Context context, ArrayList<ListClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View app = inflater.inflate(R.layout.singlerow,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(app);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        ListClass listClass = arrayList.get(position);
        holder.tv1.setText(listClass.getRank());
        holder.tv2.setText(listClass.getCountry());
        holder.tv3.setText(listClass.getPopulation());
        Picasso.with(context).load(listClass.getImg()).into(holder.im);
        //Glide.with(context).load(listClass.getPic()).into(holder.im);

    }

    @Override
    public int getItemCount()
    {
        return arrayList.size();


    }

public static class MyViewHolder extends RecyclerView.ViewHolder
{
    TextView tv1,tv2, tv3;
    ImageView im;

    public MyViewHolder(View itemView)
    {
        super(itemView);
        tv1 = itemView.findViewById(R.id.textView);
        tv2 = itemView.findViewById(R.id.textView2);
        tv3 = itemView.findViewById(R.id.textView3);
        im = itemView.findViewById(R.id.imageView);

    }
}

}

