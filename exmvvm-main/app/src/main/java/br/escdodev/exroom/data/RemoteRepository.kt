package br.escdodev.exroom.data

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class RemoteRepository() : IRepository {

    val db = FirebaseFirestore.getInstance()
    val afazerCollection = db.collection("afazeres")

// Função não reativa
//    override fun listarAfazeres(): Flow<List<Afazer>> = flow{
//        val dados = afazerCollection.get().await()
//        val afazeres = dados.documents.mapNotNull { dado ->
//            dado.toObject(Afazer::class.java)
//        }
//        emit(afazeres)
//    }

    //Função reativa
    override fun listarAfazeres(): Flow<List<Afazer>> = callbackFlow{
        val listener = afazerCollection.addSnapshotListener{
            dados, erros ->
            if(erros != null){
                close(erros)
                return@addSnapshotListener
            }
            if(dados != null){
                val afazeres = dados.documents.mapNotNull { dado ->
                    dado.toObject(Afazer::class.java)
                }
                trySend(afazeres).isSuccess
            }
        }
        awaitClose{ listener }
    }

    override suspend fun buscarAfazerPorId(idx: Int): Afazer {
        TODO("Not yet implemented")
    }

    override suspend fun gravarAfazer(afazer: Afazer) {
        val document = afazerCollection.document()
        document.set(afazer).await()
    }

    override suspend fun excluirAfazer(afazer: Afazer) {
        TODO("Not yet implemented")
    }

}