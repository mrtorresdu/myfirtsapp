package com.mrtorresdu.myfirstapplication.firstapp.menu.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.annotations.SerializedName
import com.mrtorresdu.myfirstapplication.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroesHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superheroItemResponse: SuperHero, onItemSelected:(String) -> Unit) {
        binding.tvSuperheroName.text = superheroItemResponse.name
        Picasso.get().load(superheroItemResponse.image.url).into(binding.ivSuperhero)
        binding.root.setOnClickListener{ onItemSelected(superheroItemResponse.id) }
    }
}
