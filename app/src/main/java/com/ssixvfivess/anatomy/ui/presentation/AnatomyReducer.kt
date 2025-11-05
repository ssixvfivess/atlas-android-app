package com.ssixvfivess.anatomy.ui.presentation

import com.ssixvfivess.anatomy.domain.MuscleModel
import jakarta.inject.Inject

class AnatomyReducer @Inject() constructor() :
    Reducer<ScreenState<List<MuscleModel>>, InternalActions> {

    override fun reduce(
        currentState: ScreenState<List<MuscleModel>>,
        action: InternalActions
    ): ScreenState<List<MuscleModel>> {
        return when (action) {
            is InternalActions.LoadData -> {
                ScreenState.Content(action.information)
            }

            is InternalActions.LoadFailed -> {
                ScreenState.Error(action.error.message ?: "Unknown error")
            }
        }
    }
}