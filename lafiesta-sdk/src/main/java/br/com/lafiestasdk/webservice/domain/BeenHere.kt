package br.com.lafiestasdk.webservice.domain


data class BeenHere(
    val count: Int,
    val lastCheckinExpiredAt: Int,
    val marked: Boolean,
    val unconfirmedCount: Int
)