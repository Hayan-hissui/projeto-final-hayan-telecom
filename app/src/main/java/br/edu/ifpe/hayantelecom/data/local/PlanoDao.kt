/*
 * Hayan Telecom - App Android
 * Arquivo: PlanoDao.kt
 * Responsável: Alberto Vinicius / Dados
 * Descrição: Interface DAO do Room para operações com a tabela de planos.
 */

package br.edu.ifpe.hayantelecom.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.edu.ifpe.hayantelecom.model.Plano
import kotlinx.coroutines.flow.Flow

@Dao
interface PlanoDao {
    @Query("SELECT * FROM planos LIMIT 1")
    fun getPlano(): Flow<Plano?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlano(plano: Plano)
}
