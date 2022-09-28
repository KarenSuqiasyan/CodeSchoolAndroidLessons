package com.example.codeschoolandroidlessons.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.codeschoolandroidlessons.databinding.ActivityMainBinding
import com.example.codeschoolandroidlessons.databinding.ActivityTicTacToeGameBinding

class TicTacToeGameActivity : AppCompatActivity() {

    var combinationsList: MutableList<List<Int>> = mutableListOf()
    var boxPositions = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var playerTurn = 1
    var totalSelectedBoxes = 1


    private lateinit var binding: ActivityTicTacToeGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicTacToeGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playerOneLayout.setOnClickListener {  }
    }
}