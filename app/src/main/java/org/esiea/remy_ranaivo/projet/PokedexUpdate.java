package org.esiea.remy_ranaivo.projet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by nora on 08/11/16.
 */

public class PokedexUpdate extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("tag",intent.getAction());
        Toast txtDownloaded = Toast.makeText(context,R.string.json,Toast.LENGTH_LONG);
        txtDownloaded.show();
        ((PokedexAdapter) MainActivity.rv.getAdapter()).setNewPokedex(PokedexAdapter.pokedex);
    }
}
