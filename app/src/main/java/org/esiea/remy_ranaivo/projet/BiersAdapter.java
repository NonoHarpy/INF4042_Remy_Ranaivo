package org.esiea.remy_ranaivo.projet;

import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nora on 21/11/16.
 */

public class BiersAdapter extends RecyclerView.Adapter<BiersAdapter.BierHolder> {


    static JSONArray biers;

    public BiersAdapter(JSONArray jsonArray){
        this.biers = jsonArray;

    }

    @Override
    public BierHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());


        return new BierHolder(inflater.inflate(R.layout.rv_bier_element,parent,false));
    }

    @Override
    public void onBindViewHolder(BierHolder holder, int position) {

        try {
            holder.name.setText("Nom : "+biers.getJSONObject(position).getString("Nom")+ "\n" +biers.getJSONObject(position).getString("Attaque"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return biers.length();
    }

    public void setNewBiere(JSONArray array){
        this.biers = array;
        notifyDataSetChanged();

    }

    class BierHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public BierHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.rv_bier_element_name);


        }
    }
}
