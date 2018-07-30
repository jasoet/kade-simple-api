package id.jasoet.kade.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.jasoet.kade.app.api.repository.ApiRepository
import id.jasoet.kade.app.presenter.MainPresenter
import id.jasoet.kade.app.view.MainUi
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainUi = MainUi()
        MainPresenter(mainUi, ApiRepository())

        mainUi.setContentView(this)
    }

}