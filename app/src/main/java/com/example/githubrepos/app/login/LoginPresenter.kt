package com.example.githubrepos.app.login

import com.example.githubrepos.app.model.Model
import moxy.MvpPresenter

class LoginPresenter:MvpPresenter<LoginView>() {
    lateinit var model: Model
    lateinit var login:String

    fun getLogin(){
        if (login.isNotEmpty())
        {
            loginToModel(login)
        }else{
            viewState.showError("text")
        }

    }

    fun showError(text:String){
        viewState.showError(text)
    }
    fun loginToModel(login:String){
        model = Model()
        model.setLoginToken(login)
    }

    fun startRepoActivity() {
        viewState.startRepoActivity()
    }

    fun onTextEdited(loginAct:String){
        login = loginAct
    }
}