package com.ssixvfivess.anatomy.domain

interface MuscleRepository {
    suspend fun getMusclesForBodyPart(bodyPartId: Int): List<MuscleModel>
}
