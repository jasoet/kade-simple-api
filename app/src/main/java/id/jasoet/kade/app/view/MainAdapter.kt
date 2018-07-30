package id.jasoet.kade.app.view

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import id.jasoet.kade.app.api.model.Team
import org.jetbrains.anko.AnkoContext

class MainAdapter(private val teams: List<Team>) : RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val context = AnkoContext.create(parent.context, parent)
        val teamUi = TeamUI()
        val view = teamUi.createView(context)
        return TeamViewHolder(view, teamUi)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position])
    }

    override fun getItemCount(): Int = teams.size
}

