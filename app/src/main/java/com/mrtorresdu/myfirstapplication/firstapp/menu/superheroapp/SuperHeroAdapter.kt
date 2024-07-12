package com.mrtorresdu.myfirstapplication.firstapp.menu.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrtorresdu.myfirstapplication.R

class SuperHeroAdapter(
    private var superHeroes: List<SuperHero> = emptyList(),
    private val onItemSelected: (String) -> Unit
) : RecyclerView.Adapter<SuperHeroesHolder>() {

    fun updateList(superHeroes: List<SuperHero>) {
        this.superHeroes = superHeroes
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroesHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroesHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: SuperHeroesHolder, position: Int) {
        holder.bind(superHeroes[position], onItemSelected )
    }

    override fun getItemCount() = superHeroes.size

}