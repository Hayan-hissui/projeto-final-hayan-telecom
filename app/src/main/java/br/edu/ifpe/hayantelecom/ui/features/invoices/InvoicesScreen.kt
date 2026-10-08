/*
 * Hayan Telecom - App Android
 * Arquivo: InvoicesScreen.kt
 * Responsável: Alberto Vinicius / Boletos e Cobranças
 * Descrição: Tela com listagem de cobranças separadas por situação ("Em aberto" e "Pago").
 */

package br.edu.ifpe.hayantelecom.ui.features.invoices

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifpe.hayantelecom.model.Cobranca
import br.edu.ifpe.hayantelecom.ui.components.StatusChip
import br.edu.ifpe.hayantelecom.ui.theme.BluePrimary
import br.edu.ifpe.hayantelecom.ui.theme.SurfaceWhite
import br.edu.ifpe.hayantelecom.ui.theme.TextPrimary
import br.edu.ifpe.hayantelecom.ui.theme.TextSecondary
import java.util.Locale

@Composable
fun InvoicesScreen(
    cobrancas: List<Cobranca>,
    onCobrancaClicked: (String) -> Unit
) {
    val emAberto = cobrancas.filter { it.status == "EM_ABERTO" || it.status == "VENCIDO" }
    val pagas = cobrancas.filter { it.status == "PAGO" }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = "Minhas Cobranças",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (emAberto.isNotEmpty()) {
                item {
                    Text(
                        text = "Em aberto",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextSecondary,
                        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                    )
                }
                items(emAberto) { cobranca ->
                    CobrancaItemCard(cobranca = cobranca, onClick = { onCobrancaClicked(cobranca.id) })
                }
            }

            if (pagas.isNotEmpty()) {
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Histórico de pagamentos",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextSecondary,
                        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                    )
                }
                items(pagas) { cobranca ->
                    CobrancaItemCard(cobranca = cobranca, onClick = { onCobrancaClicked(cobranca.id) })
                }
            }

            if (cobrancas.isEmpty()) {
                item {
                    Text(
                        text = "Nenhuma cobrança encontrada no momento.",
                        fontSize = 14.sp,
                        color = TextSecondary,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun CobrancaItemCard(
    cobranca: Cobranca,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = cobranca.descricao,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Text(
                    text = "Vencimento: ${cobranca.dataVencimento}",
                    fontSize = 13.sp,
                    color = TextSecondary,
                    modifier = Modifier.padding(top = 2.dp)
                )
                Text(
                    text = "R$ ${String.format(Locale.getDefault(), "%.2f", cobranca.valor)}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = BluePrimary,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            StatusChip(status = cobranca.status)
        }
    }
}
