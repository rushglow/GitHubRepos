package com.example.githubrepos.app.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.githubrepos.R
import com.example.githubrepos.databinding.ActivityLoginBinding
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class LoginActivity : MvpAppCompatActivity(R.layout.activity_login), LoginView {
    lateinit var binding: ActivityLoginBinding

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = LoginPresenter()

        binding.tokenEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                presenter.onTextEdited(binding.tokenEt.text.toString())
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        binding.btnSignIn.setOnClickListener(){
            presenter.getLogin()
        }
    }

    override fun showError(text:String) {
        Toast.makeText(applicationContext,text, Toast.LENGTH_SHORT).show()
    }

    override fun startRepoActivity() {

    }
}