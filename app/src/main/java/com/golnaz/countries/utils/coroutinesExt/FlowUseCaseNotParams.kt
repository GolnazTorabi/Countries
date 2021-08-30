package com.golnaz.countries.utils.coroutinesExt

import kotlinx.coroutines.*

abstract class FlowUseCaseNotParams<Type> where Type : Any {

    abstract suspend fun run(): Type


    fun invoke(scope: CoroutineScope, onResult: UseCaseResponse<Type>?) {

        scope.launch {
            try {
                val result = run()
                onResult?.onSuccess(result)
            } catch (e: CancellationException) {
                e.printStackTrace()
                onResult?.onError(traceErrorException(e))
            } catch (e: Exception) {
                e.printStackTrace()
                onResult?.onError(traceErrorException(e))
            }
        }
    }

}