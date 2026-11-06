package br.edu.ifpe.hayantelecom.ui.features.invoices

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.ifpe.hayantelecom.data.repository.HayanRepository
import br.edu.ifpe.hayantelecom.model.Cobranca
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class InvoicesViewModel(private val repository: HayanRepository) : ViewModel() {

    val cobrancas: StateFlow<List<Cobranca>> = repository.cobrancasFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun atualizarCobrancas() {
        viewModelScope.launch {
            _isLoading.value = true
            repository.sincronizarCobrancasRemotas()
            _isLoading.value = false
        }
    }

    fun pagarCobranca(cobrancaId: String) {
        viewModelScope.launch {
            repository.simularPagamento(cobrancaId)
        }
    }
}
