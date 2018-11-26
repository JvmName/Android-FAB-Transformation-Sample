package com.parthpadg.fabanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.action_sheet_fab.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adapter: ColorAdapter = ColorAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        toolbar.title = getString(R.string.title_color, "Default")

        val viewmodel = ViewModelProviders.of(this).get(ColorActionSheetViewModel::class.java)

        recycler.setHasFixedSize(true)
        recycler.adapter = this.adapter


        viewmodel.getColorList()
            .observe(this, Observer { list ->
                adapter.colorList = list
                if (list == ColorActionSheetViewModel.defaultList) {
                    toolbar.title = getString(R.string.title_color, "Default")
                } else {
                    toolbar.title = getString(R.string.title_color, "Sorted")
                }
            })

        ActionSheetMenuHelper(this, fab, fab_menu, fab_scrim)
    }
}
