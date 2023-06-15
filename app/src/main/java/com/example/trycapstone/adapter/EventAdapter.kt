package com.example.trycapstone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trycapstone.R
import com.example.trycapstone.model.Event

class EventAdapter(private val eventList: List<Event>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val eventNameTextView: TextView = itemView.findViewById(R.id.text_event_name)
        private val eventDateTextView: TextView = itemView.findViewById(R.id.text_event_date)
        private val eventPlaceTextView: TextView = itemView.findViewById(R.id.text_event_place)

        fun bind(event: Event) {
            eventNameTextView.text = event.name
            eventDateTextView.text = "Date: ${event.date}"
            eventPlaceTextView.text = "Place: ${event.place}"
        }
    }
}
