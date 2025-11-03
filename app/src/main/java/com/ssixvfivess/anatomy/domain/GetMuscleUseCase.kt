package com.ssixvfivess.anatomy.domain

import javax.inject.Inject


interface GetMuscleUseCase {
    suspend operator fun invoke(bodyPartId: Int): List<MuscleModel>
}


class GetMuscleUseCaseImpl @Inject constructor(
    private val repository: MuscleRepository
) : GetMuscleUseCase {
    override suspend fun invoke(bodyPartId: Int): List<MuscleModel> {
        return repository.getMusclesForBodyPart(bodyPartId)
    }
}