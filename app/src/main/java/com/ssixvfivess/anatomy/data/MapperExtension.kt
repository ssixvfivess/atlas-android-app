package com.ssixvfivess.anatomy.data

fun MuscleEntity.toMuscleModel() = MuscleModel(
    id = id,
    buttonNumber = buttonNumber,
    laName = laName,
    ruName = ruName,
    topography = topography,
    function = function
)

fun List<MuscleEntity>.toMuscleModelList() = map { it.toMuscleModel() }
