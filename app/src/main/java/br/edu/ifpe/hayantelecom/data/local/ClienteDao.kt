/*
 * Hayan Telecom - App Android
 * Arquivo: ClienteDao.kt
 * Responsável: Gabriel Fernando / Dados
 * Descrição: Interface DAO do Room para operações com a tabela de clientes.
 */

package br.edu.ifpe.hayantelecom.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.ifpe.hayantelecom.model.Cliente
import kotlinx.coroutines.flow.Flow

@Dao
interface ClienteDao {
    @Query("SELECT * FROM clientes LIMIT 1")
    fun getCliente(): Flow<Cliente?>

    @Query("SELECT * FROM clientes WHERE email = :email LIMIT 1")
    fun getClienteByEmail(email: String): Cliente?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCliente(cliente: Cliente)
}
