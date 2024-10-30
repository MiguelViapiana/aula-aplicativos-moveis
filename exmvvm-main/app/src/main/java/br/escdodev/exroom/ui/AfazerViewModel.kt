package br.escdodev.exroom.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.escdodev.exroom.data.Afazer
import br.escdodev.exroom.data.AfazerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AfazerViewModel(
    private val dao: AfazerDao
): ViewModel() {

    fun excluir(afazer: Afazer) {
        viewModelScope.launch {
            dao.excluirAfazer(afazer)
        }
    }

    suspend fun buscarAfazerPorId(afazerId: Int): Afazer? {
        return withContext(Dispatchers.IO){
            dao.buscarAfazerPorId(afazerId)
        }
    }

    fun gravar(afazerSalvar: Afazer) {
        viewModelScope.launch {
            dao.gravarAfazer(afazerSalvar)
        }
    }

    private val _afazeres = MutableStateFlow<List<Afazer>>(emptyList())
    val afazeres: StateFlow<List<Afazer>> get() = _afazeres

    init {
        viewModelScope.launch {
            dao.listarAfazeres().collectLatest { listaDeAfazeres ->
                _afazeres.value = listaDeAfazeres
            }
        }
    }
}