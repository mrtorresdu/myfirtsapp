package com.mrtorresdu.myfirstapplication.firstapp.menu.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mrtorresdu.myfirstapplication.R
import com.mrtorresdu.myfirstapplication.firstapp.menu.todoapp.TaskCategory.*

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(
        Business,
        Personal,
        Other
    )

    private val tasks = mutableListOf(
        Task("TestBusiness", Business),
        Task("TestPersonal", Personal),
        Task("TestOther", Other )
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter
    private lateinit var fabAddTask: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUi()
        initListeners()

    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        val edTask: EditText = dialog.findViewById(R.id.edTask)
        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val selectedId = rgCategories.checkedRadioButtonId
            val selectedRadioButton:RadioButton = rgCategories.findViewById(selectedId)
            val currentCategory:TaskCategory = when(selectedRadioButton.text){
                "Business" -> Business
                "Personal" -> Personal
                else -> Other
            }

            tasks.add(Task(edTask.text.toString(), currentCategory))

        }
        dialog.show()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUi() {
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }


}