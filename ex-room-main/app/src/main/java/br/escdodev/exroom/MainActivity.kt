package br.escdodev.exroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Upsert

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Text(text = "Exemplo ROOM database")
        }
    }
}

@Entity(tableName = "afazer")
data class Afazer(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val titulo: String,
    val descricao: String,
    val conclusao: Boolean = false
)

@Dao
interface AfazerDao {

    //Listar
    @Query("SELECT * FROM afazer")
    fun listarAfazeres(): List<Afazer>

    //Buscar por id
    @Query("SELECT * FROM afazer WHERE id = :id")
    fun buscarAfazerPorId(id: Int): Afazer

    //Gravar
    @Upsert
    fun GravarAFazer(afazer: Afazer)

    //Excluir
    @Delete
    fun ExcluirAfazer(afazer: Afazer)
}

@Database(entities = [Afazer::class], version = 1)
abstract class AfazerDatabase: RoomDatabase(){
    abstract fun afazerDao(): AfazerDao
}