package com.nguyen.espresso4.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import com.nguyen.espresso4.R
import com.nguyen.espresso4.databinding.ActivityActionBarExampleBinding

class ActionBarExampleActivity : AppCompatActivity() {
    private var actionMode: ActionMode? = null
    private lateinit var binding: ActivityActionBarExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActionBarExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toggleActionMode.setOnClickListener {
            if (actionMode == null) {
                actionMode = startSupportActionMode(actionModeCallbacks)
            }
        }
    }

    private val actionModeCallbacks = object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            actionMode?.menuInflater?.inflate(R.menu.context_menu, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?) = true

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            when (item?.itemId) {
                R.id.action_one -> {
                    binding.status.setText(R.string.action_mode_one)
                    return true
                }
            }
            return false
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            this@ActionBarExampleActivity.actionMode = null
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_action_bar_example, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> binding.status.setText(R.string.action_settings)
            R.id.action_about -> binding.status.setText(R.string.action_about)
        }
        return super.onOptionsItemSelected(item)
    }
}