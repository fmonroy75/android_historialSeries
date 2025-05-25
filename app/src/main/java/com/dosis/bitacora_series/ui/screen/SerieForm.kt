package com.dosis.bitacora_series.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dosis.bitacora_series.data.entitys.*

@Composable
fun SerieForm(
    onSubmit: (SerieEntity) -> Unit,
    initialSerie: SerieEntity? = null
) {
    var titulo by remember { mutableStateOf(initialSerie?.titulo ?: "") }

    var plataforma by remember {
        mutableStateOf(initialSerie?.plataforma ?: Plataforma.NETFLIX.name)
    }
    var estado by remember {
        mutableStateOf(initialSerie?.estado?.name ?: Estado.EN_CURSO.name)
    }
    var valoracion by remember {
        mutableStateOf(initialSerie?.valoracion?.name ?: Valoracion.BUENA.name)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título") },
            modifier = Modifier.fillMaxWidth()
        )

        DropdownSelector("Plataforma", plataforma, Plataforma.values().map { it.name }) {
            plataforma = it
        }

        DropdownSelector("Estado", estado, Estado.values().map { it.name }) {
            estado = it
        }

        DropdownSelector("Valoración", valoracion, Valoracion.values().map { it.name }) {
            valoracion = it
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                onSubmit(
                    SerieEntity(
                        id = initialSerie?.id ?: 0,
                        titulo = titulo,
                        plataforma = plataforma,
                        estado = Estado.valueOf(estado),
                        valoracion = Valoracion.valueOf(valoracion)
                    )
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar")
        }
    }
}

@Composable
fun DropdownSelector(
    label: String,
    selected: String,
    options: List<String>,
    onSelect: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(label)
        Box {
            OutlinedButton(onClick = { expanded = true }) {
                Text(selected)
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                options.forEach {
                    DropdownMenuItem(text = { Text(it) }, onClick = {
                        onSelect(it)
                        expanded = false
                    })
                }
            }
        }
    }
}
