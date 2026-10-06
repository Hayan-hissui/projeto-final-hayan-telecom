package com.example.hayantelecom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cobrancas")
data class Cobranca(
    @PrimaryKey
    val id: String,
    val clienteId: String,
    val valor: Double,
    val dataVencimento: String,
    val status: String,
    val codigoBoleto: String?
)
