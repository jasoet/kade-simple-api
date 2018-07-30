package id.jasoet.kade.app.view

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import id.jasoet.kade.app.R.id.team_name
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.dip
import org.jetbrains.anko.imageView
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.margin
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView
import org.jetbrains.anko.wrapContent

class TeamUI : AnkoComponent<ViewGroup> {
    lateinit var teamBadge: ImageView
    lateinit var teamName: TextView

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                teamBadge = imageView {
                }.lparams {
                    height = dip(50)
                    width = dip(50)
                }

                teamName = textView {
                    id = team_name
                    textSize = 16f
                }.lparams {
                    margin = dip(15)
                }
            }
        }
    }

}

