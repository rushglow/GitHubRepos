package com.example.githubrepos.app.model

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepos.app.login.LoginPresenter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class Model {
    fun setLoginToken(loginToken: String) {
        //var repoPresenter = RepoPresenter()
        var loginPresenter = LoginPresenter()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/users/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val repoApi = retrofit.create(GithubApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            try{
                var repositories = repoApi.getRepositories(loginToken)
                loginPresenter.showError("логин")
            }catch (e:Exception){
                loginPresenter.showError("Неправильный логин")
            }

            // repoPresenter.getRepositories(repositories)
        }

    }
}