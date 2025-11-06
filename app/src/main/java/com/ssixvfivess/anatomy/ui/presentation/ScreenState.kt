package com.ssixvfivess.anatomy.ui.presentation

import com.ssixvfivess.anatomy.domain.MuscleModel

data class AnatomyUiMode(
    val information: List<MuscleModel>
)

sealed class ScreenState<out T> {
    data class Content<out T>(val data: T) : ScreenState<T>()
    data object Loading : ScreenState<Nothing>()
    data class Error(val message: String) : ScreenState<Nothing>()
}