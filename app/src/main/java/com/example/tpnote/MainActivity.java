package com.example.tpnote;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements edu.frallo.myapplication.PostExecuteActivity<Pokemon> {
    public static String language = "english";
    List<Pokemon> itemList = new ArrayList<>();
    private final String TAG = "frallo "+getClass().getSimpleName();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner languageSpinner = findViewById(R.id.language_spinner);
        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item
                String selectedLanguage = (String) parent.getItemAtPosition(position);

                // Do something with the selected language
                // For example, you could store it in a variable
                language = selectedLanguage;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
        findViewById(R.id.go).setOnClickListener( clic -> {
            String url = "https://raw.githubusercontent.com/fanzeyi/pokemon.json/17d33dc111ffcc12b016d6485152aa3b1939c214/pokedex.json";
            new HttpAsyncGet<>(url, Pokemon.class, this, new ProgressDialog(clic.getContext()) );
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("pokemonList", (Serializable) itemList);
            intent.putExtra("language", language);
            startActivity(intent);
        });
    }


    @Override
    public void onPostExecutePokemons(List<Pokemon> itemList) {
        this.itemList = itemList;
        Pokemon pokemonFirst = itemList.get(0);
        Log.d(TAG,"First pokemon = " + pokemonFirst.toString());
        Log.d(TAG, language);
    }
}