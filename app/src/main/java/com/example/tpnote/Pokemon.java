package com.example.tpnote;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Represents a Pokémon with its attributes and behaviors.
 */
public class Pokemon {
    public static String language;
    private int id;
    private Map<String, String> name; //depends on settings language
    private final List<Types> type = new ArrayList<>();
    private Map<String, Integer> baseStats;  //json name is "base"
    private String pictureURL;

    //TODO: Add constructor and setters

    /**
     * Calculates the rank of the Pokémon based on its stats.
     *
     * @return the rank value
     */
    public Integer getRank() {
        return 4 * baseStats.get("Speed") + 3 * baseStats.get("Attack") + 2 * baseStats.get("Defense") + baseStats.get("HP");
    }

    /**
     * Returns the name of the Pokémon in the current language.
     *
     * @return the name
     */
    public String getName() {
        return name.get(language);
    }

    @Override
    public String toString() {
        return "Pokemon{ id=" + id + ", name=" + getName() + ", type=" + type + ", baseStats=" + baseStats + '}';
    }

    /**
     * Changes the speed of all NORMAL Type Pokémon by a certain amount.
     *
     * @param boost the amount to boost the speed by
     */
    public static void boost(int boost) {
        for (Pokemon pokemon : completeList) {
            if (pokemon.type.contains(Types.NORMAL)) {
                pokemon.baseStats.put("Speed", pokemon.baseStats.get("Speed") + boost);
            }
        }
    }

    // Static list of all Pokemon objects
    private static List<Pokemon> completeList = new ArrayList<>();

    /**
     * Sets the complete list of all Pokemon objects.
     *
     * @param pokemonList the list of Pokemon objects
     */
    public static void setCompleteList(List<Pokemon> pokemonList) {
        completeList = pokemonList;
    }
}

enum Types {
    NORMAL,
    FIGHTING,
    FLYING,
    POISON,
    GROUND,
    ROCK,
    BUG,
    GHOST,
    STEEL,
    FIRE,
    WATER,
    GRASS,
    ELECTRIC,
    PSYCHIC,
    ICE,
    DRAGON,
    DARK,
    FAIRY
}

enum Stats {
    HP,
    ATTACK,
    DEFENSE,
    SP_ATTACK,
    SP_DEFENSE,
    SPEED
}
