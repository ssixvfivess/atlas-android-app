package com.ssixvfivess.anatomy.data

import com.ssixvfivess.anatomy.domain.MuscleModel

class MuscleRepositoryImpl(private val muscleDao: MuscleDao) {
    fun getMusclesForBodyPart(bodyPartId: Int): List<MuscleModel> {
        return muscleDao.getMusclesByBodyPart(bodyPartId).toMuscleModelList()
    }
}
