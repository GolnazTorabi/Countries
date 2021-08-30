package com.golnaz.countries.utils.coroutinesExt

interface UseCaseResponse<Type> {

    suspend fun onSuccess(result: Type)

    suspend fun onError(apiError: ApiError?)

}
