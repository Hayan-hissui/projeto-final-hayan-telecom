package br.edu.ifpe.hayantelecom.ui.features.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.ifpe.hayantelecom.data.repository.HayanRepository
import br.edu.ifpe.hayantelecom.model.Cliente
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: HayanRepository) : ViewModel() {

    val cliente: StateFlow<Cliente?> = repository.clienteFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun atualizarPerfil(cliente: Cliente) {
        viewModelScope.launch {
            repository.updateCliente(cliente)
        }
    }
}
