package br.escdodev.exroom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

// Objetos de manipulação do banco de dados

@Dao
interface AfazerDao {

    //Listar
    @Query("select * from afazer")
    suspend fun listarAfazeres(): List<Afazer>

    //Buscar por Id
    @Query("select * from afazer where id = :idx")
    suspend fun buscarAfazerPorId(idx: Int): Afazer

    //Gravar @Update @Insert
    @Upsert
    suspend fun gravarAfazer(afazer: Afazer)

    //Excluir
    @Delete
    suspend fun excluirAfazer(afazer: Afazer)

}