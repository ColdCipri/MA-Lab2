package com.example.ma_lab2

import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog.view.*

class MainActivity : AppCompatActivity() {
    //val repo = Repository ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.items_recycledview)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val meds = ArrayList<Meds> ()//repo.getMeds()

        meds.add(Meds("Aspenter", "29-10-2019", 10, "aspenticilina", "11mg", "Pentru dureri de cap"))
        meds.add(Meds("Coldrex max grip leomn", "01-01-2020", 20, "coldrexilina", "12mg", "Pentru raceala"))
        meds.add(Meds("Algocalmin", "02-02-2020", 5, "algocalmina", "5mg","Dureri de cap"))
        meds.add(Meds("Paracetamol", "03-03-2020", 8, "paracetatica", "13mg","Raceala si gripa"))
        meds.add(Meds("Nurofen", "04-05-2020", 20, "actetilina", "4mg","Dureri de cap"))
        meds.add(Meds("FastumGel", "05-04-2020", 1, "gel","5mg","iritatii"))
        meds.add(Meds("Distonocalm", "12-12-2021", 7, "calmina","10mg", "Pentru agitatie"))

        val adapter = CustomAdapter(meds)

        recyclerView.adapter = adapter

        setSupportActionBar(toolbar)

        add_floatingactionbutton.setOnClickListener { view ->
            val addDialog  = LayoutInflater.from(this).inflate(R.layout.add_dialog, null)

            val builder = AlertDialog.Builder(this)
                .setView(addDialog)
                .setTitle("Add item")

            val alertDialog = builder.show()

            addDialog.button_add.setOnClickListener {
                alertDialog.dismiss()

                val name = addDialog.add_name.text.toString()
                val dataExp = addDialog.add_dataExp.text.toString()
                val bucati = addDialog.add_bucati.text.toString().toInt()
                val substBaza = addDialog.add_substBaza.text.toString()
                val cantSubstBaza = addDialog.add_quantitySubstBaza.text.toString()
                val descriere = addDialog.add_descriere.text.toString()

                meds.add(Meds(name, dataExp, bucati, substBaza, cantSubstBaza, descriere))
            }

            addDialog.button_cancel.setOnClickListener{
                alertDialog.dismiss()
            }
        }
    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }*/

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }*/
}
