package com.central.childrensapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;

/*
Activity class to fill Bad Phonebook
 */

public class Tab_PhoneBad extends ListActivity {

    ApplicationVariables globalVar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.tab_phonebad);

        //Get Application context
        globalVar = (ApplicationVariables)getApplicationContext();

        // Binding resources Array to ListAdapter
        this.setListAdapter(new Adapter_CharacterObject(false, getApplicationContext()));
    }
}