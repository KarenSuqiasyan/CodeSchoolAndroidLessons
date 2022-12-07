package com.cshomework.codeschoolandroidlessons.pickers_and_menues

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.common.codeschoolandroidlessons.R
import com.common.codeschoolandroidlessons.databinding.ActivityPickerAndMenuBinding

class PickerAndMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPickerAndMenuBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPickerAndMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getDateButton.setOnClickListener {
            binding.getDateTextView.text = "Selected Date: ${binding.datePicker.dayOfMonth} ${binding.datePicker.month} ${binding.datePicker.year}"
        }
        binding.getTimeButton.setOnClickListener {
            binding.getTimeTextView.text = "Selected Time: ${binding.timePicker.hour} ${binding.timePicker.minute}"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.calendar -> {
                binding.datePicker.isVisible = true
                binding.getDateButton.isVisible = true
            }
            R.id.time -> {
                binding.timePicker.isVisible = true
                binding.getTimeButton.isVisible = true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}