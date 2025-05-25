package com.dosis.bitacora_series.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dosis.bitacora_series.data.entitys.SerieEntity



@Dao
interface SerieDao {
    @Query("SELECT * FROM series")
    fun getAll(): LiveData<List<SerieEntity>>

    @Query("SELECT * FROM series WHERE estado IN ('EN_CURSO', 'TERMINADA')")
    fun obtenerParaCalificar(): LiveData<List<SerieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(serie: SerieEntity)

    @Update
    suspend fun update(serie: SerieEntity)

    @Delete
    suspend fun delete(serie: SerieEntity)
}
