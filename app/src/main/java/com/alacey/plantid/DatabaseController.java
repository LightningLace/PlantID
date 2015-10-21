package com.alacey.plantid;

import android.os.Bundle;
import android.app.Activity;

public class DatabaseController extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_controller);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        MySQLiteOpenHelper db = new MySQLiteOpenHelper(this);
        /*
        TODO: Allow internet access in manifest
         */

        /*
         *  ~~~FOR TESTING DATABASE~~~
         */

        //add Plants
        Plant firstPlant = new Plant(0, "Sweet White Waterlily", "Nymphaea odorata", "Nymphaeaceae", "Regular", 7, "Round lobed", "Alternate", "White", "Mar to Oct", 1);
        db.addPlant(firstPlant);

        //get all Plants
        db.getAllPlants();

        //delete first Plant
        db.removePlant(firstPlant);

        //get all Plants again
        db.getAllPlants();
    }

}
