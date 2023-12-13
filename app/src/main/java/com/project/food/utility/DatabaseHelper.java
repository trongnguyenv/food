package com.project.food.utility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.project.food.R;
import com.project.food.models.FoodFavorite;
import com.project.food.models.Hint;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "food_db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "food_favorite";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String DATA_COL = "data";

    // creating a constructor for our database handler.
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating an sqlite query and we are setting our column names along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DATA_COL + " TEXT)";

        // at last we are calling a exec sql method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public boolean addFoodFavorite(String data) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(DATA_COL, data);

        // after adding all values we are passing
        // content values to our table.
        long result = db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();

        if(result == -1) return false;
        else return true;
    }

    // we have created a new method for reading all the hints.
    public List<FoodFavorite> readFoodFavorite() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        List<FoodFavorite> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new FoodFavorite(
                        cursorCourses.getString(1),
                        cursorCourses.getInt(0)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }

    // below is the method for deleting our hint.
    public boolean removeFoodFavorite(String data) {
        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our hint name.
        long isRemoved = db.delete(TABLE_NAME, DATA_COL+"=?", new String[]{data});
        db.close();

        if(isRemoved == 1) return true;
        else return false;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
