package com.ssixvfivess.anatomy.data

class MuscleRepository(private val muscleDao: MuscleDao) {
    fun getMusclesForBodyPart(bodyPartId: Int): List<MuscleModel> {
        return muscleDao.getMusclesByBodyPart(bodyPartId).toMuscleModelList()
    }
}
