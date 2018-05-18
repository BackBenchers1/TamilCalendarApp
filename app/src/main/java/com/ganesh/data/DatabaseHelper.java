package com.ganesh.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by User on 20-02-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static  final String dbname="Calender.db";
    private static  final String TAG="Database Helper";
    private static  final String Col1="ID";
    private static  final String tableYear="ஹேவிளம்பி";
  //  private static  final String tablename2="year2";
    private static  final String month="Month";
    private static  final String day="Day";
    private static  final String days="Days";
    String cmd;
    private static  final String nalaneram="NalaNeram";
    private static final String marriageday="Marriageday";
    private static final String specialday="Specialday";
    public DatabaseHelper(Context context) {
        super(context,dbname,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
         String createTable="CREATE TABLE "+tableYear + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+month+" INTEGER, " + day + " INTEGER, " + days + " INTEGER, " + nalaneram+" TEXT, "+marriageday+" TEXT, "+specialday+" TEXT)";
         db.execSQL(createTable);
         String nala="09:30-10:30 04:30-05:30,07:30-08:30 04:30-05:30,10:30-11:30 01:30-02:30,09:30-10:30 07:30-08:30,10:30-11:30 07:30-08:30,09:30-10:30 04:30-05:30,10:30-11:30 -----------,09:30-10:30 04:30-05:30,10:30-11:30 04:30-05:30,06:00-07:00 03:30-04:30,06:00-07:00 04:30-05:30,07:30-08:30 04:30-05:30,09:30-10:30 03:00-04:00,10:30-11:30 -----------,09:30-10:30 04:30-05:30,10:30-11:30 04:30-05:30,06:30-07:30 03:30-04:30,06:30-07:30 04:30-05:30,07:30-08:30 04:30-05:30,09:30-10:30 04:30-05:30,10:30-11:30 -----------,09:30-10:30 03:00-04:00,07:30-08:30 03:00-04:00,06:30-07:30 03:30-04:30,06:30-07:30 04:30-05:30,07:30-08:30 04:30-05:30,09:30-10:30 04:30-05:30,10:30-11:30 -----------,09:30-10:30 04:30-05:30,07:30-08:30 04:30-05:30,06:00-07:00 03:30-04:30";
         String marri="4 8 11 17 24 25 27 29 31";
         String spl="1-தமிழ் புத்தாண்டு 3-ஈஸ்டர் 13-அமாவாசை 15-அக்ஷய திருதி 16-அக்ஷய திருதி 17-ஸ்ரீமத் சங்கர ஜெயந்தி 18-மே தினம் 21-அக்னி நட்சத்திரம் ஆரம்பம் 27-சித்ரா பௌர்ணமி";
         cmd = "INSERT INTO "+ tableYear + "("+month+","+day+","+days+","+nalaneram+","+marriageday+","+specialday+") VALUES(1,5,31,'"+nala+"','"+marri+"','"+spl+"')";
         db.execSQL(cmd);
         nala="06:15-07:15 04:45-05:45,10:45-11:45 04:45-05:45,09:15-10:15 04:45-05:45,10:45-11:45 12:15-01:15,09:15-10:15 04:45-05:45,07:45-08:45 04:45-05:45,06:15-07:15 03:15-04:15,06:15-07:15 04:45-05:45,10:45-11:45 04:45-05:45,09:15-10:15 04:45-05:45,10:45-11:45 12:15-01:15,09:15-10:15 04:45-05:45,07:45-08:45 04:45-05:45,06:15-07:15 03:15-04:15,06:15-07:15 03:45-04:45,10:45-11:45 04:45-05:45,09:15-10:15 04:45-05:45,10:45-11:45 12:15-01:15,09:15-10:15 04:45-05:45,07:45-08:45 04:45-05:45,06:15-07:15 03:15-04:15,06:15-07:15 04:45-05:45,10:45-11:45 04:45-05:45,09:15-10:15 04:45-05:45,10:45-11:45 12:15-01:15,09:15-10:15 04:45-05:45,07:45-08:45 04:45-05:45,06:15-07:15 03:15-04:15,06:15-07:15 04:45-05:45,10:45-11:45 04:45-05:45,09:15-10:15 04:45-05:45";
         marri="3 4 8 15 18 21 22 25 28 31";
         spl="14-அக்னி நட்சத்திரம் நிறைவு 11-அமாவாசை 25-பௌர்ணமி 26-பௌர்ணமி ";
         cmd = "INSERT INTO "+ tableYear + "("+month+","+day+","+days+","+nalaneram+","+marriageday+","+specialday+") VALUES(2,1,31,'"+nala+"','"+marri+"','"+spl+"')";
         db.execSQL(cmd);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public Cursor getData(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query="SELECT * FROM "+tableYear+" WHERE ID =?";
        Cursor data = db.rawQuery(query,new String[]{String.valueOf(id)});
        return data;
    }
}
