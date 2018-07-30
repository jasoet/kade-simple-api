package id.jasoet.kade.app.api

import id.jasoet.kade.app.BuildConfig


object TheSportDBApi {
    fun getTeams(league: String?): String {
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/search_all_teams.php?l=" + league
    }
}