package com.example.atividade19_05

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.atividade19_05.ui.theme.Atividade19_05Theme
import com.example.atividade19_05.ui.theme.ButtonColorsBom
import com.example.atividade19_05.ui.theme.ButtonColorsInsa
import com.example.atividade19_05.ui.theme.ButtonColorsMBOM
import com.example.atividade19_05.ui.theme.ButtonColorsReg

const val TAG = "Atividade Android"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Atividade19_05Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun ActionButton(
    text: String,

    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ){
        Text(text = text)
    }
}

@Composable
fun TextField() {
    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Nome do Aluno: ") },

    )
}

@Composable
private fun App(){
    val image = painterResource(R.drawable.eteczonaleste)
    Surface (
        modifier = Modifier.fillMaxSize(),

    ){
        Column (
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = image,
                contentDescription = stringResource(R.string.EtecZonaLeste),
                modifier= Modifier.size(120.dp)
            )
            Text(
                text = stringResource(R.string.pam),

                fontSize = 24.sp
            )

            TextField()

            ActionButton(
                text = "I",

                buttonColors = ButtonColorsInsa(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                /*Ação do Botão*/
                Log.e(TAG, "Professor: Nota: I(Insatisfatorio)!")
            }

            ActionButton(
                text = "R",

                buttonColors = ButtonColorsReg(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                /*Ação do Botão*/
                Log.w(TAG, "Professor: Nota: R(Regular)!")
            }

            ActionButton(
                text = "B",

                buttonColors = ButtonColorsBom(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                /*Ação do Botão*/
                Log.i(TAG, "Professor: Nota B(Bom)!")
            }

            ActionButton(
                text = "MB",

                buttonColors = ButtonColorsMBOM(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                /*Ação do Botão*/
                Log.d(TAG, "Professor: Nota: MB(Muito Bom)!")
            }

        }
    }
}


