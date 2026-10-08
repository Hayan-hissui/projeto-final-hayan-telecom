/*
 * Hayan Telecom - App Android
 * Arquivo: Cliente.kt
 * Responsável: Alberto Vinicius e Gabriel Fernando / Dados
 * Descrição: Entidade do Room que representa os dados cadastrais do cliente.
 */

package br.edu.ifpe.hayantelecom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clientes")
data class Cliente(
    @PrimaryKey val id: String,
    val nome: String,
    val email: String,
    val cpf: String,
    val codigoCliente: String,
    val endereco: String
)
