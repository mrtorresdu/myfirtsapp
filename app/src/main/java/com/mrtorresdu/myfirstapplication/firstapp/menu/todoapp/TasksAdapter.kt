package com.mrtorresdu.myfirstapplication.firstapp.menu.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrtorresdu.myfirstapplication.R

class TasksAdapter(private val tasks:List<Task>):RecyclerView.Adapter<TasksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo_tasks, parent, false)
        return TasksViewHolder(view)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.render(tasks[position])
    }

    override fun getItemCount() = tasks.size

}