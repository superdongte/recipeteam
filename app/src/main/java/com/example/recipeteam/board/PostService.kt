package com.example.recipeteam.board

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PostService {
    @GET("/boardlist")
    fun getPostList(): Call<PostList>

    @POST("/boardinsert")
    fun insertPost(
        @Body post: Post
    ):Call<PostList>

    fun getPost(
        @Query("title") title: String
    ):Call<String>
}