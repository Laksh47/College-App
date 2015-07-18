package com.example.mynotify;
import com.example.mynotify.rep;

import android.util.Log;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class dbcontrol extends SQLiteOpenHelper{
	//private static final String LOGCAT = null;
	dbcontrol(Context app){
		super(app,"rep.db",null,1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String query="CREATE TABLE reps (id INTEGER PRIMARY KEY,sname TEXT,spos TEXT,dep TEXT,phno TEXT)";
		db.execSQL(query);	
		// Log.d(LOGCAT,"reps Created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldv, int newv) {
		String query;
	    query = "DROP TABLE IF EXISTS reps";
	    db.execSQL(query);
	    onCreate(db);
	}
	
	public int insert(rep r)
	{
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("id", r.id);
		values.put("sname",r.name);
		values.put("spos",r.position);
		values.put("dep",r.dept);
		values.put("phno",r.phnum);
		int i=(int) database.insert("reps", null, values);
		database.close();
		return i;
	}
	
	public int delete(int id)
	{
		SQLiteDatabase database = this.getWritableDatabase();
		String rid=""+id;
		//String query="DELETE FROM reps where id="+id;
		int i=database.delete("reps", "id = ?", new String[]{rid});
		database.close();
		return i;
	}
	
	public int update(rep r)
	{
		SQLiteDatabase database = this.getWritableDatabase();
		 ContentValues values = new ContentValues();
		 String rid=""+r.id;
		 values.put("id", r.id);
		 values.put("sname",r.name);
		 values.put("spos",r.position);
		 values.put("dep",r.dept);
		 values.put("phno",r.phnum);
		 int i=database.update("reps", values, "id = ?", new String[] {rid});
		 database.close();
		 return i;
	}
	
	public rep getrep(int rid)
	{
		String name = null,position = null,dept = null,phnum = null;
		int id = 0;
		rep r;
		SQLiteDatabase database = this.getReadableDatabase();
	    //String selectQuery = "SELECT * FROM reps where id="+rid;
	    //Cursor c=database.rawQuery(selectQuery,null);
		Cursor c=database.query("reps",new String[]{"sname","spos","dep","phno"}, "id=?",new String[] {String.valueOf(rid)},null, null, null);
	    if (c.moveToFirst()) {
	    	name=c.getString(0);
	    	position=c.getString(1);
	    	dept=c.getString(2);
	    	phnum=c.getString(3);
	    	r=new rep(id,name,position,dept,phnum);
	    }
	    else
	    	r=null;
		return r;
	}
}
