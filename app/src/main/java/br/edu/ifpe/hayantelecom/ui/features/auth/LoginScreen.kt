/*
 * Hayan Telecom - App Android
 * Arquivo: LoginScreen.kt
 * Responsável: Gabriel Fernando / Autenticação
 * Descrição: Tela de autenticação por e-mail/CPF e senha com tratamento de erros.
 */

package br.edu.ifpe.hayantelecom.ui.features.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifpe.hayantelecom.ui.theme.BluePrimary
import br.edu.ifpe.hayantelecom.ui.theme.StatusSuspended
import br.edu.ifpe.hayantelecom.ui.theme.TextSecondary

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onNavigateToCadastro: () -> Unit
) {
    var emailOrCpf by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    fun processarLogin() {
        try {
            if (emailOrCpf.isBlank() || password.isBlank()) {
                errorMessage = "Preencha todos os campos obrigatórios."
                return
            }

            // Validação simples de credenciais conforme PRD (RF01 e RF02)
            if (password.length >= 4) {
                errorMessage = null
                onLoginSuccess()
            } else {
                errorMessage = "E-mail ou senha inválidos."
            }
        } catch (_: Exception) {
            errorMessage = "Não foi possível conectar ao servidor. Verifique sua internet e tente novamente."
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hayan Telecom",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = BluePrimary
        )

        Text(
            text = "Acesse sua conta para gerenciar seu plano",
            fontSize = 14.sp,
            color = TextSecondary,
            modifier = Modifier.padding(top = 4.dp, bottom = 32.dp)
        )

        OutlinedTextField(
            value = emailOrCpf,
            onValueChange = {
                emailOrCpf = it
                errorMessage = null
            },
            label = { Text("E-mail ou CPF") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                errorMessage = null
            },
            label = { Text("Senha") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        errorMessage?.let { error ->
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = error,
                color = StatusSuspended,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { processarLogin() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = BluePrimary)
        ) {
            Text(text = "Entrar", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(12.dp))

        TextButton(onClick = onNavigateToCadastro) {
            Text(text = "Não tem uma conta? Cadastre-se", color = BluePrimary)
        }
    }
}
