package com.example.recipeteam.board

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PostService {
    @GET("/board/list")
    fun getPostList(): Call<PostList>

    @POST("/board/insert")
    fun insertPost(
        @Body post: Post
    ):Call<Post>

    fun getPost(
        @Query("title") title: String
    ):Call<String>
}