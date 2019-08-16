package com.example.magasin

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface HttpReader {

    @GET(value="login.php")
    fun login(@Body data:MyLogin):Call<MyLogin>
    @POST("register.php")
    fun registerUser(
        @Field("userName") userNameValue: String,
        @Field("password") passwordValue: String
    ): Call<ResponseBody>
    @POST("registerObjet.php")
    fun registerObjetPerdu(
        @Field("title") titleValue: String,
        @Field("description") descptionValue: String,
        @Field("location") locationValue: String
    ): Call<ResponseBody>
    @GET(value = "getPerdu.php")
    fun getObjetPerdu(): Call<MyObjet>
}