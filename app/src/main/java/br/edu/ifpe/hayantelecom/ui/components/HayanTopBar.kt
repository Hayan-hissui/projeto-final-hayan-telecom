/*
 * Hayan Telecom - App Android
 * Arquivo: HayanTopBar.kt
 * Responsável: Hayan / Interface e Navegação
 * Descrição: Barra superior do aplicativo com o título e cor principal #424F8F.
 */

package br.edu.ifpe.hayantelecom.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import br.edu.ifpe.hayantelecom.ui.theme.BluePrimary
import br.edu.ifpe.hayantelecom.ui.theme.SurfaceWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HayanTopBar(
    title: String = "Hayan Telecom",
    canNavigateBack: Boolean = false,
    onNavigateBack: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                color = SurfaceWhite
            )
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = SurfaceWhite
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = BluePrimary,
            titleContentColor = SurfaceWhite
        )
    )
}
