package com.example.ma_lab2

import android.app.AlertDialog
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.add_dialog.view.button_cancel
import kotlinx.android.synthetic.main.update_remove_dialog.*
import kotlinx.android.synthetic.main.update_remove_dialog.view.*

class CustomAdapter(val medsList: ArrayList<Meds>) : RecyclerView.Adapter<CustomAdapter.ViewHolder> () {


    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val meds: Meds = medsList[p1]

        p0.nameTextView.text = meds.name
        p0.dataexpTextView.text = meds.dataexp
        p0.piecesTextView.text = meds.pieces.toString()
        p0.baseSubstTextView.text = meds.baseSusbt
        p0.quantityBaseSubstTextView.text = meds.quantityBaseSubst
        p0.descriptionTextView.text = meds.descrption

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.list_layout, p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return medsList.size
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {

        val nameTextView = itemView.findViewById(R.id.name_textview) as TextView
        val dataexpTextView = itemView.findViewById(R.id.dataexp_textview) as TextView
        val piecesTextView = itemView.findViewById(R.id.pieces_textview) as TextView
        val baseSubstTextView = itemView.findViewById(R.id.substBaza_textview) as TextView
        val quantityBaseSubstTextView = itemView.findViewById(R.id.quantity_textview) as TextView
        val descriptionTextView = itemView.findViewById(R.id.description_textview) as TextView


        init {
            itemView.setOnClickListener {

                val updateRemoveDialog  = LayoutInflater.from(itemView.context).inflate(R.layout.update_remove_dialog, null)

                val builder = AlertDialog.Builder(itemView.context)
                    .setView(updateRemoveDialog)
                    .setTitle("Update/Remove item")

                val alertDialog = builder.show()

                alertDialog.update_name.text = Editable.Factory.getInstance().newEditable(nameTextView.text)
                alertDialog.update_dataExp.text = Editable.Factory.getInstance().newEditable(dataexpTextView.text)
                alertDialog.update_bucati.text = Editable.Factory.getInstance().newEditable(piecesTextView.text)
                alertDialog.update_substBaza.text = Editable.Factory.getInstance().newEditable(baseSubstTextView.text)
                alertDialog.update_quantitySubstBaza.text = Editable.Factory.getInstance().newEditable(quantityBaseSubstTextView.text)
                alertDialog.update_descriere.text = Editable.Factory.getInstance().newEditable(descriptionTextView.text)


                updateRemoveDialog.button_update.setOnClickListener {
                    alertDialog.dismiss()


                }

                updateRemoveDialog.button_remove.setOnClickListener{
                    alertDialog.dismiss()

                    //TO-DO remove from item
                }


                updateRemoveDialog.button_cancel.setOnClickListener{
                    alertDialog.dismiss()
                }
            }
        }
    }
}