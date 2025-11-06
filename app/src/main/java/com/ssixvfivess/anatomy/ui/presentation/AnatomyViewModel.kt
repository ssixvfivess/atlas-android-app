package com.ssixvfivess.anatomy.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssixvfivess.anatomy.domain.MuscleModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AnatomyViewModel @Inject constructor(
    private val actor: Actor,
    private val reducer: AnatomyReducer
) : ViewModel() {
    private val _state = MutableStateFlow<ScreenState<List<MuscleModel>>>(ScreenState.Loading)
    val state: StateFlow<ScreenState<List<MuscleModel>>> = _state.asStateFlow()

    fun onAction(action: Action) {
        viewModelScope.launch {
            actor(action).collect { internalActions ->
                val newState = reducer.reduce(_state.value, internalActions)
                _state.value = newState
            }
        }
    }
}