package com.example.pruebasenvistas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pruebasenvistas.Model;
import com.example.pruebasenvistas.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Model> {

    private ArrayList<Model> modelArrayList;
    Context context;

    public CustomAdapter(ArrayList<Model> modelArrayList,Context context){
        super(context, R.layout.item_list, modelArrayList);
        //contexto, la vista predefinida del item list, el data source
        this.context=context;
        this.modelArrayList=modelArrayList;
    }

    private static class MyViewHolder{
        TextView textView,textView2;
        ImageView imageView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Model model = getItem(position);

        MyViewHolder myViewHolder;
        final View result;

        if(convertView==null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView=inflater.inflate(
                    R.layout.item_list,
                    parent,
                    false
            );
            //find view
            myViewHolder.imageView = convertView.findViewById(R.id.imageView);
            myViewHolder.textView = convertView.findViewById(R.id.name);
            myViewHolder.textView2 = convertView.findViewById(R.id.description);

            result = convertView;
            convertView.setTag(myViewHolder);
        }else{
         myViewHolder = (MyViewHolder) convertView.getTag();
         result= convertView;
        }
        myViewHolder.textView.setText(model.getName());
        myViewHolder.imageView.setImageResource(model.getImage());
        myViewHolder.textView2.setText(model.getDescription());
        return result;
    }
}
