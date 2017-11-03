package com.example.wagner.agromoviltest3;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class CustomListview extends ArrayAdapter<String>{
    private String[] transporternames;
    private String[] addresses;
    private String[] make_car;
    private Integer[] imgid;

    private Activity context;
    public CustomListview(Activity context,String[] transporternames, String[] addresses,
                          String[] make_car,Integer[] imgid){
        super(context, R.layout.listview_layout,transporternames);
        this.context=context;
        this.transporternames=transporternames;
        this.addresses=addresses;
        this.make_car=make_car;
        this.imgid=imgid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder = null;
        if(r==null)
        {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) r.getTag();
        }

        viewHolder.ivw.setImageResource(imgid[position]);
        viewHolder.tvw1.setText(transporternames[position]);
        viewHolder.tvw2.setText(addresses[position]);
        viewHolder.tvw3.setText(make_car[position]);

        return r;
    }

    class ViewHolder
    {
        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        ImageView ivw;
        ViewHolder(View v)
        {
            tvw1= v.findViewById(R.id.transporterNames);
            tvw2= v.findViewById(R.id.addresses);
            tvw3= v.findViewById(R.id.carMake);
            ivw= v.findViewById(R.id.imageView);
        }
    }
}