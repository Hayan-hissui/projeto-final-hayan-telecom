/*
 * Hayan Telecom - App Android
 * Arquivo: MainActivity.kt
 * Responsável: Hayan / Geral e Navegação
 * Descrição: Activity principal do aplicativo Hayan Telecom que inicializa o Room e o NavGraph.
 */

package br.edu.ifpe.hayantelecom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import br.edu.ifpe.hayantelecom.data.local.AppDatabase
import br.edu.ifpe.hayantelecom.data.repository.HayanRepository
import br.edu.ifpe.hayantelecom.ui.navigation.NavGraph
import br.edu.ifpe.hayantelecom.ui.theme.HayanTelecomTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = AppDatabase.getDatabase(applicationContext)
        val repository = HayanRepository(database)

        lifecycleScope.launch {
            repository.popularDadosIniciaisSeNecessario()
        }

        setContent {
            HayanTelecomTheme {
                val navController = rememberNavController()
                NavGraph(
                    navController = navController,
                    repository = repository
                )
            }
        }
    }
}
