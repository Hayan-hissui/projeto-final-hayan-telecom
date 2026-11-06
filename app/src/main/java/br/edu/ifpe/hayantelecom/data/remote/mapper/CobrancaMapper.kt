package br.edu.ifpe.hayantelecom.data.remote.mapper

import br.edu.ifpe.hayantelecom.data.remote.model.AsaasPayment
import br.edu.ifpe.hayantelecom.model.Cobranca

fun AsaasPayment.toModel(): Cobranca {
    return Cobranca(
        id = this.id,
        clienteId = this.customer,
        valor = this.value,
        dataVencimento = this.dueDate,
        status = mapStatus(this.status),
        codigoBoleto = this.identificationField ?: "",
        descricao = this.description ?: "Mensalidade Hayan Telecom"
    )
}

private fun mapStatus(asaasStatus: String): String {
    return when (asaasStatus) {
        "CONFIRMED", "RECEIVED", "RECEIVED_IN_CASH" -> "PAGO"
        "OVERDUE" -> "VENCIDO"
        else -> "EM_ABERTO"
    }
}
