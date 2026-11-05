/*
 * Hayan Telecom - App Android
 * Arquivo: PlanoDao.kt
 * Responsável: Alberto Vinicius / Dados
 * Descrição: Interface DAO do Room para operações com a tabela de planos.
 */

package br.edu.ifpe.hayantelecom.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.edu.ifpe.hayantelecom.model.Plano
import kotlinx.coroutines.flow.Flow

@Dao
interface PlanoDao {
    @Query("SELECT * FROM planos LIMIT 1")
    fun getPlano(): Flow<Plano?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlano(plano: Plano)

    @Update
    suspend fun updatePlano(plano: Plano)

    @Delete
    suspend fun deletePlano(plano: Plano)
}
