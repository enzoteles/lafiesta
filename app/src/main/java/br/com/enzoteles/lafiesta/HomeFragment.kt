package br.com.enzoteles.lafiesta

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.arch.lifecycle.ViewModelStoreOwner
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.enzoteles.quickhelp.log.HelpLog
import br.com.enzoteles.quickhelp.security.HelpSecurity
import br.com.lafiestasdk.gps.GPSTracker
import br.com.lafiestasdk.webservice.api.FourSquareApi
import br.com.lafiestasdk.webservice.domain.FourSquareJson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment: HelpFragment(){

    var viewModel: HomeViewModel?= null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater!!.inflate(R.layout.fragment_home, container, false)
        return view
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(activity as FragmentActivity).get(HomeViewModel::class.java)

        initSplash()
        initGPS()
        initUI()
    }

    /**
     * method to start splash and set visibility in home layout
     * */
    private fun initSplash() {

        Handler().postDelayed({
            ll_splash.visibility = View.GONE
            ll_home.visibility = View.VISIBLE
        }, 3000)
    }

    /**
     * method to start GSP
     */
    @RequiresApi(Build.VERSION_CODES.M)
    private fun initGPS() {
       viewModel?.initGPS(activity.baseContext)
    }

    /**
     * method to start UI
     * */
    private fun initUI() {


        var data: MutableLiveData<FourSquareJson>?=  MutableLiveData<FourSquareJson>()
        var latlng = "${viewModel?.getLatitude()},${viewModel?.getLogintude()}"

        HelpLog.info("${viewModel?.getLatitude()} -- ${viewModel?.getLogintude()}")
        val api = FourSquareApi(latlng)
        api.consultarNight()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe ({ response ->
                    data?.value = response as FourSquareJson?
                    Log.i("data teste>>> ", "${data?.value?.response?.venues!![0].name}")
                }, { e ->
                    e.printStackTrace()
                })
    }



}