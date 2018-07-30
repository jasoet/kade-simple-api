package id.jasoet.kade.app.main

import id.jasoet.kade.app.model.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}
