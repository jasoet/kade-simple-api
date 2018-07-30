package id.jasoet.kade.app.api.repository

import com.google.gson.Gson
import id.jasoet.kade.app.BuildConfig
import id.jasoet.kade.app.api.model.Team
import id.jasoet.kade.app.api.model.TeamResponse
import java.net.URL

class ApiRepository {
    private val gson = Gson()

    fun getTeam(league: String): List<Team> {
        val url = BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/search_all_teams.php?l=" + league
        val jsonString = URL(url).readText()
        return gson.fromJson(jsonString, TeamResponse::class.java).teams
    }

}