package first.example.takaotakao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class SQLBaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="Order";
    private static final int DB_VER=1;
    private static final String DB_TABLE="Items";
    private static final String DB_COLUMN="Names";
    private static final String DB_COLUMN2="Price";
    public SQLBaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query=String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT)",DB_TABLE,DB_COLUMN,DB_COLUMN2);
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion>oldVersion) {
            String query = String.format("DELETE TABLE IF EXISTS %s)", DB_TABLE);
            db.execSQL(query);
            onCreate(db);
        }
    }
    public void insertData(String task,String price){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(DB_COLUMN,task);
        values.put(DB_COLUMN2,price);
        db.insertWithOnConflict(DB_TABLE,null,values,SQLiteDatabase.CONFLICT_REPLACE);
    }
    public void insertPrice(String price){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(DB_COLUMN2,price);
        db.insert(DB_TABLE,null,values);
    }
    public void deleteData(String task){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(DB_TABLE,DB_COLUMN + "= ?",new String[]{task});
        db.close();
    }

    public ArrayList<String> getAllTasks(){
        ArrayList<String> allTasks=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(DB_TABLE,new String[]{DB_COLUMN},null,null,null,null,null);
        while (cursor.moveToNext()){
            int index=cursor.getColumnIndex(DB_COLUMN);
            allTasks.add(cursor.getString(index));
        }
        cursor.close();
        db.close();
        return allTasks;
    }
    public ArrayList<String> getAllPrice(){
        ArrayList<String> allPrice=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(DB_TABLE,new String[]{DB_COLUMN2},null,null,null,null,null);
        while (cursor.moveToNext()){
            int index=cursor.getColumnIndex(DB_COLUMN2);
            allPrice.add(cursor.getString(index));
        }
        cursor.close();
        db.close();
        return allPrice;
    }

}