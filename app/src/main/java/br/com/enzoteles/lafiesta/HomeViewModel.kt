package br.com.enzoteles.lafiesta

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import android.content.Context
import br.com.enzoteles.quickhelp.log.HelpLog
import br.com.lafiestasdk.gps.GPSTracker

class HomeViewModel : ViewModel(){

    lateinit var mGPS: GPSTracker

    fun initGPS(context: Context){
        mGPS = GPSTracker(context)
        if(mGPS.canGetLocation()){
            mGPS.getLocation()
        }else{
            HelpLog.error("Unabletofind")
        }
    }

    fun getLatitude(): Double{
        return mGPS.getLatitude()
    }

    fun getLogintude(): Double{
        return mGPS.getLongitude()
    }
}