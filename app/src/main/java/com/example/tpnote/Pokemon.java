package edu.frallo.myapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *  get Pokemons from json data: https://raw.githubusercontent.com/fanzeyi/pokemon.json/17d33dc111ffcc12b016d6485152aa3b1939c214/pokedex.json
 *
 *  --> let's use jackson libbrairy!
 *          - no constructor in this Pokemon class because 'jackson' librairy is used to parse json -> Pokemon
 *          - tuto to use jackson lib: <a href="https://stackoverflow.com/questions/60750796/how-to-convert-this-json-to-object-in-java-android">...</a>
 *          - add in Gradle
 *              implementation 'com.squareup.retrofit2:converter-jackson:2.7.2'
 *              implementation 'com.fasterxml.jackson.core:jackson-databind:2.10.3'
 *              implementation 'com.fasterxml.jackson.core:jackson-core:2.10.3'
 *              implementation 'com.fasterxml.jackson.core:jackson-annotations:2.10.3'
 *
 *  there is no picture in data json but there are some at
 *          - sprites : <a href="https://github.com/fanzeyi/pokemon.json/tree/master/sprites">...</a>
 *          - images : <a href="https://github.com/fanzeyi/pokemon.json/tree/master/images">...</a>
 *   --> let's use Picaso libbrairy to inflate pictures
 *          add in Gradle implementation 'com.squareup.picasso:picasso:2.71828'
 *
 * @author Frédéric RALLO - March 2023
 */
public class Pokemon {
    private final String TAG = "frallo "+getClass().getSimpleName();

    private int id;
    private Map<String, String> name; //depends of settings language
    private final List<Types> type = new ArrayList<>();
    private Map<String, Integer> features;  //json name is base
    private String pictureURL;
    
    
    //TODO some methods
    
    public String getName() { 
    //to be changed
    	return null;
    }  
   
    @Override
    public String toString() {
        return "Pokemon{ id=" + id + ", name=" + getName() + ", type=" + type + ", features=" + features + '}';
    }
}



enum Features {
    HP(0),
    ATTACK(0),
    DEFENSE(0),
    SP_ATTACK(0),
    SP_DEFENSE(0),
    SPEED(0);
    private int value;


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    Features(int value) {
        this.value=value;
    }
}

enum Types{
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

