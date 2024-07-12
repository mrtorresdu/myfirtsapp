package com.mrtorresdu.myfirstapplication.firstapp.menu.superheroapp

import com.google.gson.annotations.SerializedName

data class Biography(
    val aliases: List<String>,
    val alignment: String,
    @SerializedName("alter-egos") val alterEgos: String,
    @SerializedName("first-appearance") val firstAppearance: String,
    @SerializedName("full-name") val fullName: String,
    @SerializedName("place-of-birth") val placeOfBirth: String,
    @SerializedName("") val publisher: String
)