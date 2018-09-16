package com.example.leona.keyboardsamples

import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    private var spínnerLabel=""
    val label_spinner=findViewById<Spinner>(R.id.label_spinner)
    val editText_main=findViewById<EditText>(R.id.editText_main)

    override fun onNothingSelected(parent: AdapterView<*>) {
        Log.d(TAG,getString(R.string.nothing_entered))

    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        spínnerLabel= parent.getItemAtPosition(position).toString()
        showText(view)

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (label_spinner != null)
        {
            label_spinner.onItemSelectedListener=this
        }

        val adapter=ArrayAdapter.createFromResource(this,R.array.labels_array,android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        if (label_spinner != null)
        {
            label_spinner.adapter=adapter
        }
    }

    fun showText(v: View)
    {
        if (editText_main != null)
        {
           val showString=editText_main.text.toString()+"-"+spínnerLabel

            if (text_phonelabel != null)text_phonelabel.text=showString
        }
    }

    companion object {
        private var TAG=MainActivity::class.java.simpleName
    }

}
