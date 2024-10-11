package br.escdodev.planner.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "afazeres")
data class Afazer(
    var titulo: String,
    var descricao: String,
    var concluido: Boolean = false,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
){
    constructor() : this(
        titulo = "",
        descricao = "",
        concluido  = false)
}