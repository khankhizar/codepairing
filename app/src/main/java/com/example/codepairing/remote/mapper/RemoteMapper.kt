package com.example.codepairing.remote.mapper

interface RemoteMapper< M, E> {
    fun mapFromModel(type : M) : E
}