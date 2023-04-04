package com.example.tpnote;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
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
        ListView listView = (ListView) view.findViewById(R.id.list_view);

        Intent intent = getActivity().getIntent();


        String s = intent.getStringExtra("language");

        List<String> dataList = new ArrayList<>();
        dataList.add(s);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, dataList);

        listView.setAdapter(adapter);

        return view;
    }
}