package com.ssixvfivess.anatomy.ui.presentation

interface Reducer<State, Action> {
    fun reduce(currentState: State, action: Action): State
}