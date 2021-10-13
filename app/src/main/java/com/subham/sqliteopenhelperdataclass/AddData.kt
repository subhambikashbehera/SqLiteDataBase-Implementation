package com.subham.sqliteopenhelperdataclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddData : AppCompatActivity() {

    private lateinit var add: Button
    private lateinit var bookname: EditText
    private lateinit var authorname: EditText
    private lateinit var nopages:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)

        add=findViewById(R.id.add)
        bookname=findViewById(R.id.bookname)
        authorname=findViewById(R.id.authorname)
        nopages=findViewById(R.id.noofpages)


        add.setOnClickListener {
            val book =bookname.text.toString()
            val author=authorname.text.toString()
            val pages=nopages.text.toString()

            val modelll=model(1,book,author,pages)
            val subham=SQlitehelperdatabase(this)
            val sucess:Boolean= subham.add(modelll)
            if (sucess==true)
            {
                Toast.makeText(this,"Saved", Toast.LENGTH_SHORT).show()
                bookname.text.clear()
                authorname.text.clear()
                nopages.text.clear()
            }else
            {
                Toast.makeText(this,"error while Saving", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
    }



}