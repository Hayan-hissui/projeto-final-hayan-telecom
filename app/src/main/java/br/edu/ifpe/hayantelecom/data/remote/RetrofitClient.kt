package br.edu.ifpe.hayantelecom.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://sandbox.asaas.com/api/v3/"

    val asaasApi: AsaasApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AsaasApi::class.java)
    }
}
