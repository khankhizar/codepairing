package com.example.codepairing.remote.Util

import com.example.codepairing.remote.TempDataModel

sealed class ApiState {
    object Loading : ApiState()
    class Success(val data: TempDataModel): ApiState()
    class Failure(val msg: Throwable): ApiState()
    object Empty : ApiState()
}