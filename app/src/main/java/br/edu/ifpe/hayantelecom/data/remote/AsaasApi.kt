package br.edu.ifpe.hayantelecom.data.remote

import br.edu.ifpe.hayantelecom.data.remote.model.AsaasPayment
import br.edu.ifpe.hayantelecom.data.remote.model.AsaasResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AsaasApi {
    @GET("payments")
    suspend fun getPayments(
        @Header("access_token") apiKey: String,
        @Query("customer") customerId: String? = null
    ): Response<AsaasResponse<AsaasPayment>>
}
