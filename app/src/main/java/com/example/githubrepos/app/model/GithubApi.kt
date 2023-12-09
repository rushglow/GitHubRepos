package com.example.githubrepos.app.model

import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("{username}/repos")
    suspend fun getRepositories(@Path("username") username: String): List<Repositories>
}