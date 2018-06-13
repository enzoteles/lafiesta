package br.com.lafiestasdk.webservice.api

import br.com.lafiestasdk.webservice.domain.FourSquareJson
import io.reactivex.Observable

class FourSquareApi(var latLong: String): BaseApi(){

    /**
     * método para pegar a latitute e longitute do usuário
     * */
    fun consultarNight(): Observable<FourSquareJson> {
        return service.getLocation(latLong)
    }
}