package com.mrtorresdu.myfirstapplication.firstapp.menu.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SuperHeroApiService {
    @GET("search/{name}")
    suspend fun getSuperHeroesList(
        @Path("name") movieId: String,
    ): Response<SuperHeroesResponse>
}