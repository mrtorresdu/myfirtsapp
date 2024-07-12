package com.mrtorresdu.myfirstapplication.firstapp.menu.superheroapp

data class SuperHero(
    val appearance: Appearance,
    val biography: Biography,
    val connections: Connections,
    val id: String,
    val image: Image,
    val name: String,
    val powerstats: Powerstats,
    val work: Work
)