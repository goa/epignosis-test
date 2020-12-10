package com.epignosishq.epignosistest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.epignosis.epignosistest.R
import com.epignosishq.epignosistest.model.BoringActivity

class BoringActivityAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var activities: List<BoringActivity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item, parent, false)
    }

    override fun getItemCount() = activities.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    fun setList(activities: List<BoringActivity>) {
        this.activities = activities
        notifyDataSetChanged()
    }

    fun addActivity(activity: BoringActivity) {
        activities.plus(activity)
        notifyItemInserted(activities.size - 1)
    }
}