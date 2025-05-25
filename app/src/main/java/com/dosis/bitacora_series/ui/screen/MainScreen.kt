package com.dosis.bitacora_series.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dosis.bitacora_series.data.entitys.SerieEntity
import com.dosis.bitacora_series.viewmodel.SerieViewModel

@Composable
fun MainScreen() {
    val viewModel: SerieViewModel = viewModel()
    val series by viewModel.allSeries.observeAsState(emptyList())
    var selectedSerie by remember { mutableStateOf<SerieEntity?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        SerieForm(
            initialSerie = selectedSerie,
            onSubmit = {
                viewModel.addSerie(it)
                selectedSerie = null
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(series) { serie ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("🎬 ${serie.titulo}")
                            Text("📺 ${serie.plataforma} • ${serie.estado} • ⭐ ${serie.valoracion}")
                        }
                        Row {
                            IconButton(onClick = { selectedSerie = serie }) {
                                Icon(Icons.Default.Edit, contentDescription = "Editar")
                            }
                            // Si implementas eliminar, añade:
                            // IconButton(onClick = { viewModel.deleteSerie(serie) }) {
                            //     Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                            // }
                        }
                    }
                }
            }
        }
    }
}
