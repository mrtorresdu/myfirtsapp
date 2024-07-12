package com.mrtorresdu.myfirstapplication.firstapp.menu.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroesResponse(
    val response: String,
    val results: List<SuperHero>,
    @SerializedName("results-for") val resultsFor: String
)