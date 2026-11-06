package br.edu.ifpe.hayantelecom.ui.features.plan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.ifpe.hayantelecom.data.repository.HayanRepository
import br.edu.ifpe.hayantelecom.model.Plano
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class PlanViewModel(private val repository: HayanRepository) : ViewModel() {
    val plano: StateFlow<Plano?> = repository.planoFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)
}
