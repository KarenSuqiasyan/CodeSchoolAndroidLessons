package com.example.codeschoolandroidlessons.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codeschoolandroidlessons.databinding.ActivityPlayersBinding
import com.example.codeschoolandroidlessons.databinding.ActivityTicTacToeGameBinding

class PlayersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}