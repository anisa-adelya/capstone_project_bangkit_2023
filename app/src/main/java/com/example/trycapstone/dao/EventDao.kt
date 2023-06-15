package com.example.trycapstone.dao
import com.example.trycapstone.model.Event

class EventDao {
    private val eventList = mutableListOf<Event>()

    fun getAllEvents(): List<Event> {
        return eventList
    }

    fun saveEvent(event: Event) {
        eventList.add(event)
    }
}