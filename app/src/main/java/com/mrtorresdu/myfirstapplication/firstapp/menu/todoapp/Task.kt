package com.mrtorresdu.myfirstapplication.firstapp.menu.todoapp

data class Task(val name:String, val category: TaskCategory, var isSelected:Boolean = false)

