package br.com.lafiestasdk.webservice.api

import br.com.lafiestasdk.webservice.domain.FourSquareJson
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * create by enzo teles
 * */
interface FourSquareApiRest{

    @GET("venues/search?client_id=MHV1VAQWBP5FRT5NP32C54HB0ETBSB1NN4I4HNTETPF15AQ0&client_secret=L2WUP4DAXSPPLDMLDUNUIZZQF4IWJ00J4V4ZLOTUI5GCU2Z0&v=20130815%20&query=night")
    fun getLocation(@Query("ll") latLong: String) : Observable<FourSquareJson>

    //rating
    //https://api.foursquare.com/v2/venues/4b98420af964a520bd3735e3?v=20130815%20&ll=-23.5428633,-46.8824385&client_id=MHV1VAQWBP5FRT5NP32C54HB0ETBSB1NN4I4HNTETPF15AQ0&client_secret=L2WUP4DAXSPPLDMLDUNUIZZQF4IWJ00J4V4ZLOTUI5GCU2Z0&query=stackhouse
    //GET https://api.foursquare.com/v2/venues/VENUE_ID

    //foto
    //https://api.foursquare.com/v2/venues/4b8b14c6f964a520f49132e3/photos?client_id=MHV1VAQWBP5FRT5NP32C54HB0ETBSB1NN4I4HNTETPF15AQ0&client_secret=L2WUP4DAXSPPLDMLDUNUIZZQF4IWJ00J4V4ZLOTUI5GCU2Z0&v=20130815%20
    //GET https://api.foursquare.com/v2/venues/VENUE_ID/photos

}