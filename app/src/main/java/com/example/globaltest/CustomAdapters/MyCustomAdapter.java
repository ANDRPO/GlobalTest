package com.example.globaltest.CustomAdapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.globaltest.MyCustomTransformers;
import com.example.globaltest.Data.MyDataUsers;
import com.example.globaltest.R;
import com.squareup.picasso.Picasso;


import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<MyDataUsers> {
    private static final String TAG = "MyCustomAdapter";
    private Activity context;
    private List<MyDataUsers> newsList;

    public MyCustomAdapter(Activity context,List<MyDataUsers> newsList){
        super(context, R.layout.my_item,newsList);
        this.context = context;
        this.newsList = newsList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View listViewItem = inflater.inflate(R.layout.my_item,null,true);
        TextView textView_first_name = listViewItem.findViewById(R.id.first_name);
        TextView textView_second_name = listViewItem.findViewById(R.id.second_name);
        TextView textView_age = listViewItem.findViewById(R.id.age);

        MyDataUsers user = newsList.get(position);
        textView_first_name.append(user.getFir_name_st());
        textView_second_name.append(user.getSec_name_st());
        textView_age.append(user.getAge_st());

        Picasso.with(context)
                .load(user.getUrl_st())
                .resize(100,100)
                .transform(new MyCustomTransformers())
                .placeholder(R.drawable.wait)
                .error(R.drawable.error)
                .into((ImageView) listViewItem.findViewById(R.id.img_pers));
        return listViewItem;
    }
}