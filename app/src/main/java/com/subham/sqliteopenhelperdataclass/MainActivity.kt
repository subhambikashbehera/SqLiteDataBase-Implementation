package com.subham.sqliteopenhelperdataclass

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var recyclerView: RecyclerView
    var adapterx:adapter?=null
    var booktitle= arrayListOf<String>()
    var bookid= arrayListOf<Int>()
    var bookauthor= arrayListOf<String>()
    var noofpagesss= arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        floatingActionButton=findViewById(R.id.floatingActionButton)
        recyclerView=findViewById(R.id.recyclerView)

        floatingActionButton.setOnClickListener {
            val intent=Intent(this,AddData::class.java)
            startActivity(intent)
        }
       adapterx = adapter(this,booktitle,bookid,bookauthor,noofpagesss,this@MainActivity)
        recyclerView.adapter=adapterx


        val layout=LinearLayoutManager(this)
        recyclerView.layoutManager=layout
        setdatainsidearraylist()

    }


//    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
//        super.startActivityForResult(intent, requestCode)
//
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode==102)
        {
            recreate()
            adapterx?.notifyDataSetChanged()
        }

    }

    private fun setdatainsidearraylist() {

        val subham=SQlitehelperdatabase(this)
        val cursor:Cursor?=subham.viewdata()


        if (cursor!!.count== 0)
        {
            Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show()
        }else
        {
            while (cursor.moveToNext())

            {        bookid.add(cursor.getInt(0))
                      booktitle.add(cursor.getString(1))
                     bookauthor.add(cursor.getString(2))
                     noofpagesss.add(cursor.getString(3))
                    adapterx?.notifyDataSetChanged()
            }


            Log.d("noofpages", "setdatainsidearraylist: $noofpagesss")

        }



    }



}