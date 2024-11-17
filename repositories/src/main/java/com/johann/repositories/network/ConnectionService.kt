package com.johann.repositories.network

interface ConnectionService {
    fun isConnectedToInternet(): Boolean
}