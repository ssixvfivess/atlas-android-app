package com.ssixvfivess.anatomy.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class) // Говорим, как запускать этот тест
class AnatomyDatabaseTest {

    private lateinit var muscleDao: MuscleDao
    private lateinit var db: AnatomyDatabase

    // --- 1. Настройка ---
    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        // Создаем БД в памяти, а не в файле
        db = Room.inMemoryDatabaseBuilder(
            context, AnatomyDatabase::class.java
        )
            // Разрешаем выполнять запросы в главном потоке (ТОЛЬКО ДЛЯ ТЕСТОВ!)
            .allowMainThreadQueries()
            .build()

        muscleDao = db.muscleDao()
    }

    // --- 3. Очистка ---
    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    // --- 2. Сам тест ---
    @Test
    @Throws(Exception::class)
    fun insertAndReadMuscle() = runBlocking { // Используем runBlocking для suspend-функций

        // 1. Подготовка данных
        val testMuscle = MuscleEntity(
            id = 1,
            bodyPartId = 1, // Голова
            buttonNumber = 1,
            laName = "M. masseter",
            ruName = "Жевательная мышца",
            topography = "...",
            function = "..."
        )

        // 2. Действие: Вставляем данные
        muscleDao.insertAll(listOf(testMuscle))

        // 3. Проверка: Читаем данные обратно
        val musclesFromDb = muscleDao.getMusclesByBodyPart(1)

        // 4. Утверждение: Проверяем, что данные верны
        assertTrue("Список не должен быть пустым", musclesFromDb.isNotEmpty())
        assertEquals("Имена должны совпадать", "Жевательная мышца", musclesFromDb[0].ruName)
        assertEquals("ID части тела должен совпадать", 1, musclesFromDb[0].bodyPartId)
    }
}