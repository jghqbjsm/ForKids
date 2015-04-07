package com.central.childrensapp;

import android.app.Application;

/*
This class extends Application.
This is used to alter the context of the application to provide global variables
Global variables will be created in onCreate
 */

public class ApplicationVariables extends Application {

    //Arrays to be stored and used
    CharacterObject[] goodCharacters;
    CharacterObject[] badCharacters;
    String[] idCharacters;

    // Declaration of internal memory location to be used for storage and retrieval
    String internalDirectory = "";

    @Override
    public void onCreate() {
        super.onCreate();

        //Get from internal memory by searching destination
        //PLACEHOLDER
        goodCharacters = new CharacterObject[]{new CharacterObject(getApplicationContext(), "000", "Good Placeholder", true)};
        badCharacters = new CharacterObject[]{new CharacterObject(getApplicationContext(), "999", "Bad Placeholder", false)};

        //At end of script, cycle all characters and make an ID array
        idCharacters = new String[goodCharacters.length + badCharacters.length];
        int i = 0;
        for(int j = 0; j < goodCharacters.length; j++)
        {
            idCharacters[i] = goodCharacters[j].id;
            i++;
        }
        for(int j = 0; j < badCharacters.length; j++)
        {
            idCharacters[i] = badCharacters[j].id;
            i++;
        }
    }

    //Return methods for global variables
    public CharacterObject[] getGoodCharacters(){return goodCharacters;}
    public CharacterObject[] getBadCharacters(){return badCharacters;}
    public String[] getIdCharacters(){return idCharacters;}

    //Methods to initiate dial activity inside Character Object arrays
    //Located by position in badCharacters or goodCharacters
    public void dialBad(int position){badCharacters[position].dialCharacter();}
    public void dialGood(int position){goodCharacters[position].dialCharacter();}

    //Method to initiate dial activity inside Character Object arrays
    //Located by searching ID in badCharacters and goodCharacters
    public void dialID(String ID){
        for(int i = 0; i < goodCharacters.length; i++)
        {
            if(ID.equals(goodCharacters[i].id))
                goodCharacters[i].dialCharacter();
        }
        for(int i = 0; i < badCharacters.length; i++)
        {
            if(ID.equals(badCharacters[i].id))
                badCharacters[i].dialCharacter();
        }
    }
}
