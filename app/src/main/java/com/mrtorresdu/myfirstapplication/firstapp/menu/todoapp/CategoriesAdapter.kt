package com.mrtorresdu.myfirstapplication.firstapp.menu.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrtorresdu.myfirstapplication.R

class CategoriesAdapter(private val categories: List<TaskCategory>) :
    RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task_categories, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun getItemCount() = categories.size


    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position])
    }
}