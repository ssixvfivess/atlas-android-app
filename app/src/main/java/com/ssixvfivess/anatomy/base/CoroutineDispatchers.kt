package com.ssixvfivess.anatomy.base

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatchers {

    fun main(): CoroutineDispatcher

    fun default(): CoroutineDispatcher

    fun io(): CoroutineDispatcher

    fun unconfined(): CoroutineDispatcher

    fun mainImmediate(): CoroutineDispatcher

}
