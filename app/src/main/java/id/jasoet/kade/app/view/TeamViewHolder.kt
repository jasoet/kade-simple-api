package id.jasoet.kade.app.view

import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import id.jasoet.kade.app.api.model.Team

class TeamViewHolder(val view: View, private val teamUi: TeamUI) : RecyclerView.ViewHolder(view) {

    fun bindItem(teams: Team) {
        Picasso.get().load(teams.teamBadge).into(teamUi.teamBadge)
        teamUi.teamName.text = teams.teamName
    }
}
