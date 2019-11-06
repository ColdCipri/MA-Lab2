package com.example.ma_lab2

class Repository (){
    lateinit var medsList : ArrayList<Meds>

    fun addMed(m : Meds){
        medsList.add(m)
    }

    fun removeMedAtPos(i : Int) : Boolean {
        if (i < medsList.size){
            medsList.removeAt(i)
            return true
        }
        return false
    }

    fun removeMed(m : Meds) : Boolean {
        return (medsList.remove(m))
    }

    fun getMeds(): ArrayList<Meds> {
        return medsList
    }


}