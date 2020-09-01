package com.example.recyclercard.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclercard.R
import com.example.recyclercard.model.Client
import kotlinx.android.synthetic.main.row_clients.view.*

class ClientAdapter(val clients: List<Client>, val context: Context, val listener: (Client) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_clients, parent, false))
    }

    override fun getItemCount(): Int {
        return this.clients.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val client = this.clients[position]

        if(holder is ViewHolder) {
            holder.bind(client, position, context, listener)
        }
    }

    public fun notifyData() {
        this.notifyDataSetChanged()
    }

    public fun notifyInsertedItemList() {
        this.notifyItemInserted(this.clients.size)
    }

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(client: Client?, position: Int?, context: Context, listener: (Client) -> Unit) = with(itemView) {

        val rowClientsTextViewName = itemView.rowClientsTextViewName
        val rowClientsTextViewGender = itemView.rowClientsTextViewGender
        val rowClientsTextViewIncome = itemView.rowClientsTextViewIncome
        var rowClientsLayout = itemView.rowClientsLayout

        client?.let {
            rowClientsTextViewName.text = it.name
            rowClientsTextViewGender.text = it.gender
            rowClientsTextViewIncome.text = "R$ ${it.income.toString()}"

            itemView.setOnClickListener {
                Log.d("tag clicou", "tag clicou")
                listener(client)
            }

            position?.let {
                if (it % 2 == 0) {
                    rowClientsLayout.setBackgroundColor(getColor(context, R.color.pink100))
                } else {
                    rowClientsLayout.setBackgroundColor(getColor(context, R.color.cyan100))
                }
            }

        }

    }
}