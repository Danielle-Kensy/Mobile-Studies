package com.example.recyclercard.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.recyclercard.model.Client

class ClientDAO {

    var database: SQLiteDatabase? = null
    var databaseHelper: DatabaseHelper? = null

    constructor(context: Context) {
        this.databaseHelper = DatabaseHelper(context)
    }

    public fun openDatabaseWritable() {
        database = this.databaseHelper?.writableDatabase
    }

    public fun openDatabaseReadable() {
        database = this.databaseHelper?.readableDatabase
    }

    public fun closeDatabase() {
        this.databaseHelper?.close()
    }


    public fun store(client: Client): Long {

        val values = ContentValues()

        values.put(DatabaseHelper.TABLE_CLIENT_NAME, client.name)
        values.put(DatabaseHelper.TABLE_CLIENT_GENDER, client.gender)
        values.put(DatabaseHelper.TABLE_CLIENT_INCOME, client.income)

        return this.database!!.insert(
            DatabaseHelper.TABLE_CLIENT,
            null,
            values
        )

    }


    public fun delete(id: Long): Boolean { //-1 -> significa que deu erro...
        return this.database!!.delete(
            DatabaseHelper.TABLE_CLIENT,
            DatabaseHelper.TABLE_CLIENT_ID + "=?",
            arrayOf(id.toString())) != -1
    }

    public fun update(client: Client): Boolean {

        val values = ContentValues()

        values.put(DatabaseHelper.TABLE_CLIENT_NAME, client.name)
        values.put(DatabaseHelper.TABLE_CLIENT_GENDER, client.gender)
        values.put(DatabaseHelper.TABLE_CLIENT_INCOME, client.income)

        return this.database!!.update(
            DatabaseHelper.TABLE_CLIENT,
            values,
            DatabaseHelper.TABLE_CLIENT_ID + "=?",
            arrayOf(client.id.toString())) != -1

    }

    public fun fetch(): MutableList<Client> {

        //select * from client
        val listClients: MutableList<Client> = mutableListOf<Client>()

        val cursor: Cursor = this.database!!.query(
            DatabaseHelper.TABLE_CLIENT,
            DatabaseHelper.TABLE_CLIENT_COLUMNS,
            null, null, null, null, null
        )

        try {
            while(cursor.moveToNext()) {
                val client = Client(
                    cursor.getLong(cursor.getColumnIndex(DatabaseHelper.TABLE_CLIENT_ID)),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.TABLE_CLIENT_NAME)),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.TABLE_CLIENT_GENDER)),
                    cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.TABLE_CLIENT_INCOME))
                )

                listClients.add(client)

            }
        } finally {
            cursor.close()
        }
        return listClients
    }

}