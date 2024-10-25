package br.escdodev.exroom.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.escdodev.exroom.data.Afazer
import br.escdodev.exroom.data.AfazerDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AfazerViewModel(
    private val dao: AfazerDao
): ViewModel() {

    private val _afazeres = MutableStateFlow<List<Afazer>>(emptyList())
    val afazeres: StateFlow<List<Afazer>> get() = _afazeres

    init {
        viewModelScope.launch {
            dao.listarAfazeres().collectLatest {  }
        }
    }

}