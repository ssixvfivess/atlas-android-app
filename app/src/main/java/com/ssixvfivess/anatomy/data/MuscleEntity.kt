package com.ssixvfivess.anatomy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "muscles")
data class MuscleEntity(
    @PrimaryKey val id: Int,
    val bodyPartId: Int,
    val buttonNumber: Int,
    val laName: String,
    val ruName: String,
    val topography: String,
    val function: String,
)
