package br.escdodev.exroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entidades ou tabelas do banco de dados
@Entity
data class Afazer(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val titulo: String,
    val descricao: String,
    val concluido: Boolean = false
){
    constructor() : this(null, "", "", false)
}