package com.example.tpnote;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ListPokemonFragment extends Fragment {
    private final String TAG = "Simon&Damien "+getClass().getSimpleName();

    public ListPokemonFragment() {
        Log.d(TAG, "FragmentA created");
    }


    @Override
    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_pokemon_fragment, container, false);
        // Obtenez une référence à la ListView
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        List<Pokemon> pokemonList = PokemonListHolder.getInstance().getPokemonList();
        for (Pokemon pokemon : pokemonList) {
            Log.d(TAG, pokemon.getName());
        }

        List<String> dataList = new ArrayList<>();
        for(Pokemon pokemon : pokemonList) {
            dataList.add(pokemon.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, dataList);

        listView.setAdapter(adapter);

        return view; }
}