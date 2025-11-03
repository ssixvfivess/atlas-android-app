package com.ssixvfivess.anatomy.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CoroutineDispatchersImpl @Inject constructor() : CoroutineDispatchers
{
    override fun main(): CoroutineDispatcher = Dispatchers.Main
    override fun io(): CoroutineDispatcher = Dispatchers.IO
    override fun default(): CoroutineDispatcher = Dispatchers.Default
    override fun mainImmediate(): CoroutineDispatcher = Dispatchers.Main.immediate
    override fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined
}
