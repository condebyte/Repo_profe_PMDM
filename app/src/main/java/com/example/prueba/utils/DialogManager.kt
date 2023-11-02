package com.example.prueba.utils

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import com.example.prueba.R
import java.util.Calendar

object DialogManager {
    fun showDialog(context: Context){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("hola mundo")
        builder.setMessage("mesa")
        builder.setPositiveButton(android.R.string.ok){_,_ ->
            Toast.makeText(context, "click positivo", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton(android.R.string.no){_,_ ->
            Toast.makeText(context, "click negativo", Toast.LENGTH_SHORT).show()
        }
        builder.setNeutralButton("NEUTRO"){_,_ ->
            Toast.makeText(context, "-l-", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }

    fun showDialosList(context: Context, resources:Resources){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("LISTADOS")

        val names = resources.getStringArray(R.array.items_names)

        builder.setItems(names){_,_ ->
            Toast.makeText(context,"listado",Toast.LENGTH_LONG).show()
        }

        builder.show()
    }

    fun showDialosChoisList(context: Context, resources:Resources){

        val builder = AlertDialog.Builder(context)
        builder.setTitle("LISTADOS")

        val names = resources.getStringArray(R.array.items_names)

        builder.setSingleChoiceItems(names, -1){_,_ ->
            Toast.makeText(context,"listado",Toast.LENGTH_LONG).show()
        }

        builder.show()
    }
    fun showmultipleDialosChoisList(context: Context, resources:Resources){

        val builder = AlertDialog.Builder(context)
        builder.setTitle("LISTADOS")

        val names = resources.getStringArray(R.array.items_names)

        builder.setMultiChoiceItems(names, null){_,_,_ ->
            Toast.makeText(context,"listado",Toast.LENGTH_LONG).show()
        }
        builder.setPositiveButton(android.R.string.ok){_,_ ->
            Toast.makeText(context, "click positivo", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton(android.R.string.no){_,_ ->
            Toast.makeText(context, "click negativo", Toast.LENGTH_SHORT).show()
        }

        builder.show()
    }

    fun showTimeDialog(context: Context){
        val cal = Calendar.getInstance()
        var dialogTime = TimePickerDialog(
            context,
            null,
            cal.get(Calendar.HOUR_OF_DAY),
            cal.get(Calendar.MINUTE),
            true)
        dialogTime.show()
    }

    fun showDayDialog(context: Context, listener:DatePickerDialog.OnDateSetListener){
        val cal = Calendar.getInstance()
        var dialogTime = DatePickerDialog(
            context,
            listener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_WEEK)
            )
        dialogTime.show()
    }
}