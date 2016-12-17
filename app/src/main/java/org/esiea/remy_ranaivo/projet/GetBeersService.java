package org.esiea.remy_ranaivo.projet;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class GetBeersService extends IntentService {
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String GET_ALL_BEER = "org.esiea.remy_ranaivo.projet.action.GET_ALL_BEER";




    public GetBeersService() {
        super("GetBeersService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBeer(Context context) {
        Intent intent = new Intent(context, GetBeersService.class);
        intent.setAction(GET_ALL_BEER);
        context.startService(intent);


    }



    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("tag","test");
        if (intent != null) {
            final String action = intent.getAction();
            if (GET_ALL_BEER.equals(action)) {
              handleActionBeers();
            }
        }
    }


    private void handleActionBeers() {
        // TODO: Handle action Beer
        Log.d("TAG","Nom du thread:"+Thread.currentThread().getName());
        URL url=null;
        try{
            url=new URL("http://82.236.131.8/pokemon.json");
            HttpURLConnection conn=(HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if(HttpURLConnection.HTTP_OK==conn.getResponseCode()){
                copyInputStreamToFile(conn.getInputStream(),new File(getCacheDir(),"pokemon.json"));
                Log.d("TAG","Bieres json téléchargées");

                LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(MainActivity.BEERS_UPDATE));
            }


        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    private void copyInputStreamToFile(InputStream in, File file){
        try {
            OutputStream out=new FileOutputStream(file);
            byte[] buf=new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        }catch (Exception e){
        }
    }



}
