package com.central.childrensapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*
Activity class for DialPad App
 */

public class Tab_Dialpad extends Activity {

    ApplicationVariables globalVar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_dialpad);

        //Get Application Context
        globalVar = (ApplicationVariables)getApplicationContext();
    }

    //Add Char to TextView string from view.getTag()
    public void updateDial(View view){
        TextView dialString = (TextView) this.findViewById(R.id.dialDisplay);
        String temp = dialString.getText().toString() + view.getTag();
        dialString.setText(temp);
    }

    //Create a String from TextView, then create a substring one Char shorter
    public void updateDialBack(View view){
        TextView dialString = (TextView) this.findViewById(R.id.dialDisplay);
        String temp = dialString.getText().toString();
        if (temp.length() > 0) {
            temp = temp.substring(0, temp.length()-1);
        }
        dialString.setText(temp);
    }

    //Send ID to Application to dial character
    public void dial(View view){
        TextView dialString = (TextView) this.findViewById(R.id.dialDisplay);
        String temp = dialString.getText().toString();
                globalVar.dialID(temp);
    }
}
