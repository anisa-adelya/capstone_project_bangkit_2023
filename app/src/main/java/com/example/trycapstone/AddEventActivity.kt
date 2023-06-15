package com.example.trycapstone

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trycapstone.dao.EventDao
import java.text.SimpleDateFormat
import com.example.trycapstone.databinding.ActivityAddEventBinding
import com.example.trycapstone.model.Event
import java.util.*

class AddEventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddEventBinding
    private val calendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.toolbar)

//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        binding.toolbar.setNavigationOnClickListener {
//            onBackPressed()
//        }

        binding.btnBack.setOnClickListener { onBackPressed() }
//
        binding.etEventDate.setOnClickListener { showDatePickerDialog() }
//
        binding.btnSubmitEvent.setOnClickListener {
            // Retrieve the entered event details
            val eventName = binding.etEventName.text.toString()
            val eventDate = binding.etEventDate.text.toString()
            val eventPlace = binding.etEventPlace.text.toString()
            val eventDescription = binding.etEventDescription.text.toString()

            // Create an Event object with the entered details
            val newEvent = Event(eventName, eventDate, eventPlace, eventDescription)

            // Save the new event using the DAO database
            val eventDao = EventDao() // Replace with your actual DAO implementation
            eventDao.saveEvent(newEvent)

            // Display a toast or perform any other action to indicate successful event creation
            Toast.makeText(this, "Event created successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _: DatePicker, year: Int, month: Int, dayOfMonth ->

                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)

                val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)

                binding.etEventDate.setText(formattedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }
}
