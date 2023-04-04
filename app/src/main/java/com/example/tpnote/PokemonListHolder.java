package com.example.tpnote;

import com.example.tpnote.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonListHolder {
    private static PokemonListHolder instance;
    private List<Pokemon> pokemonList = new ArrayList<>();

    private PokemonListHolder() {}

    public static synchronized PokemonListHolder getInstance() {
        if (instance == null) {
            instance = new PokemonListHolder();
        }
        return instance;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
