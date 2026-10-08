/*
 * Hayan Telecom - App Android
 * Arquivo: Plano.kt
 * Responsável: Alberto Vinicius e Gabriel Fernando / Dados
 * Descrição: Entidade do Room que representa o plano de internet contratado pelo cliente.
 */

package br.edu.ifpe.hayantelecom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planos")
data class Plano(
    @PrimaryKey val id: String,
    val nome: String,
    val velocidade: String,
    val valorMensalidade: Double,
    val status: String // "ATIVO", "SUSPENSO"
)
