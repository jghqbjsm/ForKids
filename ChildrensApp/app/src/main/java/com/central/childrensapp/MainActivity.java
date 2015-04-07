package com.central.childrensapp;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import java.lang.Override;

/*
Overhead Class to create all the tab-activities to be used
 */

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create the TabHost that will contain the Tabs
        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);

        // Set the Tab name and Activity
        // that will be opened when particular Tab will be selected
        TabHost.TabSpec tab1 = tabHost.newTabSpec("Dialpad");
        tab1.setIndicator("Dialpad", getResources().getDrawable(R.drawable.tab_icon_dialpad));
        Intent tab1Intent = new Intent(this,Tab_Dialpad.class);
        tab1.setContent(tab1Intent);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("Good");
        tab2.setIndicator("Good", getResources().getDrawable(R.drawable.tab_icon_phonegood));
        Intent tab2Intent = new Intent(this,Tab_PhoneGood.class);
        tab2.setContent(tab2Intent);

        TabHost.TabSpec tab3 = tabHost.newTabSpec("Bad");
        tab3.setIndicator("Bad", getResources().getDrawable(R.drawable.tab_icon_phonebad));
        Intent tab3Intent = new Intent(this,Tab_PhoneBad.class);
        tab3.setContent(tab3Intent);

        TabHost.TabSpec tab4 = tabHost.newTabSpec("Add");
        tab4.setIndicator("Add", getResources().getDrawable(R.drawable.tab_icon_newcontact));
        Intent tab4Intent = new Intent(this,Tab_NewContact.class);
        tab4.setContent(tab4Intent);

        //Add the tabs to TabHost
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
        tabHost.addTab(tab4);

        //Set initial tab to "Good" contacts page
        tabHost.setCurrentTab(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
