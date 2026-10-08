/*
 * Hayan Telecom - App Android
 * Arquivo: Cobranca.kt
 * Responsável: Alberto Vinicius e Gabriel Fernando / Dados
 * Descrição: Entidade do Room que representa as mensalidades/boletos do cliente.
 */

package br.edu.ifpe.hayantelecom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cobrancas")
data class Cobranca(
    @PrimaryKey val id: String,
    val clienteId: String,
    val valor: Double,
    val dataVencimento: String,
    val status: String, // "EM_ABERTO", "PAGO", "VENCIDO"
    val codigoBoleto: String,
    val descricao: String
)
