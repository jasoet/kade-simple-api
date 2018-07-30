package id.jasoet.kade.app.view

import id.jasoet.kade.app.api.model.Team
import id.jasoet.kade.app.presenter.Presenter

interface MainView {
    fun initializeView(presenter: Presenter)
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}
