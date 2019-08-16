package com.example.magasin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit= Retrofit.Builder()
            .baseUrl("http://192.168.94.100/Android/retrofit/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val serv = retrofit.create(HttpReader::class.java)

        btnLogin.setOnClickListener(){
            var servercall= serv.login(MyLogin(tbuser.text.toString(),tbPswd.text.toString()))
            servercall.enqueue(object : Callback<MyLogin> {
                override fun onFailure(call: Call<MyLogin>, t: Throwable) {
                    Log.i("erreur",t.message)
                }
                override fun onResponse(call: Call<MyLogin>, response: Response<MyLogin>) {
                    if(response.body()?.username != null){
                        var i:Intent= Intent(this@MainActivity,userMenu::class.java)
                        startActivity(i)
                    }

                   // Log.i("le user", response.body()?.username)
                }
            })

        }
        btnShowRegister.setOnClickListener(){
            var i: Intent = Intent(this,Register::class.java)
            startActivity(i)
        }
    }

}
