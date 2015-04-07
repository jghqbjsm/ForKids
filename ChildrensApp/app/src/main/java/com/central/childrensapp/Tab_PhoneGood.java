package com.central.childrensapp;

import android.app.ListActivity;
import android.os.Bundle;

/*
Activity class to fill Good Phonebook
 */

public class Tab_PhoneGood extends ListActivity {

    ApplicationVariables globalVar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.tab_phonegood);

        //Get application context
        globalVar = (ApplicationVariables)getApplicationContext();

        // Binding resources Array to ListAdapter
        this.setListAdapter(new Adapter_CharacterObject(true, getApplicationContext()));
    }
}
