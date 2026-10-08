/*
 * Hayan Telecom - App Android
 * Arquivo: CobrancaDao.kt
 * Responsável: Alberto Vinicius e Gabriel Fernando / Dados
 * Descrição: Interface DAO do Room para operações com a tabela de cobranças.
 */

package br.edu.ifpe.hayantelecom.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.ifpe.hayantelecom.model.Cobranca
import kotlinx.coroutines.flow.Flow

@Dao
interface CobrancaDao {
    @Query("SELECT * FROM cobrancas")
    fun getAllCobrancas(): Flow<List<Cobranca>>

    @Query("SELECT * FROM cobrancas WHERE id = :id LIMIT 1")
    fun getCobrancaById(id: String): Cobranca?

    @Query("SELECT * FROM cobrancas WHERE status = 'EM_ABERTO' LIMIT 1")
    fun getCobrancaPendente(): Flow<Cobranca?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCobrancas(cobrancas: List<Cobranca>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCobranca(cobranca: Cobranca)
}
