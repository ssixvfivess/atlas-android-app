package com.ssixvfivess.anatomy.ui.presentation

import com.ssixvfivess.anatomy.domain.MuscleModel

sealed interface InternalActions {
    data class LoadData(val information: List<MuscleModel>) : InternalActions
    data class LoadFailed(val error: Exception) : InternalActions
}