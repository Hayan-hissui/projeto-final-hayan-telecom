/*
 * Hayan Telecom - App Android
 * Arquivo: StatusChip.kt
 * Responsável: Hayan / Design e Interface
 * Descrição: Chip customizado para exibição visual do status do plano ou cobrança.
 */

package br.edu.ifpe.hayantelecom.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifpe.hayantelecom.ui.theme.StatusActive
import br.edu.ifpe.hayantelecom.ui.theme.StatusPending
import br.edu.ifpe.hayantelecom.ui.theme.StatusSuspended

@Composable
fun StatusChip(status: String) {
    val (backgroundColor, textColor, label) = when (status.uppercase()) {
        "ATIVO", "PAGO" -> Triple(StatusActive.copy(alpha = 0.15f), StatusActive, if (status == "ATIVO") "Plano Ativo" else "Pago")
        "SUSPENSO", "VENCIDO" -> Triple(StatusSuspended.copy(alpha = 0.15f), StatusSuspended, if (status == "SUSPENSO") "Plano Suspenso" else "Vencido")
        "EM_ABERTO" -> Triple(StatusPending.copy(alpha = 0.15f), StatusPending, "Em Aberto")
        else -> Triple(Color.Gray.copy(alpha = 0.15f), Color.DarkGray, status)
    }

    Text(
        text = label,
        color = textColor,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .background(backgroundColor, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 10.dp, vertical = 4.dp)
    )
}
