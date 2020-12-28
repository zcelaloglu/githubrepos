package com.celaloglu.zafer.features.repos

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.celaloglu.zafer.R

class ReposActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repos)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.title != getString(R.string.add_to_bookmark) &&
            item.title != getString(R.string.remove_from_bookmark))
            onBackPressed()
        return false
    }

}
