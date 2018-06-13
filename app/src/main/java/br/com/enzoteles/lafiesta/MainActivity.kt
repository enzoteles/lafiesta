package br.com.enzoteles.lafiesta

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.enzoteles.quickhelp.fragment.HelpManagerFragment
import br.com.enzoteles.quickhelp.security.HelpSecurity

class MainActivity : AppCompatActivity() {


    //variable
    lateinit var splash:SplashFragment
    lateinit var manager: HelpManagerFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manager = HelpManagerFragment(this)
        HelpSecurity.manager = manager
        splash = SplashFragment()
        manager!!.addFragment(R.id.content, splash, "splash", false)
    }
}
