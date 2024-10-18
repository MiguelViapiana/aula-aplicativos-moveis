package br.escdodev.exroom

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Upsert
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListAfazeresScreen()
        }
    }
}

@Composable
fun ListAfazeresScreen(){

    val context = LocalContext.current
    val db = abrirBancoDeDados(context)
    val coroutineScope = rememberCoroutineScope()

    //Popular e carregar dados do banco
    var afazeres by remember { mutableStateOf(listOf<Afazer>()) }

    //Dados do novo afazer
    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }



    LaunchedEffect(Unit) {
        coroutineScope.launch {
            if(db.afazerDao().listarAfazeres().isEmpty()) {
                db.afazerDao().GravarAFazer(
                    Afazer(titulo = "Afazer A", descricao = "A")
                )
                db.afazerDao().GravarAFazer(
                    Afazer(titulo = "Afazer B", descricao = "B")
                )
                db.afazerDao().GravarAFazer(
                    Afazer(titulo = "Afazer C", descricao = "c")
                )
            }
            afazeres = db.afazerDao().listarAfazeres()
        }
    }

    Column(
        modifier = Modifier.padding(
            top = 90.dp,
            start = 30.dp,
            end =30.dp,
            bottom = 30.dp
        )
    ) {
        Text(text = "Novo afazeres",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = titulo, onValueChange = { titulo = it}
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = descricao, onValueChange = { descricao = it}
        )
        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
            coroutineScope.launch {
                val novoAfazer = Afazer(
                    titulo = titulo,
                    descricao = descricao
                )
                db.afazerDao().GravarAFazer(novoAfazer)
                afazeres = db.afazerDao().listarAfazeres()
            }
        })
        {
            Text(text = "Salvar", fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Lista de afazeres",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
        for(afazer in afazeres){
            Text(text = afazer.titulo )

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
    suspend fun listarAfazeres(): List<Afazer>

    //Buscar por id
    @Query("SELECT * FROM afazer WHERE id = :id")
    suspend fun buscarAfazerPorId(id: Int): Afazer

    //Gravar
    @Upsert
    suspend fun GravarAFazer(afazer: Afazer)

    //Excluir
    @Delete
    suspend fun ExcluirAfazer(afazer: Afazer)
}

@Database(entities = [Afazer::class], version = 1)
abstract class AfazerDatabase: RoomDatabase(){
    abstract fun afazerDao(): AfazerDao

}

fun abrirBancoDeDados(context: Context): AfazerDatabase{
    return Room.databaseBuilder(
        context.applicationContext,
        AfazerDatabase::class.java, "afazer.db"
    ).build()
}

//object AfazeresRoute{
//    val LISTAR_AFAZERES_SCREEN = "Listar_afazeres"
//    val INCLUIR_AFAZER_SCREEN = "incluir_afazer"
//}


//@Composable
//fun AfazeresNavHost(){
//
//    val context = LocalContext.current
//    val db = AfazerDatabase.getInstance(context)
//
//    val navController = rememberNavController()
//
//    NavHost(navController = navController,
//        startDestination = AfazeresRoute.LISTAR_AFAZERES_SCREEN)
//    {
//        //Primeira tela
//        composable(AfazeresRoute.LISTAR_AFAZERES_SCREEN ){
//            ListAfazeresScreen(db, navController)
//        }
//        //Segunda tela
//        composable(AfazeresRoute.INCLUIR_AFAZER_SCREEN){
//            IncluirAfazerScreen(db, navController)
//        }
//    }
//}

//@Composable
//fun IncluirAfazerScreen(
//    db: AfazerDatabase,
//    navController: NavController
//){
//    Column(modifier = Modifier.padding(50.dp)) {
//        Text(text = "Tela para incluir afazer")
//    }
//}



