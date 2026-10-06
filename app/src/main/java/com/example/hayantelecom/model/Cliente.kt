package com.example.hayantelecom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clientes")
data class Cliente(
    @PrimaryKey
    val id: String,
    val nome: String,
    val email: String
)
