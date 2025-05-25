package com.dosis.bitacora_series.data

import androidx.lifecycle.LiveData
import com.dosis.bitacora_series.data.dao.SerieDao
import com.dosis.bitacora_series.data.entitys.SerieEntity

class SerieRepository(private val serieDao: SerieDao) {

    val allSeries: LiveData<List<SerieEntity>> = serieDao.getAll()

    suspend fun insert(serie: SerieEntity) = serieDao.insert(serie)

    suspend fun update(serie: SerieEntity) = serieDao.update(serie)

    suspend fun delete(serie: SerieEntity) = serieDao.delete(serie)
}
