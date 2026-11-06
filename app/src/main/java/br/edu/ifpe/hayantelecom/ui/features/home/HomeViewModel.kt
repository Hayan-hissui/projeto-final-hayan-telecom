/*
 * Hayan Telecom - App Android
 * Arquivo: HomeViewModel.kt
 * Responsável: Hayan / Interface e Dashboard
 * Descrição: ViewModel para gerenciar o estado do Dashboard (Início).
 */

package br.edu.ifpe.hayantelecom.ui.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.ifpe.hayantelecom.data.repository.HayanRepository
import br.edu.ifpe.hayantelecom.model.Cliente
import br.edu.ifpe.hayantelecom.model.Cobranca
import br.edu.ifpe.hayantelecom.model.Plano
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HayanRepository) : ViewModel() {

    val cliente: StateFlow<Cliente?> = repository.clienteFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val plano: StateFlow<Plano?> = repository.planoFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val cobrancaPendente: StateFlow<Cobranca?> = repository.cobrancaPendenteFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun sincronizarDados() {
        viewModelScope.launch {
            repository.sincronizarCobrancasRemotas()
        }
    }
}
