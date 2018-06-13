package br.com.enzoteles.lafiesta

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.enzoteles.quickhelp.fragment.HelpManagerFragment
import br.com.enzoteles.quickhelp.security.HelpSecurity
import br.com.lafiestasdk.gps.GPSTracker

class MainActivity : AppCompatActivity() {


    //variable
    lateinit var manager: HelpManagerFragment
    lateinit var home: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI() {

        manager = HelpManagerFragment(this)
        HelpSecurity.manager = manager
        home = HomeFragment()
        manager!!.addFragment(R.id.content, home, "home", false)
    }

}
