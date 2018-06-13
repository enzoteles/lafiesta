package br.com.enzoteles.lafiesta

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.enzoteles.quickhelp.security.HelpSecurity

class SplashFragment: HelpFragment(){

    lateinit var home: HomeFragment
    lateinit var splash: SplashFragment

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater!!.inflate(R.layout.fragment_splash, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        home = HomeFragment()
        splash = SplashFragment()


        Handler().postDelayed({
            //doSomethingHere()
            activity.runOnUiThread {
                HelpSecurity.manager!!.replaceFragment(R.id.content, home, "home", false)
            }
        }, 2000)
    }
}