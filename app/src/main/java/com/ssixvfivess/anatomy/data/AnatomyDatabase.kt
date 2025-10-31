package com.ssixvfivess.anatomy.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [MuscleEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AnatomyDatabase : RoomDatabase() {
    abstract fun muscleDao(): MuscleDao
}
