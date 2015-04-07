package com.central.childrensapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class ServerConnection {

    Context context;

    String[] ownedIDs;
    String url = "";

    String[] returnedIDs;
    String[] returnedTitle;
    String[] returnedMD5;
    Drawable[] returnedIcon;
    boolean[] returnedGood;

    static InputStream inputStream = null;

    public ServerConnection(Context Context)
    {
        context = Context;
    }

    public void setOwned(String[] Input)
    {
        ownedIDs = Input;
    }

    public void getCharArrayFromServer() {

        String result = "";
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);

        try {
            HttpResponse httpresponse = httpclient.execute(httppost);
            HttpEntity httpentity = httpresponse.getEntity();
            inputStream = httpentity.getContent();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;

            try {
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }

                inputStream.close();
                result = stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            JSONArray jArray = new JSONArray(result);

            returnedIDs = new String[jArray.length()];
            returnedTitle = new String[jArray.length()];
            returnedMD5 = new String[jArray.length()];
            returnedIcon = new Drawable[jArray.length()];
            returnedGood = new boolean[jArray.length()];

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                returnedIDs[i] = json_data.getString("id");
                returnedTitle[i] = json_data.getString("title");
                returnedMD5[i] = json_data.getString("md5");
                returnedGood[i] = json_data.getBoolean("goodChar");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getCharFromServer() {

        String result = "";
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);

        try {
            HttpResponse httpresponse = httpclient.execute(httppost);
            HttpEntity httpentity = httpresponse.getEntity();
            inputStream = httpentity.getContent();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;

            try {
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }

                inputStream.close();
                result = stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            JSONArray jArray = new JSONArray(result);

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getServerCharacters(boolean RemoveOwned)
    {
        //PLACEHOLDER
        Drawable temp = context.getResources().getDrawable(R.drawable.empty_icon);
        returnedIDs = new String[]      {"0455 500 001",    "0455 500 002"};
        returnedIcon = new Drawable[]   {temp,              temp};
        returnedTitle = new String[]    {"Good FromServer", "Bad FromServer"};
        returnedGood = new boolean[]    {true,              false};
    }

    public String[] getIDs()
    {
        return returnedIDs;
    }

    public String[] getTitle()
    {
        return returnedTitle;
    }

    public String[] getMD5()
    {
        return returnedMD5;
    }

    public Drawable[] getIcon()
    {
        return returnedIcon;
    }

    public boolean[] getGood()
    {
        return returnedGood;
    }
}
