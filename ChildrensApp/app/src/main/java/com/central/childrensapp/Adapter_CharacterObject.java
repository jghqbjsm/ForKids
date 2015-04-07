package com.central.childrensapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/*
ArrayAdapter for the PhoneGood and PhoneBad tabs
Adapter is provided different images for the button to be relevant to page
 */

public class Adapter_CharacterObject extends BaseAdapter {

    ApplicationVariables globalVar;
    boolean globalGoodCharacters;
    Drawable[] contextImage;

    //Creation method
    public Adapter_CharacterObject(boolean GlobalGoodCharacters, Context Context){
        globalGoodCharacters = GlobalGoodCharacters;

        //Get Application context
        globalVar = (ApplicationVariables)Context.getApplicationContext();

        contextImage = new Drawable[]{globalVar.getResources().getDrawable(R.drawable.dial_good_icon), globalVar.getResources().getDrawable(R.drawable.dial_bad_icon)};

    }

    //Get length of global array
    @Override
    public int getCount() {
        if(globalGoodCharacters)
            return globalVar.getGoodCharacters().length;
        else
            return globalVar.getBadCharacters().length;
    }
    //Stub method
    @Override
    public Object getItem(int position) {
        return null;
    }
    //Stub method
    @Override
    public long getItemId(int position) {
        return position;
    }

    //Fill method for items
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) globalVar.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.dial_list_item, parent, false);

        //Create temp char object from array
        CharacterObject temp;
        if(globalGoodCharacters)
            temp = globalVar.getGoodCharacters()[position];
        else
            temp = globalVar.getBadCharacters()[position];

        //Find icon ImageView then set to Character icon
        ImageView iconView = (ImageView) row.findViewById(R.id.iconView);
        iconView.setImageDrawable(temp.getIcon());

        //Find title TextView then set to Character title
        TextView titleView = (TextView) row.findViewById(R.id.title);
        titleView.setText(temp.getTitle());

        //Find dial icon ImageView then set to context image based on character alignment
        ImageButton buttonView = (ImageButton) row.findViewById(R.id.contextButton);
        if (temp.getGoodCharacter())
            buttonView.setImageDrawable(contextImage[0]);
        else
            buttonView.setImageDrawable(contextImage[1]);

        //Set onClick listener to application dial method
        if(globalGoodCharacters) {
            buttonView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    globalVar.dialGood(position);
                }
            });
        }
        else {
            buttonView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    globalVar.dialBad(position);
                }
            });
        }


        return row;
    }
}
