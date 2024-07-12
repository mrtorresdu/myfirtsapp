package com.mrtorresdu.myfirstapplication.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.mrtorresdu.myfirstapplication.R
import com.mrtorresdu.myfirstapplication.firstapp.menu.AppActivity
import com.mrtorresdu.myfirstapplication.firstapp.menu.imccalculator.ImcCalculatorActivity
import com.mrtorresdu.myfirstapplication.firstapp.menu.superheroapp.SuperHeroListActivity
import com.mrtorresdu.myfirstapplication.firstapp.menu.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludApp = findViewById<AppCompatButton>(R.id.bnSaludApp)
        val btnIMCApp = findViewById<AppCompatButton>(R.id.bntIMCApp)
        val btnTodo = findViewById<AppCompatButton>(R.id.btnTodo)
        val btnSuperHeroList = findViewById<AppCompatButton>(R.id.btnSuperHeroList)

        btnSaludApp.setOnClickListener { navigateToSaludApp()}
        btnIMCApp.setOnClickListener{ nagivateToImcApp()}
        btnTodo.setOnClickListener { navigateToTodoApp() }
        btnSuperHeroList.setOnClickListener { navigateToSuperHeroList()}
    }

    private fun navigateToSuperHeroList() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTodoApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun nagivateToImcApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp(){
        val intent = Intent(this, AppActivity::class.java)
        startActivity(intent)
    }


}