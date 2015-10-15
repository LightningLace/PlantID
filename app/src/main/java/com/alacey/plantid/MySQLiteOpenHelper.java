package com.alacey.plantid;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Ariah on 10/6/2015.
 * Based on template and tutorial found at HMKCode.com
 */


public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "PlantDatabase";

    // Constructor
    public MySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create Plant table
        String CREATE_PLANT_TABLE = "CREATE TABLE plants ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "commonName TEXT, "+ "sciName TEXT, "+
                "family TEXT, "+ "symmetry TEXT, "+
                "numParts TEXT, "+ "leafShape TEXT, "+
                "leafPattern TEXT, "+ "color TEXT, "+
                "season TEXT, "+ "region TEXT )";

        // create table
        db.execSQL(CREATE_PLANT_TABLE);
    }

    @Override
    //Note: This "upgrade" simplay deletes and rewrites the table
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if previously existed
        db.execSQL("DROP TABLE IF EXISTS plants");

        // create fresh table
        this.onCreate(db);
    }

    // Plants Table name
    private static final String TABLE_PLANTS = "plants";

    // Plants Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_COMMONNAME = "commonName";
    private static final String KEY_SCINAME = "sciName";
    private static final String KEY_FAMILY = "family";
    private static final String KEY_SYMMETRY = "symmetry";
    private static final String KEY_NUMPARTS = "numParts";
    private static final String KEY_LEAFSHAPE = "leafShape";
    private static final String KEY_LEAFPATTERN = "leafPattern";
    private static final String KEY_COLOR = "color";
    private static final String KEY_SEASON = "season";
    private static final String KEY_REGION = "region";


    private static final String[] COLUMNS = {KEY_ID,KEY_COMMONNAME,KEY_SCINAME,
            KEY_FAMILY, KEY_SYMMETRY, KEY_NUMPARTS, KEY_LEAFSHAPE, KEY_LEAFPATTERN,
            KEY_COLOR, KEY_SEASON, KEY_REGION};


    /*
     *     ~~~METHODS~~~
     */

    public void addPlant(Plant plant){
        //for logging
        Log.d("addPlant", plant.toString());

        // get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();

        values.put(KEY_COMMONNAME, plant.getCommonName());
        values.put(KEY_SCINAME, plant.getSciName());
        values.put(KEY_FAMILY, plant.getFamily());
        values.put(KEY_SYMMETRY, plant.getSymmetry());
        values.put(KEY_NUMPARTS, plant.getNumParts());
        values.put(KEY_LEAFSHAPE, plant.getLeafShape());
        values.put(KEY_LEAFPATTERN, plant.getLeafPattern());
        values.put(KEY_COLOR, plant.getColor());
        values.put(KEY_SEASON, plant.getSeason());
        values.put(KEY_REGION, plant.getRegion());

        // insert plant
        db.insert(TABLE_PLANTS, null, values); // key/value -> keys = column names/ values = column values

        db.close();
    }

    public Plant getPlant(int id){

        // get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // build query
        Cursor cursor =
                db.query(TABLE_PLANTS, COLUMNS, // column names
                        " id = ?", // selections
                        new String[] { String.valueOf(id) }, // selections args
                        null, // group by
                        null, // having
                        null, // order by
                        null); // limit

        // if query got results, get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // build plant object
        Plant plant = new Plant();

        plant.setId(Integer.parseInt(cursor.getString(0)));
        plant.setCommonName(cursor.getString(1));
        plant.setSciName(cursor.getString(2));
        plant.setFamily(cursor.getString(3));
        plant.setSymmetry(cursor.getString(4));
        plant.setNumParts(Integer.parseInt(cursor.getString(5)));
        plant.setLeafShape(cursor.getString(6));
        plant.setLeafPattern(cursor.getString(7));
        plant.setColor(cursor.getString(8));
        plant.setSeason(cursor.getString(9));
        plant.setRegion(Integer.parseInt(cursor.getString(10)));

        // log
        Log.d("getBook(" + id + ")", plant.toString());

        // return plant
        return plant;
    }

    public ArrayList<Plant> getAllPlants() {
        ArrayList<Plant> plants = new ArrayList<Plant>();

        // build the query
        String query = "SELECT  * FROM " + TABLE_PLANTS;

        // get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // go over each row, build Plant and add it to list
        Plant plant = null;
        if (cursor.moveToFirst()) {
            do {
                plant = new Plant();

                plant.setId(Integer.parseInt(cursor.getString(0)));
                plant.setCommonName(cursor.getString(1));
                plant.setSciName(cursor.getString(2));
                plant.setFamily(cursor.getString(3));
                plant.setSymmetry(cursor.getString(4));
                plant.setNumParts(Integer.parseInt(cursor.getString(5)));
                plant.setLeafShape(cursor.getString(6));
                plant.setLeafPattern(cursor.getString(7));
                plant.setColor(cursor.getString(8));
                plant.setSeason(cursor.getString(9));
                plant.setRegion(Integer.parseInt(cursor.getString(10)));

                // Add Plant to plants
                plants.add(plant);
            } while (cursor.moveToNext());
        }

        Log.d("getAllPlants()", plants.toString());

        // return ArrayList
        return plants;
    }

    //Updates a single Plant in the database
    public int updatePlant(Plant plant) {

        // get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();

        values.put("commonName", plant.getCommonName());
        values.put("sciName", plant.getSciName());
        values.put("family", plant.getFamily());
        values.put("symmetry", plant.getSymmetry());
        values.put("numParts", plant.getNumParts());
        values.put("leafShape", plant.getLeafShape());
        values.put("leafPattern", plant.getLeafPattern());
        values.put("color", plant.getColor());
        values.put("season", plant.getSeason());
        values.put("region", plant.getRegion());

        // updating row
        int i = db.update(TABLE_PLANTS,     //table
                values,                     // column/value
                KEY_ID+" = ?",              // selections
                new String[] { String.valueOf(plant.getId()) }); //selection args

        db.close();

        return i;

    }

    //Removes a Plant from the database
    public void removePlant(Plant plant) {

        // get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // delete Plant
        db.delete(TABLE_PLANTS, //table name
                KEY_ID+" = ?",  // selections
                new String[] { String.valueOf(plant.getId()) }); //selections args

        db.close();

        //log
        Log.d("removePlant", plant.toString());

    }
}
