package com.example.tpnote;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PodiumPokemonFragment extends Fragment {
    private final String TAG = "Simon&Damien "+getClass().getSimpleName();

    public PodiumPokemonFragment() {
        Log.d(TAG, "FragmentA created");
    }


    @Override
    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.podium_pokemon_fragment, container, false);
        TextView text = view.findViewById(R.id.txtFragmentA);
        text.setText("Android system has instancied this fragment");
        return view; }
}
