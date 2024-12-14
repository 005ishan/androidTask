package com.example.mobile

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class FormActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner : Spinner
    lateinit var autoComplete : AutoCompleteTextView
    lateinit var display : TextView
    lateinit var datePicker: EditText

    val countries = arrayOf("Nepal","China","Hong kong","South Africa","Chile")

    val cities = arrayOf("Kathmandu", "Lalitpur", "Bhaktapur", "Kanchanpur", "Biratnagar")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form)
        spinner = findViewById(R.id.spinner)
        autoComplete = findViewById(R.id.autoComplete)
        display = findViewById(R.id.displaySpinner)
        datePicker = findViewById(R.id.editTextDate)

        datePicker.isFocusable = false
        datePicker.isClickable = true

        datePicker.setOnClickListener{

            loadCalander()
        }

        val autoCmpleteAdapter = ArrayAdapter(
            this@FormActivity,
            android.R.layout.simple_dropdown_item_1line,
            cities
        )

        autoComplete.setAdapter(autoCmpleteAdapter)
        autoComplete.threshold=1


        val adapter = ArrayAdapter(
            this@FormActivity,
            android.R.layout.simple_spinner_item,
            countries
        )
        spinner.onItemSelectedListener=this@FormActivity
        spinner.adapter = adapter
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.editData)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadCalander() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(
            this@FormActivity,
            DatePickerDialog.OnDateSetListener
            { d, year, month, day ->
                datePicker.setText("$day/${month+1}/$year")
            },year,month,day
        )
        dialog.show()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        display.text = p0?.getItemAtPosition(p2).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}

