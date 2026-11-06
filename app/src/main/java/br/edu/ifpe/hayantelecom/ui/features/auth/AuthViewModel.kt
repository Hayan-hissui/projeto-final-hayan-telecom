/*
 * Hayan Telecom - App Android
 * Arquivo: AuthViewModel.kt
 * Responsável: Gabriel Fernando / Autenticação
 * Descrição: ViewModel para gerenciar o estado de autenticação e cadastro.
 */

package br.edu.ifpe.hayantelecom.ui.features.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.ifpe.hayantelecom.data.repository.HayanRepository
import br.edu.ifpe.hayantelecom.model.Cliente
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: HayanRepository) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess: StateFlow<Boolean> = _loginSuccess.asStateFlow()

    private val _cadastroSuccess = MutableStateFlow(false)
    val cadastroSuccess: StateFlow<Boolean> = _cadastroSuccess.asStateFlow()

    fun login(emailOrCpf: String, senha: String) {
        if (emailOrCpf.isBlank() || senha.isBlank()) {
            _errorMessage.value = "Preencha todos os campos obrigatórios."
            return
        }

        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val success = repository.autenticar(emailOrCpf, senha)
                if (success) {
                    _loginSuccess.value = true
                } else {
                    _errorMessage.value = "E-mail ou senha inválidos."
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erro ao conectar. Verifique sua conexão."
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun cadastrar(cliente: Cliente) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                repository.insertCliente(cliente)
                _cadastroSuccess.value = true
            } catch (e: Exception) {
                _errorMessage.value = "Erro ao realizar cadastro. Tente novamente."
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun clearError() {
        _errorMessage.value = null
    }

    fun resetStates() {
        _loginSuccess.value = false
        _cadastroSuccess.value = false
        _errorMessage.value = null
    }
}
