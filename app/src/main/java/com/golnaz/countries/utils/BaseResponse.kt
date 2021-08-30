package com.golnaz.countries.utils

sealed class BaseResponse<out T> {
    object Loading : BaseResponse<Nothing>()


    data class Success<out T>(
        val value: T
    ) : BaseResponse<T>()

    data class Fail(
        val error: Throwable
    ) : BaseResponse<Nothing>()

    val isLoading get() = this is Loading
    val isFail get() = (this as? Fail)?.error
    val valueOrNull get() = (this as? Success)?.value
}