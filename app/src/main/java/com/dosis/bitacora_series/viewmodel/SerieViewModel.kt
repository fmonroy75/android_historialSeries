package com.dosis.bitacora_series.viewmodel

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.dosis.bitacora_series.data.SerieRepository
import com.dosis.bitacora_series.data.database.AppDatabase

import com.dosis.bitacora_series.data.entitys.SerieEntity
import kotlinx.coroutines.launch
class SerieViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "bitacora.db"
    ).build()

    private val dao = db.seriesDao()

    val allSeries: LiveData<List<SerieEntity>> = dao.getAll()

    fun addSerie(serie: SerieEntity) {
        viewModelScope.launch {
            dao.insert(serie)
        }
    }
}
