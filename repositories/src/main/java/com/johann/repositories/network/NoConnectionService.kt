package no.nrk.radio.library.repositories.network

import com.johann.repositories.network.ConnectionService

class NoConnectionService : ConnectionService {
    override fun isConnectedToInternet(): Boolean = true
}