package com.central.childrensapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/*
This class object is used to house all data relevant to each individual charachter
This is generated from internal memory. Although there is a placeholder creation method.
All references to the DialActivity are to be referenced through the dialCharacter() method.
 */

    public class CharacterObject{

        Context context;
        String id;
        String title;
        String md5;
        Drawable icon;
        boolean goodCharacter;
        String path;

        //Creator Method
        public CharacterObject(Context Context, String ID, String Title, String MD5, Drawable Icon, boolean GoodCharacter, String Path) {
            context = Context;
            id = ID;
            title = Title;
            md5 = MD5;
            //If icon ==null use empty icon
            if (icon != null)
                icon = Icon;
            else
                icon = context.getResources().getDrawable(R.drawable.empty_icon);
            goodCharacter = GoodCharacter;
            path = Path;
        }

        //Placeholder creation method
        public CharacterObject(Context Context, String ID, String Title, boolean GoodCharacter) {
            context = Context;
            id = ID;
            title = Title;
            md5 = "";
            icon = context.getResources().getDrawable(R.drawable.empty_icon);
            goodCharacter = GoodCharacter;
            path = null;
        }

        //Following returns recourses required by Adapter class
        public Drawable getIcon() {return icon;}
        public String getTitle() {return title;}
        public boolean getGoodCharacter() {return goodCharacter;}

        // Begins the intent to play character video
        public void dialCharacter() {
            Intent intent = new Intent(context, DialActivity.class);
            //PLACEHOLDER
            intent.putExtra("path", title);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }