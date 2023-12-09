package com.example.githubrepos.app.login

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEnd

@StateStrategyType(AddToEndSingleStrategy::class)
interface LoginView:MvpView {
    @AddToEnd
    fun startRepoActivity(){}
    @AddToEnd
    fun showError(text:String)
}