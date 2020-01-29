package com.example.downloadstring;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetData extends AsyncTask<String, Void, String> {
    private String adress;
    private TextView tv;
    public GetData(String adr, TextView t){
        this.adress=adr;
        this.tv=t;
    }
    @Override
    protected String doInBackground(String... strings) {
        String message = "";

        try {
            URL url = new URL(adress);

            // read text returned by server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = "";
            while ((line = in.readLine()) != null) {
                message+=line;
            }
            in.close();

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }

        String[] text;
        text=message.split("<div id=\"paste\">");
        text=text[1].split("</div>");
        message=text[0];
        String finalMessage="";
        int len=message.length();
        Boolean delete=false;
        String c;
        for (int i = 0; i < len; ++i){
            c = String.valueOf(message.charAt(i));
            if (c.equals("<")){delete=true;}
            if(!delete){
                finalMessage=finalMessage+c;
            }
            if (c.equals(">")){delete=false;}
        }
        return finalMessage;
    }
    protected void onPostExecute(String finalMessage){
        tv.setText(finalMessage);
    }
}
