/*
 * Hayan Telecom - App Android
 * Arquivo: InvoiceDetailScreen.kt
 * Responsável: Hayan / Integração com Boletos e Pagamento
 * Descrição: Tela com os detalhes do boleto bancário e opção de simulação do pagamento.
 */

package br.edu.ifpe.hayantelecom.ui.features.invoices

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifpe.hayantelecom.model.Cobranca
import br.edu.ifpe.hayantelecom.ui.components.StatusChip
import br.edu.ifpe.hayantelecom.ui.theme.BackgroundGray
import br.edu.ifpe.hayantelecom.ui.theme.BluePrimary
import br.edu.ifpe.hayantelecom.ui.theme.StatusActive
import br.edu.ifpe.hayantelecom.ui.theme.StatusSuspended
import br.edu.ifpe.hayantelecom.ui.theme.SurfaceWhite
import br.edu.ifpe.hayantelecom.ui.theme.TextPrimary
import br.edu.ifpe.hayantelecom.ui.theme.TextSecondary
import java.util.Locale

@Composable
fun InvoiceDetailScreen(
    cobranca: Cobranca?,
    onPagarClicked: (String) -> Unit
) {
    val context = LocalContext.current
    var feedbackMessage by remember { mutableStateOf<String?>(null) }
    var feedbackIsError by remember { mutableStateOf(false) }

    fun copiarLinhaDigitavel(codigo: String) {
        try {
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Código de Barras", codigo)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(context, "Código de barras copiado!", Toast.LENGTH_SHORT).show()
        } catch (_: Exception) {
            feedbackMessage = "Não foi possível acessar o boleto no momento. Tente novamente mais tarde."
            feedbackIsError = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        if (cobranca == null) {
            Text(
                text = "Não foi possível carregar suas cobranças. Tente novamente.",
                color = StatusSuspended,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(16.dp)
            )
            return
        }

        Text(
            text = "Detalhes do Boleto",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
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
                        text = cobranca.descricao,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    StatusChip(status = cobranca.status)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Valor da mensalidade:",
                    fontSize = 13.sp,
                    color = TextSecondary
                )
                Text(
                    text = "R$ ${String.format(Locale.getDefault(), "%.2f", cobranca.valor)}",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = BluePrimary
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Data de vencimento:",
                    fontSize = 13.sp,
                    color = TextSecondary
                )
                Text(
                    text = cobranca.dataVencimento,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Linha Digitável / Código de Barras:",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextSecondary
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .background(BackgroundGray, shape = RoundedCornerShape(8.dp))
                        .padding(12.dp)
                ) {
                    Text(
                        text = cobranca.codigoBoleto,
                        fontSize = 13.sp,
                        fontFamily = FontFamily.Monospace,
                        color = TextPrimary
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedButton(
                    onClick = { copiarLinhaDigitavel(cobranca.codigoBoleto) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Copiar código de barras", color = BluePrimary)
                }

                Spacer(modifier = Modifier.height(16.dp))

                if (cobranca.status != "PAGO") {
                    Button(
                        onClick = {
                            try {
                                onPagarClicked(cobranca.id)
                                feedbackMessage = "Pagamento processado com sucesso via Asaas (Sandbox)!"
                                feedbackIsError = false
                            } catch (_: Exception) {
                                feedbackMessage = "Não foi possível conectar ao servidor. Verifique sua internet e tente novamente."
                                feedbackIsError = true
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = BluePrimary)
                    ) {
                        Text(
                            text = "Realizar Pagamento (Asaas Sandbox)",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                feedbackMessage?.let { msg ->
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = msg,
                        color = if (feedbackIsError) StatusSuspended else StatusActive,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}
