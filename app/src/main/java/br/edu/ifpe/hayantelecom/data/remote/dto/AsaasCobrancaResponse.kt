/*
 * Hayan Telecom - App Android
 * Arquivo: AsaasCobrancaResponse.kt
 * Responsável: Alberto Vinicius e Gabriel Fernando / Dados
 * Descrição: DTO para a resposta da listagem de cobranças da API Asaas.
 */

package br.edu.ifpe.hayantelecom.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AsaasCobrancaListResponse(
    @SerializedName("data") val data: List<AsaasCobrancaDto>,
    @SerializedName("hasMore") val hasMore: Boolean,
    @SerializedName("totalCount") val totalCount: Int
)

data class AsaasCobrancaDto(
    @SerializedName("id") val id: String,
    @SerializedName("customer") val customerId: String,
    @SerializedName("value") val value: Double,
    @SerializedName("dueDate") val dueDate: String,
    @SerializedName("status") val status: String,
    @SerializedName("bankSlipUrl") val bankSlipUrl: String?,
    @SerializedName("identificationField") val identificationField: String?,
    @SerializedName("description") val description: String?
)
