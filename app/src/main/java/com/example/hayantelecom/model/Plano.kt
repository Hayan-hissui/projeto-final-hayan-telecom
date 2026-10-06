package com.example.hayantelecom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planos")
data class Plano(
    @PrimaryKey
    val id: String,
    val nome: String,
    val valorMensalidade: Double,
    val status: String
)
