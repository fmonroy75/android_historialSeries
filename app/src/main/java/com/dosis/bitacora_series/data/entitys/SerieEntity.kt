package com.dosis.bitacora_series.data.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "series")
data class SerieEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String,
    val plataforma: String,
    val estado: Estado,
    val valoracion: Valoracion
)

enum class Plataforma {
    NETFLIX, HBO, DISNEY, AMAZON, PARAMOUNT
}

enum class Estado {
    FINALIZADA, EN_CURSO, DESEADA
}

enum class Valoracion {
    MALA, REGULAR, BUENA, MUY_BUENA, EXCELENTE
}
