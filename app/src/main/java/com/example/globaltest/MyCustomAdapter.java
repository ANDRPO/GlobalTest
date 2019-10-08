package com.example.globaltest;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
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
        TextView textViewid = listViewItem.findViewById(R.id.id);
        TextView textViewfirst = listViewItem.findViewById(R.id.first_name);
        TextView textViewsecond = listViewItem.findViewById(R.id.second_name);
        TextView textViewlast = listViewItem.findViewById(R.id.last_name);
        TextView textViewcity = listViewItem.findViewById(R.id.city);
        TextView textViewage = listViewItem.findViewById(R.id.age);

        MyDataUsers user = newsList.get(position);
        textViewid.append(String.valueOf(user.getId_st()));
        textViewfirst.append(user.getFir_name_st());
        textViewsecond.append(user.getSec_name_st());
        textViewlast.append(user.getLas_name_st());
        textViewcity.append(user.getCity_st());
        textViewage.append(user.getAge_st());


        return listViewItem;
    }
}