package org.esiea.remy_ranaivo.projet;

import android.content.ContentValues;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static java.security.AccessController.getContext;
import static org.esiea.remy_ranaivo.projet.MainActivity.rv;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        rv = (RecyclerView) findViewById(R.id.rv_pokedex);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));

        rv.setAdapter(new PokedexAdapter(getBiersFromFile()));

        GetPokedexService.startActionPokedex(this);

        IntentFilter intentFilter = new IntentFilter(MainActivity.POKEMON_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new PokedexUpdate(),intentFilter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /*BeerDbHelper db_helper = new BeerDbHelper(this);
        SQLiteDatabase db = db_helper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(BeerDbHelper.BeerEntry.CBEERNAME, "chouffe");TAG
        values.put(BeerDbHelper.BeerEntry.CDESC,"good beer" );

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(BeerDbHelper.BeerEntry.TABLE_NAME, null, values);*/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivityForResult(myIntent,0);
        return true;
    }

    public JSONArray getBiersFromFile(){
        try {
            InputStream is = new FileInputStream(getCacheDir() + "/" + "pokemon.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new JSONArray(new String(buffer, "UTF-8"));
        }catch(IOException e){
            e.printStackTrace();
            return new JSONArray();
        }catch(JSONException e){
            e.printStackTrace();
            return new JSONArray();
        }
    }



}
