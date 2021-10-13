package com.subham.sqliteopenhelperdataclass

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import android.widget.Toast
import com.google.android.material.internal.NavigationMenu
import java.net.IDN

class SQlitehelperdatabase(context: Context?) :
    SQLiteOpenHelper(context, DATABASENAME, null, VERSION) {

    companion object
    {
        val DATABASENAME:String="student"
        val TABLENAME:String="studentbio"
        val VERSION:Int=1
        val ID="id"
        val BOOKNAME="bookname"
        val AUTHORNAME="authorname"
        val NOOFPAGES="noofpages"

    }
        val contexttt=context


    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE $TABLENAME ($ID INTEGER PRIMARY KEY AUTOINCREMENT,$BOOKNAME TEXT,$AUTHORNAME TEXT, $NOOFPAGES TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLENAME")
        onCreate(db)
    }

    fun add(model: model):Boolean
    {
        val db=this.writableDatabase
        val contentValues=ContentValues()
        contentValues.put(BOOKNAME,model.bookname)
        contentValues.put(AUTHORNAME,model.bookauthor)
        contentValues.put(NOOFPAGES,model.totalpages)
       db.insert(TABLENAME,null,contentValues)
        db.close()
       return true
    }

    fun viewdata():Cursor?{

        val db=this.readableDatabase
        var cursor:Cursor?=null
        val query:String= "SELECT * FROM $TABLENAME"
        if (db !=null)
        {
            cursor=db.rawQuery(query,null)
        }

        return cursor
    }

    fun updatedata(id:Int,bookname:String,bookauthor:String,noofpages:String)
    {

        val db=this.writableDatabase
        val cv=ContentValues()
        cv.put(BOOKNAME,bookname)
        cv.put(AUTHORNAME,bookauthor)
        cv.put(NOOFPAGES,noofpages)

        val sucess=db.update(TABLENAME, cv, "id=?", arrayOf(id.toString())).toString()
        db.close()
        if (Integer.parseInt(sucess) == 1)
        {
            Toast.makeText(contexttt,"updated",Toast.LENGTH_SHORT).show()

        }else
        {
            Toast.makeText(contexttt,"failed",Toast.LENGTH_SHORT).show()
        }

    }


    fun deletedata(id: Int)
    {
        val db=this.writableDatabase

        val sucess=db.delete(TABLENAME, "id=?", arrayOf(id.toString())).toString()
        db.close()
        if (Integer.parseInt(sucess) == 1)
        {
            Toast.makeText(contexttt,"Deleted",Toast.LENGTH_SHORT).show()

        }else
        {
            Toast.makeText(contexttt,"failed",Toast.LENGTH_SHORT).show()
        }


    }


}