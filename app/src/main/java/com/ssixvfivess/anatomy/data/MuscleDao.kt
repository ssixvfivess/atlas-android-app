package com.ssixvfivess.anatomy.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MuscleDao {
    @Query("SELECT * FROM muscles WHERE bodyPartId = :bodyPartId ORDER BY buttonNumber")
    fun getMusclesByBodyPart(bodyPartId: Int): List<MuscleEntity>

    @Insert
    fun insertAll(muscles: List<MuscleEntity>)
}
