package com.example.recipeteam.recipe

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CookService {
    @GET("/cooklist")
    fun getCookList(): Call<CookList>

    @POST("/cookinsert")
    fun insertCookInfo(
        @Body cook: Cook
    ):Call<Cook>

    fun getCook(
        @Query("cname") cname: String
    ):Call<String>
    }