package com.dosis.bitacora_series.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dosis.bitacora_series.data.dao.SerieDao

import com.dosis.bitacora_series.data.entitys.SerieEntity

@Database(entities = [SerieEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun seriesDao(): SerieDao
}