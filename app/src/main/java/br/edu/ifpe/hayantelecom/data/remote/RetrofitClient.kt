/*
 * Hayan Telecom - App Android
 * Arquivo: RetrofitClient.kt
 * Responsável: Alberto Vinicius e Gabriel Fernando / Dados
 * Descrição: Configuração central do Retrofit para acesso à API do Asaas.
 */

package br.edu.ifpe.hayantelecom.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://sandbox.asaas.com/api/"

    val asaasApi: AsaasApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AsaasApiService::class.java)
    }
}
