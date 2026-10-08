/*
 * Hayan Telecom - App Android
 * Arquivo: ProfileScreen.kt
 * Responsável: Gabriel Fernando / Minha Conta
 * Descrição: Tela de exibição dos dados cadastrais do cliente e opção de encerramento de sessão (Logout).
 */

package br.edu.ifpe.hayantelecom.ui.features.profile

import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifpe.hayantelecom.model.Cliente
import br.edu.ifpe.hayantelecom.ui.theme.DividerColor
import br.edu.ifpe.hayantelecom.ui.theme.StatusSuspended
import br.edu.ifpe.hayantelecom.ui.theme.SurfaceWhite
import br.edu.ifpe.hayantelecom.ui.theme.TextPrimary
import br.edu.ifpe.hayantelecom.ui.theme.TextSecondary

@Composable
fun ProfileScreen(
    cliente: Cliente?,
    onLogoutClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Minha Conta",
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
                Text(
                    text = "Dados Cadastrais",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )

                Spacer(modifier = Modifier.height(16.dp))

                ItemPerfil(label = "Nome Completo", value = cliente?.nome ?: "Jorge Silva")
                HorizontalDivider(color = DividerColor, modifier = Modifier.padding(vertical = 10.dp))

                ItemPerfil(label = "E-mail", value = cliente?.email ?: "jorge@hayantelecom.com.br")
                HorizontalDivider(color = DividerColor, modifier = Modifier.padding(vertical = 10.dp))

                ItemPerfil(label = "CPF", value = cliente?.cpf ?: "123.456.789-00")
                HorizontalDivider(color = DividerColor, modifier = Modifier.padding(vertical = 10.dp))

                ItemPerfil(label = "Código do Cliente", value = cliente?.codigoCliente ?: "HT-001284")
                HorizontalDivider(color = DividerColor, modifier = Modifier.padding(vertical = 10.dp))

                ItemPerfil(label = "Endereço Cadastrado", value = cliente?.endereco ?: "Rua das Telecomunicações, 100 - Recife, PE")

                Spacer(modifier = Modifier.height(28.dp))

                Button(
                    onClick = onLogoutClicked,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = StatusSuspended)
                ) {
                    Text(
                        text = "Sair da conta",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun ItemPerfil(label: String, value: String) {
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
