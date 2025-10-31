package com.ssixvfivess.anatomy.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executors

object DataBaseProvider {
    private var instance: AnatomyDatabase? = null

    private val PREPOPULATE_DATA = listOf(
        MuscleEntity(
            id = 1,
            bodyPartId = 1,
            buttonNumber = 1,
            laName = "M. masseter",
            ruName = "Жевательная мышца",
            topography = "Расположена на боковой поверхности...",
            function = "Поднимает нижнюю челюсть..."
        ),
        MuscleEntity(
            id = 2,
            bodyPartId = 1,
            buttonNumber = 2,
            laName = "M. temporalis",
            ruName = "Височная мышца",
            topography = "Заполняет височную ямку...",
            function = "Поднимает нижнюю челюсть..."
        ),
        MuscleEntity(
            id = 3,
            bodyPartId = 2,
            buttonNumber = 1,
            laName = "M. trapezius",
            ruName = "Трапециевидная мышца",
            topography = "Лежит поверхностно в области...",
            function = "Поднимает и притягивает лопатку..."
        )
    )

    private val roomCallBack = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Executors.newSingleThreadExecutor().execute {
                instance?.muscleDao()?.insertAll(PREPOPULATE_DATA)
            }
        }
    }

    fun getDatabase(context: Context): AnatomyDatabase {
        return instance ?: synchronized(this) {
            val db = Room.databaseBuilder(
                context.applicationContext,
                AnatomyDatabase::class.java,
                "anatomy_database.db"
            )
                .addCallback(roomCallBack)
                .build()
            instance = db
            db
        }
    }
}
