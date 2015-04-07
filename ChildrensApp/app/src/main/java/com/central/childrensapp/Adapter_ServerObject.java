package com.central.childrensapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/*
ArrayAdapter for NewContacts page, based on input from server
 */

public class Adapter_ServerObject extends BaseAdapter {

    Context context;
    String[] ids;
    boolean[] goodCharacter;
    String[] title;
    Drawable[] icon;


    Drawable[] contextImage;

    public Adapter_ServerObject(Drawable[] Icon, String[] Title, boolean[] GoodCharacter, String[] IDs, Context Context){
        icon = Icon;
        title = Title;
        goodCharacter = GoodCharacter;
        ids = IDs;
        context = Context;

        contextImage = new Drawable[]{context.getResources().getDrawable(R.drawable.newcontact_good_icon), context.getResources().getDrawable(R.drawable.newcontact_bad_icon)};
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.dial_list_item, parent, false);

        ImageView iconView = (ImageView) row.findViewById(R.id.iconView);
        iconView.setImageDrawable(icon[position]);

        TextView titleView = (TextView) row.findViewById(R.id.title);
        titleView.setText(title[position]);

        ImageButton buttonView = (ImageButton) row.findViewById(R.id.contextButton);
        if(goodCharacter[position])
            buttonView.setImageDrawable(contextImage[0]);
        else
            buttonView.setImageDrawable(contextImage[1]);

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InformationActivity.class);
                intent.putExtra("id", ids[position]);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        return row;
    }
}
