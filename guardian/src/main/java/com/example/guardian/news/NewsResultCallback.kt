package com.example.guardian.news

interface NewsResultCallback<T> {

    fun onSuccess(data: T)

    fun onError(message: String) {}
}