/*
 * Hayan Telecom - App Android
 * Arquivo: CobrancaMapper.kt
 * Responsável: Alberto Vinicius e Gabriel Fernando / Dados
 * Descrição: Mapper para converter DTOs da API Asaas em modelos de domínio (Cobranca).
 */

package br.edu.ifpe.hayantelecom.data.remote.mapper

import br.edu.ifpe.hayantelecom.data.remote.dto.AsaasCobrancaDto
import br.edu.ifpe.hayantelecom.model.Cobranca

fun AsaasCobrancaDto.toModel(): Cobranca {
    return Cobranca(
        id = this.id,
        clienteId = this.customerId,
        valor = this.value,
        dataVencimento = formatarDataAsaas(this.dueDate),
        status = mapStatusAsaas(this.status),
        codigoBoleto = this.identificationField ?: "",
        descricao = this.description ?: "Mensalidade Hayan Telecom"
    )
}

private fun formatarDataAsaas(data: String): String {
    // A API Asaas retorna YYYY-MM-DD. Convertendo para DD/MM/YYYY para a UI.
    val partes = data.split("-")
    return if (partes.size == 3) {
        "${partes[2]}/${partes[1]}/${partes[0]}"
    } else {
        data
    }
}

private fun mapStatusAsaas(status: String): String {
    return when (status) {
        "RECEIVED", "CONFIRMED", "RECEIVED_IN_CASH" -> "PAGO"
        "OVERDUE" -> "VENCIDO"
        "PENDING" -> "EM_ABERTO"
        else -> status
    }
}
