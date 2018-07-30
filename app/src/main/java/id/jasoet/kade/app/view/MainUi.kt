package id.jasoet.kade.app.view

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Spinner
import id.jasoet.kade.app.MainActivity
import id.jasoet.kade.app.R
import id.jasoet.kade.app.R.color.colorAccent
import id.jasoet.kade.app.api.model.Team
import id.jasoet.kade.app.extension.invisible
import id.jasoet.kade.app.extension.visible
import id.jasoet.kade.app.presenter.Presenter
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.centerHorizontally
import org.jetbrains.anko.dip
import org.jetbrains.anko.leftPadding
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.progressBar
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.resources
import org.jetbrains.anko.rightPadding
import org.jetbrains.anko.sdk25.coroutines.onItemSelectedListener
import org.jetbrains.anko.spinner
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout
import org.jetbrains.anko.topPadding
import org.jetbrains.anko.wrapContent

class MainUi : AnkoComponent<MainActivity>, MainView {

    private lateinit var listTeam: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var spinner: Spinner
    private lateinit var leagueName: String
    private lateinit var mainAdapter: MainAdapter
    private lateinit var presenter: Presenter
    private val mutableData = ArrayList<Team>()

    override fun initializeView(presenter: Presenter) {
        this.presenter = presenter
        this.mainAdapter = MainAdapter(mutableData)
    }

    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            topPadding = dip(16)
            leftPadding = dip(16)
            rightPadding = dip(16)

            spinner = spinner {
                val spinnerItems = ui.resources.getStringArray(R.array.league)
                val spinnerAdapter = ArrayAdapter(ui.ctx, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
                adapter = spinnerAdapter

                onItemSelectedListener {
                    onItemSelected { _, _, _, _ ->
                        leagueName = spinner.selectedItem.toString()
                        presenter.presentTeamList(leagueName)
                    }
                    onNothingSelected {}
                }
            }

            swipeRefresh = swipeRefreshLayout {
                setColorSchemeResources(colorAccent,
                        android.R.color.holo_green_light,
                        android.R.color.holo_orange_light,
                        android.R.color.holo_red_light)

                onRefresh {
                    presenter.presentTeamList(leagueName)
                }

                relativeLayout {
                    lparams(width = matchParent, height = wrapContent)

                    listTeam = recyclerView {
                        lparams(width = matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(ctx)
                        adapter = mainAdapter
                    }

                    progressBar = progressBar {
                    }.lparams {
                        centerHorizontally()
                    }
                }
            }
        }
    }


    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showTeamList(data: List<Team>) {
        swipeRefresh.isRefreshing = false
        this.mutableData.clear()
        this.mutableData.addAll(data)
        mainAdapter.notifyDataSetChanged()
    }

}