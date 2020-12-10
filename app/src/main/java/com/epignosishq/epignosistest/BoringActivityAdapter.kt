package com.epignosishq.epignosistest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.epignosis.epignosistest.R
import com.epignosishq.epignosistest.model.BoringActivity
import kotlinx.android.synthetic.main.boring_activity_item.view.*

class BoringActivityAdapter() : RecyclerView.Adapter<BoringActivityAdapter.ActivityViewHolder>() {
    private var activities: MutableList<BoringActivity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        return ActivityViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.boring_activity_item, parent, false)
        )
    }

    override fun getItemCount() = activities.size

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
            holder.bind(activities[position])
    }

    fun setList(activities: MutableList<BoringActivity>) {
        this.activities = activities
        notifyDataSetChanged()
    }

    fun addActivity(activity: BoringActivity) {
        activities.add(activity)
        notifyItemInserted(activities.size - 1)
    }


    inner class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(activity: BoringActivity) {
            itemView.activity_name.text = activity.activity
        }
    }
}