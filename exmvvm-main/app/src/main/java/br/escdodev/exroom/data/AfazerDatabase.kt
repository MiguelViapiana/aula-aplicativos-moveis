package br.escdodev.exroom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Banco de dados.
//@Database(
//    Tabelas no banco de dados
//    entities = [
//        Afazer::class
//        Livro::class,
//        Pessoa::class...
//    ],
//    version = 1
//)
@Database(entities = [Afazer::class], version = 2)
abstract class AfazerDatabase: RoomDatabase(){
    abstract fun afazerDao(): AfazerDao

    companion object{
        fun abrirBancoDeDados(context: Context): AfazerDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AfazerDatabase::class.java, "afazerMvvM.db"
            ).build()
        }
    }


}