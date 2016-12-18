package org.esiea.remy_ranaivo.projet;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by nora on 21/11/16.
 */

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.PokedexHolder> {


    static JSONArray pokedex;

    public PokedexAdapter(JSONArray jsonArray){
        this.pokedex = jsonArray;

    }

    @Override
    public PokedexHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());


        return new PokedexHolder(inflater.inflate(R.layout.rv_pokedex_element,parent,false));
    }

    @Override
    public void onBindViewHolder(PokedexHolder holder, int position) {
        try {
            new DownloadImageTask(holder.imgPoke).execute(pokedex.getJSONObject(position).getString("Url"));
            holder.name.setText(Html.fromHtml("<b>Nom : </b>" +pokedex.getJSONObject(position).getString("Nom")
                    + "<br><b>PV : </b>" + pokedex.getJSONObject(position).getString("PV")
                    + "<br><b>Attaque </b>" + pokedex.getJSONObject(position).getString("Attaque")
                    + "<br><b>Défense : </b>" + pokedex.getJSONObject(position).getString("Defense")
                    + "<br><b>Type : </b>" + pokedex.getJSONObject(position).getString("Type")));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return pokedex.length();
    }

    public void setNewPokedex(JSONArray array){
        this.pokedex = array;
        notifyDataSetChanged();

    }

    class PokedexHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView nameJson;
        private ImageView imgPoke;

        public PokedexHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.rv_pokedex_element_name);
            nameJson = (TextView) itemView.findViewById(R.id.rv_pokedex_title_name);
            imgPoke=(ImageView) itemView.findViewById(R.id.imgPoke);


        }
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Drawable> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Drawable doInBackground(String... urls) {
            String urldisplay = urls[0];
            Drawable d = null;
            try {
                URL url = new URL(urldisplay);
                InputStream content = (InputStream) url.getContent();
                d = Drawable.createFromStream(content, null);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return d;
        }

        protected void onPostExecute(Drawable result) {
            bmImage.setImageDrawable(result);
        }
    }
}
