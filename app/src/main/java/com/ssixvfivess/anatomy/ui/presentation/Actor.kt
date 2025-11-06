package com.ssixvfivess.anatomy.ui.presentation

import com.ssixvfivess.anatomy.domain.GetMuscleUseCase
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.CancellationException

class Actor @Inject constructor(
    private val useCase: GetMuscleUseCase,
) : (Action) -> Flow<InternalActions> {

    override fun invoke(action: Action): Flow<InternalActions> = when (action) {
        is Action.LoadInformation ->
            flow<InternalActions> {
                val result = useCase(bodyPartId = action.bodyPartId)
                emit(InternalActions.LoadData(result))
            }
                .catch { e ->
                    if (e is CancellationException) throw e
                    emit(InternalActions.LoadFailed(e as? Exception ?: RuntimeException(e)))
                }
                .flowOn(Dispatchers.IO)

    }
}