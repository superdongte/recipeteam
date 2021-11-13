package com.example.recipeteam.recipe

import UserInfoList
import com.example.recipeteam.user.LoginReqDto
import retrofit2.Call
import retrofit2.http.*

interface UserInfoService {
    @GET("/list")
    fun getPeople(): Call<UserInfoList>

    @POST("/join")
    fun insetUserInfo(
        @Body user:UserInfo,
        //@Query("name") name:String

    ): Call<UserInfo>
//    @POST("/login")
//    fun getUser(
//        @Field("username") username:String,
//        @Field("password") password:String
//    ): Call<LoginReqDto>
//

}