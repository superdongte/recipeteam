package com.example.recipeteam.user

import retrofit2.Call
import retrofit2.http.*

interface UserInfoService {
    @GET("/list")
    fun getPeople(): Call<UserInfoList>

    @POST("/join")
    fun insertUserInfo(
        @Body user: User,
        //@Query("name") name:String

    ): Call<User>
//    @POST("/login")
//    fun getUser(
//        @Field("username") username:String,
//        @Field("password") password:String
//    ): Call<LoginReqDto>
//

}