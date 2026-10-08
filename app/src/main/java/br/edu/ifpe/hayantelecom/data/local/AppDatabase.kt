/*
 * Hayan Telecom - App Android
 * Arquivo: AppDatabase.kt
 * Responsável: Alberto Vinicius e Gabriel Fernando / Dados
 * Descrição: Banco de dados Room principal do aplicativo Hayan Telecom.
 */

package br.edu.ifpe.hayantelecom.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.ifpe.hayantelecom.model.Cliente
import br.edu.ifpe.hayantelecom.model.Cobranca
import br.edu.ifpe.hayantelecom.model.Plano

@Database(
    entities = [Cliente::class, Plano::class, Cobranca::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clienteDao(): ClienteDao
    abstract fun planoDao(): PlanoDao
    abstract fun cobrancaDao(): CobrancaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "hayan_telecom_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
