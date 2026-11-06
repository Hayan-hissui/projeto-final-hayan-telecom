package br.edu.ifpe.hayantelecom.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.edu.ifpe.hayantelecom.data.repository.HayanRepository
import br.edu.ifpe.hayantelecom.ui.features.auth.AuthViewModel
import br.edu.ifpe.hayantelecom.ui.features.home.HomeViewModel
import br.edu.ifpe.hayantelecom.ui.features.invoices.InvoicesViewModel
import br.edu.ifpe.hayantelecom.ui.features.plan.PlanViewModel
import br.edu.ifpe.hayantelecom.ui.features.profile.ProfileViewModel

class ViewModelFactory(private val repository: HayanRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository) as T
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository) as T
            modelClass.isAssignableFrom(PlanViewModel::class.java) -> PlanViewModel(repository) as T
            modelClass.isAssignableFrom(InvoicesViewModel::class.java) -> InvoicesViewModel(repository) as T
            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> ProfileViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
