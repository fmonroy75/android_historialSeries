package com.dosis.bitacora_series.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.dosis.bitacora_series.data.entitys.*
import com.dosis.bitacora_series.viewmodel.SerieViewModel

@Composable
fun HomeScreen(viewModel: SerieViewModel = viewModel()) {
    val series by viewModel.allSeries.observeAsState(emptyList())

    var titulo by remember { mutableStateOf("") }
    var plataforma by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        Text("Registrar Serie", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(value = titulo, onValueChange = { titulo = it }, label = { Text("Título") })
        OutlinedTextField(value = plataforma, onValueChange = { plataforma = it }, label = { Text("Plataforma") })

        Button(onClick = {
            if (titulo.isNotBlank() && plataforma.isNotBlank()) {
                viewModel.addSerie(
                    SerieEntity(
                        titulo = titulo,
                        plataforma = plataforma,
                        estado = Estado.EN_CURSO,
                        valoracion = Valoracion.BUENA
                    )
                )
                titulo = ""
                plataforma = ""
            }
        }, modifier = Modifier.padding(top = 8.dp)) {
            Text("Agregar")
        }

        Spacer(Modifier.height(24.dp))
        Divider()
        Spacer(Modifier.height(16.dp))

        Text("Series registradas:", style = MaterialTheme.typography.titleMedium)
        series.forEach {
            Text("${it.titulo} (${it.plataforma}) - ${it.estado} / ${it.valoracion}")
        }
    }
}
