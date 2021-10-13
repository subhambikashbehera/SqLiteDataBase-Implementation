package com.subham.sqliteopenhelperdataclass

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter : RecyclerView.Adapter<adapter.Viewholder> {

    val context:Context
    var booktitle= arrayListOf<String>()
    var bookid= arrayListOf<Int>()
    var bookauthor= arrayListOf<String>()
    var noofpagesss= arrayListOf<String>()
    val activity:Activity

    constructor(
        context: Context,
        booktitle: ArrayList<String>,
        bookid: ArrayList<Int>,
        bookauthor: ArrayList<String>,
        noofpagesss: ArrayList<String>,
        activity: Activity,
    ) : super() {
        this.context = context
        this.booktitle = booktitle
        this.bookid = bookid
        this.bookauthor = bookauthor
        this.noofpagesss = noofpagesss
        this.activity = activity
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
       val view:View=LayoutInflater.from(context).inflate(R.layout.cardlayout,parent,false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {

        holder.bookidsample.text= bookid[position].toString()
        holder.booknamesample.text= booktitle[position]
        holder.bookauthorsample.text= bookauthor[position]
        holder.noofpagessample.text= noofpagesss[position]
        holder.edit.setOnClickListener {
            val intent=Intent(context,Update::class.java)
            intent.putExtra("id",bookid.get(position))
            intent.putExtra("bookname",booktitle.get(position))
            intent.putExtra("bookauthor",bookauthor.get(position))
            intent.putExtra("noofpages",noofpagesss.get(position))
            activity.startActivityForResult(intent,102)
        }

    }

    override fun getItemCount(): Int {

        return bookid.size
    }


    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val booknamesample=itemView.findViewById<TextView>(R.id.bookname1)
        val bookauthorsample=itemView.findViewById<TextView>(R.id.bookauthor)
        val bookidsample=itemView.findViewById<TextView>(R.id.idx)
        val noofpagessample=itemView.findViewById<TextView>(R.id.pages)
        val edit=itemView.findViewById<ImageView>(R.id.edit)

    }

}