package org.esiea.remy_ranaivo.projet;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    static public RecyclerView rv;
    private DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv_view = (TextView)findViewById(R.id.dateView);

        dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                tv_view.setText(i+"/"+(i1+1)+"/"+i2);
            }
        }, 2016,11,7);
    }

    public void notification_test(){
        Intent myIntent = new Intent(this, MainActivity.class);
        PendingIntent myPendingIntent = PendingIntent.getActivity(this, 0, myIntent, 0);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notif = new Notification.Builder(this)
                .setContentTitle("Pokedex")
                .setSmallIcon(R.mipmap.pokeball)
                .build();
        mNotificationManager.notify(1, notif);

    }


    public void date_fct(View v){
        Toast.makeText(this, "Affichage du calendrier", Toast.LENGTH_SHORT).show();
         dpd.show();
        notification_test();
    }

    public void fct(View v){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_ALERT:
                // Create out AlterDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Êtes-vous sûr de vouloir quitter l'application ?");
                builder.setCancelable(true);
                builder.setPositiveButton("Oui", new OkOnClickListener());
                builder.setNegativeButton("Non", new CancelOnClickListener());
                AlertDialog dialog = builder.create();
                dialog.show();
        }
        return super.onCreateDialog(id);
    }

    private final class CancelOnClickListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getApplicationContext(), "L'activité continue",
                    Toast.LENGTH_LONG).show();
        }
    }

    private final class OkOnClickListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            MainActivity.this.finish();
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showDialog(DIALOG_ALERT);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public static final String POKEMON_UPDATE="com.octip.cours.inf4042_11.BEERS_UPDATE";
    private static final int DIALOG_ALERT = 10;
}