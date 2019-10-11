package com.example.globaltest.CustomAdapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.globaltest.Data.MyDataComments;
import com.example.globaltest.R;

import java.util.List;

public class MyCustomAdapterForComments extends ArrayAdapter<MyDataComments> {

        private Activity context;
        private List<MyDataComments> newList;

    public MyCustomAdapterForComments(Activity context, List<MyDataComments> newList) {
        super(context, R.layout.my_item_comments,newList);
        this.context = context;
        this.newList = newList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,  @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View listViewItem_comments= inflater.inflate(R.layout.my_item_comments,null,true);

        TextView textView_comment = listViewItem_comments.findViewById(R.id.person_comments);

        MyDataComments comment = newList.get(position);
        textView_comment.append(comment.getComment());

        return listViewItem_comments;
    }
}
