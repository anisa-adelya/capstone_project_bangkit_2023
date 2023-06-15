package com.example.trycapstone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trycapstone.adapter.EventAdapter
import com.example.trycapstone.databinding.ActivityHomeBinding
import com.example.trycapstone.model.Event

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var eventAdapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView
        binding.recyclerViewEvents.layoutManager = LinearLayoutManager(this)

        // Create a sample list of events
        val eventList = createEventList()

        // Create and set the adapter
        eventAdapter = EventAdapter(eventList)
        binding.recyclerViewEvents.adapter = eventAdapter

        // Handle click event of the btnAddEvent button
        binding.btnAddEvent.setOnClickListener{
            startActivity(Intent(this, AddEventActivity::class.java))
        }
    }

    // Create a sample list of events
    private fun createEventList(): List<Event> {
        val eventList = mutableListOf<Event>()
        eventList.add(Event("Event 1", "2023-06-15", "Location 1", "konser"))
        eventList.add(Event("Event 2", "2023-06-16", "Location 2", "budaya"))
        eventList.add(Event("Event 3", "2023-06-17", "Location 3", "pameran"))
        // Add more events to the list as needed
        return eventList
    }
}
