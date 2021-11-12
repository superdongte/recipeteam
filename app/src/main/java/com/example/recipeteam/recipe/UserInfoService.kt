package com.example.recipeteam.recipe

import UserInfoList
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserInfoService {
    @GET("/list")
    fun getPeople(): Call<UserInfoList>

    @POST("/insert")
    fun insetUserInfo(
        @Body user:UserInfo,
        //@Query("name") name:String

    ): Call<UserInfo>

    fun getUser(
        @Query("id") id:String
    ): Call<String>

}