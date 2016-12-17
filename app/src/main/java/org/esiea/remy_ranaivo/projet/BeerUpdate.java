package org.esiea.remy_ranaivo.projet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by nora on 08/11/16.
 */

public class BeerUpdate extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("tag",intent.getAction());
        Toast.makeText(context,"download is finished",Toast.LENGTH_LONG).show();
        ((BiersAdapter) MainActivity.rv.getAdapter()).setNewBiere(BiersAdapter.biers);
    }
}
