/*
 * Hayan Telecom - App Android
 * Arquivo: AsaasApiService.kt
 * Responsável: Alberto Vinicius e Gabriel Fernando / Dados
 * Descrição: Interface Retrofit para a API do Asaas (Ambiente Sandbox).
 */

package br.edu.ifpe.hayantelecom.data.remote

import br.edu.ifpe.hayantelecom.data.remote.dto.AsaasCobrancaListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AsaasApiService {

    @GET("v3/payments")
    suspend fun getPayments(
        @Header("access_token") apiKey: String,
        @Query("customer") customerId: String? = null,
        @Query("status") status: String? = null
    ): Response<AsaasCobrancaListResponse>
}
