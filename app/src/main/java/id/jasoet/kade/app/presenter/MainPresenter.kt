package id.jasoet.kade.app.presenter

import id.jasoet.kade.app.api.repository.ApiRepository
import id.jasoet.kade.app.view.MainView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository) : Presenter {

    init {
        view.bindPresenter(this)
    }

    override fun presentTeamList(league: String) {
        view.showLoading()

        doAsync {
            val team = apiRepository.getTeam(league)
            uiThread {
                view.hideLoading()
                view.showTeamList(team)
            }
        }
    }
}

