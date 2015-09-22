package com.alacey.plantid;

import android.provider.BaseColumns;

import java.util.*;


/**
 * Created by Ariah on 9/15/2015.
 * From template at Android Developer Training website [developer.android.com/training/]
 */
public final class FeedReaderContract {

    // FROM ANDROID DEVELOPER SITE: To prevent someone from accidentally instantiating the contract class, give it an empty constructor.
    public FeedReaderContract() {}

    //table contents
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "Wildflower Library";
        public static final String COLUMN_COMMONNAME = "Common Name";
        public static final String COLUMN_SCINAME = "Scientific Name";
        public static final String COLUMN_FAMILY = "Family";
        public static final String COLUMN_SYMMETRY = "Symmetry";
        public static final String COLUMN_NUMPARTS= "Number of Regular Parts";
        public static final String COLUMN_LEAFSHAPE = "Leaf Shape";
        public static final String COLUMN_COLOR = "Petal Color";
        public static final String COLUMN_SEASON = "Bloom Season";
        public static final String COLUMN_REGION = "Native Regions";
    }

    public static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + FeedEntry.TABLE_NAME + " ("
        + FeedEntry._ID + " INTEGER PRIMARY KEY," + FeedEntry.COLUMN_COMMONNAME + COMMA_SEP +
        FeedEntry.COLUMN_SCINAME + COMMA_SEP + FeedEntry.COLUMN_FAMILY + COMMA_SEP +
        FeedEntry.COLUMN_SYMMETRY + COMMA_SEP + FeedEntry.COLUMN_NUMPARTS+ COMMA_SEP +
        FeedEntry.COLUMN_LEAFSHAPE + COMMA_SEP + FeedEntry.COLUMN_COLOR + COMMA_SEP +
        FeedEntry.COLUMN_SEASON + COMMA_SEP + FeedEntry.COLUMN_REGION + " )";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
}
