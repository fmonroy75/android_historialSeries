package com.dosis.bitacora_series.data.database

import androidx.room.TypeConverter
import com.dosis.bitacora_series.data.entitys.Estado
import com.dosis.bitacora_series.data.entitys.Valoracion


class Converters {
    @TypeConverter
    fun fromEstado(value: Estado): String = value.name

    @TypeConverter
    fun toEstado(value: String): Estado = Estado.valueOf(value)

    @TypeConverter
    fun fromValoracion(value: Valoracion): String = value.name

    @TypeConverter
    fun toValoracion(value: String): Valoracion = Valoracion.valueOf(value)


}
