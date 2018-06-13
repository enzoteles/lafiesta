package br.com.lafiestasdk.webservice.domain


data class Location(
        val lat: Double,
        val lng: Double,
        val labeledLatLngs: List<LabeledLatLng>,
        val distance: Int,
        val cc: String,
        val country: String,
        val formattedAddress: List<String>
)