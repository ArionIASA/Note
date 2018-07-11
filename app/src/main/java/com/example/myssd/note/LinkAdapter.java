package com.example.myssd.note;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myssd.note.Link.MyLink;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.Inflater;


//Кастомный адаптер для возможности менять цветик в ячеечках
public class LinkAdapter extends ArrayAdapter<MyLink> {

    private Context mContext;
    private int id;
    private List<MyLink> items;
    Context ctx;
    LayoutInflater lInflater;

    public LinkAdapter(@NonNull Context context, int resource, @NonNull List<MyLink> ar) {
        super(context, resource, ar);
        mContext = context;
        id = resource;
        items = ar;
        lInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов

    @Override
    public int getCount() {
        return items.size();
    }

    // элемент по позиции
    @Override
    public MyLink getItem(int position) {
        return items.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }


    @NonNull
    @Override
    public View getView(int position, View v, @NonNull ViewGroup parent) // методик, который меняет вид нашей вьюшечки
    {
        View mView = v ;
        if (mView == null) {
            mView = lInflater.inflate(R.layout.item, parent, false);
        }

        MyLink s = getItem(position);



        TextView text = (TextView) mView.findViewById(R.id.tvDescr);

        text.setText(s.getJust_link());
        text.setTextColor(Color.BLACK);


        //а вот тут собсн и происходит установка цвета бэкграунда по статусу ссылки (пока что стрингов)
        if(s.getStatus()==1){
            mView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorGreenBackground));
        }
        else if(s.getStatus()==2){
            mView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorRedBackground));
        }
        else{
            //                               convert R.color to Color
            mView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorGreyBackground));
        }

        return mView;
    }


}

