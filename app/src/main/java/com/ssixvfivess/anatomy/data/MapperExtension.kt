package com.ssixvfivess.anatomy.data

import com.ssixvfivess.anatomy.domain.MuscleModel

fun MuscleEntity.toMuscleModel() : MuscleModel = MuscleModel(
    id = id,
    buttonNumber = buttonNumber,
    laName = laName,
    ruName = ruName,
    topography = topography,
    function = function
)

fun List<MuscleEntity>.toMuscleModelList() = map { it.toMuscleModel() }
