package com.ssixvfivess.anatomy.ui.presentation

sealed interface Action {

    data class LoadInformation(val bodyPartId: Int) : Action
}