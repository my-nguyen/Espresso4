package com.nguyen.espresso4.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nguyen.espresso4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.typeTextButton.setOnClickListener {
            startActivity(Intent(this, EnterNameActivity::class.java))
        }
        binding.spinnerSelectionButton.setOnClickListener {
            startActivity(Intent(this, SpinnerSelectionActivity::class.java))
        }
        binding.customListAdapterButton.setOnClickListener {
            startActivity(Intent(this, CustomListActivity::class.java))
        }
        binding.searchViewButton.setOnClickListener {
            startActivity(Intent(this, SearchViewActivity::class.java))
        }
        binding.actionBarButton.setOnClickListener {
            startActivity(Intent(this, ActionBarExampleActivity::class.java))
        }
        binding.viewpagerButton.setOnClickListener {
            startActivity(Intent(this, ViewPagerActivity::class.java))
        }
        binding.dialogsButton.setOnClickListener {
            startActivity(Intent(this, DialogExampleActivity::class.java))
        }
        binding.recyclerViewButton.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
        binding.pickersButton.setOnClickListener {
            startActivity(Intent(this, DateTimePickerActivity::class.java))
        }
    }
}