/*
 * Hayan Telecom - App Android
 * Arquivo: PlanScreen.kt
 * Responsável: Alberto Vinicius / Visualização do Plano
 * Descrição: Tela de detalhes contratuais do plano de internet contratado pelo cliente.
 */

package br.edu.ifpe.hayantelecom.ui.features.plan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifpe.hayantelecom.model.Cliente
import br.edu.ifpe.hayantelecom.model.Plano
import br.edu.ifpe.hayantelecom.ui.components.StatusChip
import br.edu.ifpe.hayantelecom.ui.theme.BluePrimary
import br.edu.ifpe.hayantelecom.ui.theme.DividerColor
import br.edu.ifpe.hayantelecom.ui.theme.SurfaceWhite
import br.edu.ifpe.hayantelecom.ui.theme.TextPrimary
import br.edu.ifpe.hayantelecom.ui.theme.TextSecondary
import java.util.Locale

@Composable
fun PlanScreen(
    cliente: Cliente?,
    plano: Plano?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Meu Plano",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Detalhes do Plano
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = SurfaceWhite),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = plano?.nome ?: "Hayan Fibra Ultra 500 Mega",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = BluePrimary
                    )
                    StatusChip(status = plano?.status ?: "ATIVO")
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Velocidade Contratada:",
                    fontSize = 12.sp,
                    color = TextSecondary
                )
                Text(
                    text = plano?.velocidade ?: "500 Mbps",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextPrimary
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Valor Mensal:",
                    fontSize = 12.sp,
                    color = TextSecondary
                )
                Text(
                    text = "R$ ${String.format(Locale.getDefault(), "%.2f", plano?.valorMensalidade ?: 99.90)} / mês",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = BluePrimary
                )
            }
        }

        // Informações Contratuais do Titular
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = SurfaceWhite),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Dados do Titular do Plano",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )

                Spacer(modifier = Modifier.height(12.dp))

                ItemInfo(label = "Titular", value = cliente?.nome ?: "Jorge Silva")
                HorizontalDivider(color = DividerColor, modifier = Modifier.padding(vertical = 8.dp))

                ItemInfo(label = "CPF", value = cliente?.cpf ?: "123.456.789-00")
                HorizontalDivider(color = DividerColor, modifier = Modifier.padding(vertical = 8.dp))

                ItemInfo(label = "Código do Cliente", value = cliente?.codigoCliente ?: "HT-001284")
                HorizontalDivider(color = DividerColor, modifier = Modifier.padding(vertical = 8.dp))

                ItemInfo(label = "Endereço de Instalação", value = cliente?.endereco ?: "Rua das Telecomunicações, 100 - Recife, PE")
            }
        }
    }
}

@Composable
private fun ItemInfo(label: String, value: String) {
    Column {
        Text(
            text = label,
            fontSize = 12.sp,
            color = TextSecondary
        )
        Text(
            text = value,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = TextPrimary,
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}
