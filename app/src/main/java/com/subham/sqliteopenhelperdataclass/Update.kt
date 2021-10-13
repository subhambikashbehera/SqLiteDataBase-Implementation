package com.subham.sqliteopenhelperdataclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Update : AppCompatActivity() {

    private lateinit var update: Button
    private lateinit var delete: Button

    private lateinit var bookname: EditText
    private lateinit var authorname: EditText
    private lateinit var nopages: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)


        update=findViewById(R.id.update)
        bookname=findViewById(R.id.bookname123)
        authorname=findViewById(R.id.authorname123)
        nopages=findViewById(R.id.noofpages123)
        delete=findViewById(R.id.delete)

        val id=intent.getIntExtra("id",1)
        val bookname123=intent.getStringExtra("bookname")
        val bookauthor123=intent.getStringExtra("bookauthor")
        val noofpages123=intent.getStringExtra("noofpages")


        bookname.setText(bookname123)
        authorname.setText(bookauthor123)
        nopages.setText(noofpages123)


        update.setOnClickListener {
            val db=SQlitehelperdatabase(this)
            db.updatedata(id,bookname.text.toString(),authorname.text.toString(),nopages.text.toString())

        }
        delete.setOnClickListener {
            val db=SQlitehelperdatabase(this)
            db.deletedata(id)
        }


    }



}