package br.edu.ifpe.hayantelecom.data.remote.model

import com.google.gson.annotations.SerializedName

data class AsaasResponse<T>(
    val data: List<T>
)

data class AsaasPayment(
    val id: String,
    val customer: String,
    val value: Double,
    val dueDate: String,
    val status: String,
    @SerializedName("invoiceUrl") val invoiceUrl: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("identificationField") val identificationField: String?
)
