package com.mrtorresdu.myfirstapplication.firstapp.menu.superheroapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrtorresdu.myfirstapplication.databinding.ActivitySuperHeroListBinding
import com.mrtorresdu.myfirstapplication.firstapp.menu.superheroapp.DetailSuperheroActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var adapter: SuperHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        adapter = SuperHeroAdapter { navigateDetail(it) }
        binding.rvSuperHero.setHasFixedSize(true)
        binding.rvSuperHero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperHero.adapter = adapter

    }

    private fun searchName(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitInstance.api.getSuperHeroesList(query)
            if (response.isSuccessful) {
                val superHeroes: List<SuperHero>? = response.body()?.results
                if (superHeroes != null) {
                    Log.i("MRTD", superHeroes.toString())
                    runOnUiThread {
                        adapter.updateList(superHeroes)
                        binding.progressBar.isVisible = false
                    }
                } else {
                    Log.i("MRTD", "No SuperHero $query no encontrado")
                    runOnUiThread {
                        binding.progressBar.isVisible = false
                    }
                }
            } else {
                println("Error: ${response.code()}")
            }
        }
    }

    private fun navigateDetail(id: String) {
        val intent = Intent(this, DetailSuperheroActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }

}