package com.mrtorresdu.myfirstapplication.firstapp.menu.todoapp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mrtorresdu.myfirstapplication.R

class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val tvCategoriesName:TextView = view.findViewById(R.id.tvCategoriesName)
    private val divider:View = view.findViewById(R.id.divider)

    fun render(taskCategory: TaskCategory){




        when(taskCategory){
            TaskCategory.Business -> {
                tvCategoriesName.text = "Business"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_business_category)
                )
            }
            TaskCategory.Other -> {
                tvCategoriesName.text = "Other"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_other_category)
                )

            }
            TaskCategory.Personal -> {
                tvCategoriesName.text = "Personal"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_personal_category)
                )
            }
        }

    }
}