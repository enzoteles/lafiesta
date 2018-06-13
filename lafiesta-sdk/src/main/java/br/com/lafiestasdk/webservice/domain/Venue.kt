package br.com.lafiestasdk.webservice.domain


data class Venue(
        val id: String,
        val name: String,
        val contact: Contact,
        val location: Location,
        val categories: List<Category>,
        val verified: Boolean,
        val stats: Stats,
        val beenHere: BeenHere,
        val hereNow: HereNow,
        val referralId: String,
        val venueChains: List<Any>,
        val hasPerk: Boolean
)