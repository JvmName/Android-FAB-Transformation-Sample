package com.parthpadg.fabanimation

import android.annotation.SuppressLint
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.transformation.TransformationChildLayout
import kotlinx.android.synthetic.main.action_sheet_fab.view.*

@SuppressLint("RestrictedApi")
class ActionSheetMenuHelper(activity : AppCompatActivity,
                            private val fab : FloatingActionButton,
                            private val actionSheetLayout: TransformationChildLayout,
                            private val scrim: View) : DefaultLifecycleObserver {

    private val viewmodel: ColorActionSheetViewModel

    init {
        viewmodel = ViewModelProviders.of(activity).get(ColorActionSheetViewModel::class.java)
        activity.lifecycle.addObserver(this)

        val collapseClick: View.OnClickListener = View.OnClickListener { collapse() }

        fab.setOnClickListener { fab.isExpanded = true }

        scrim.setOnClickListener(collapseClick)
        actionSheetLayout.fab_menu_bottom.setOnClickListener(collapseClick)

        actionSheetLayout.fab_menu_default.setOnClickListener {
            viewmodel.setColorListDefault()
            collapse()
        }

        actionSheetLayout.fab_menu_random.setOnClickListener {
            viewmodel.setColorListRandom()
            collapse()
        }
    }

    override fun onDestroy(owner: LifecycleOwner) {
        fab.setOnClickListener(null)
        scrim.setOnClickListener(null)
        actionSheetLayout.fab_menu_bottom.setOnClickListener(null)
        actionSheetLayout.fab_menu_default.setOnClickListener(null)
        actionSheetLayout.fab_menu_random.setOnClickListener(null)
    }

    private fun collapse() {
        fab.isExpanded = false
    }
}

