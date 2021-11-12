package com.example.recipeteam.recipe

import retrofit2.Call
import retrofit2.http.*

interface CookService {
    @GET("/cook/list")
    fun getCookList(): Call<CookList>

    @POST("/cook/insert") //@post("/uses/cook/insert")
    //@Headers("Authorization:" + 토큰값)
    fun insertCookInfo(
        @Body cook: Cook
    ):Call<Cook>

    fun getCook(
        @Query("cname") cname: String
    ):Call<String>
    }