package br.com.enzoteles.lafiesta

import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.lafiestasdk.webservice.api.FourSquareApi
import br.com.lafiestasdk.webservice.domain.FourSquareJson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class HomeFragment: HelpFragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater!!.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var data: MutableLiveData<FourSquareJson>?=  MutableLiveData<FourSquareJson>()
        val api = FourSquareApi("-23.5428633,-46.8824385")
        api.consultarNight()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe ({ response ->
                    data?.value = response as FourSquareJson?
                    Log.i("data>>> ", "${data?.value?.response?.venues!![0].name}")
                }, { e ->
                    e.printStackTrace()
                })
    }

}