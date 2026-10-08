/*
 * Hayan Telecom - App Android
 * Arquivo: HomeScreen.kt
 * Responsável: Hayan / Interface, Navegação e Tela Principal
 * Descrição: Tela principal (Dashboard) apresentando o resumo do cliente, plano e situação da cobrança.
 */

package br.edu.ifpe.hayantelecom.ui.features.home

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifpe.hayantelecom.model.Cliente
import br.edu.ifpe.hayantelecom.model.Cobranca
import br.edu.ifpe.hayantelecom.model.Plano
import br.edu.ifpe.hayantelecom.ui.components.StatusChip
import br.edu.ifpe.hayantelecom.ui.theme.BluePrimary
import br.edu.ifpe.hayantelecom.ui.theme.SurfaceWhite
import br.edu.ifpe.hayantelecom.ui.theme.TextPrimary
import br.edu.ifpe.hayantelecom.ui.theme.TextSecondary
import java.util.Locale

@Composable
fun HomeScreen(
    cliente: Cliente?,
    plano: Plano?,
    cobrancaPendente: Cobranca?,
    onVerBoletoClicked: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Saudação do Cliente
        Text(
            text = "Olá, ${cliente?.nome ?: "Cliente"}",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
        Text(
            text = "Código do cliente: ${cliente?.codigoCliente ?: "HT-001284"}",
            fontSize = 14.sp,
            color = TextSecondary,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // Card do Plano Atual (F1)
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
                        text = "Seu Plano",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = TextSecondary
                    )
                    StatusChip(status = plano?.status ?: "ATIVO")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = plano?.nome ?: "Hayan Fibra Ultra",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = BluePrimary
                )

                Text(
                    text = plano?.velocidade ?: "500 Mbps Download",
                    fontSize = 14.sp,
                    color = TextSecondary,
                    modifier = Modifier.padding(top = 2.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Mensalidade: R$ ${String.format(Locale.getDefault(), "%.2f", plano?.valorMensalidade ?: 99.90)}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary
                )
            }
        }

        // Card da Cobranca Pendente (F1 e F2)
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = SurfaceWhite),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Situação da Cobrança",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextSecondary
                )

                Spacer(modifier = Modifier.height(12.dp))

                if (cobrancaPendente != null) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = cobrancaPendente.descricao,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                            Text(
                                text = "Vencimento: ${cobrancaPendente.dataVencimento}",
                                fontSize = 14.sp,
                                color = TextSecondary,
                                modifier = Modifier.padding(top = 2.dp)
                            )
                        }
                        StatusChip(status = cobrancaPendente.status)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Valor: R$ ${String.format(Locale.getDefault(), "%.2f", cobrancaPendente.valor)}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = BluePrimary
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { onVerBoletoClicked(cobrancaPendente.id) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = BluePrimary)
                    ) {
                        Text(
                            text = "Consultar Boleto e Pagar",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                } else {
                    Text(
                        text = "Você não possui cobranças pendentes no momento. Todas as mensalidades estão em dia!",
                        fontSize = 14.sp,
                        color = TextPrimary
                    )
                }
            }
        }
    }
}
