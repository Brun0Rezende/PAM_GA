package com.example.atividade1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.atividade1.ui.theme.Atividade1Theme
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenContent()
        }
    }
}

@Composable
fun MainScreenContent(){
    Scaffold(
         topBar = {
                   TopAppBar(
                       content = { Text(text = "TaskAppBar")}
                   )
         },
         content = {
                 paddingValues -> Log.i("PaddinValues","$paddingValues")
                 Column(
                     modifier = Modifier
                         .background(Color.Yellow)
                         .fillMaxSize()

                 ) {
                     MySerchField(modificador = Modifier.fillMaxWidth())
                     MyTaskWidget(
                         modificador = Modifier.fillMaxWidth(),
                         TaskName = "Preparar Aula LazyList/LazyColum",
                         TaskDetails = "É bem melhor usar lazlist ao inves de colum",
                         DeadEndDate = Date()

                     )
                     Text("Task3")
                     Text("Task4")
                 }
         },
        bottomBar = {
            BottomAppBar(
                content = { Text("asdf")}
            )
        }
    )
}

@Composable
fun MySerchField(modificador: Modifier){
    TextField(
        value = "",
        onValueChange = {},
        modifier = modificador,
        placeholder = { Text(text = "Pesquisar Tarefas")},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        }
    )
}

@Composable
fun MyTaskWidget(modificador: Modifier,
                 TaskName: String,
                 TaskDetails:String,
                 DeadEndDate: Date
                 ){
    val dateFormatter= SimpleDateFormat("EEE, MMM dd, yyyy", Locale.getDefault())
    Row(modifier = modificador) {
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Icons of a pendent task"
        )
        Text(
            text = dateFormatter.format(DeadEndDate),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        Column(
            modifier = Modifier
                .border(width = 1.dp, color = Color.Black)
                .padding(3.dp)
        ) {
            Text(
                text = TaskName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic
            )
            Text(
                text = TaskDetails,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal
            )
        }
    }

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreenContent()
}