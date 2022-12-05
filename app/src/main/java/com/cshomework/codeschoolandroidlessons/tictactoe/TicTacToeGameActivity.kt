package com.cshomework.codeschoolandroidlessons.tictactoe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.common.codeschoolandroidlessons.databinding.ActivityTicTacToeGameBinding
import com.cshomework.codeschoolandroidlessons.tictactoe.PlayersActivity.Companion.FIRST_PLAYER
import com.cshomework.codeschoolandroidlessons.tictactoe.PlayersActivity.Companion.SECOND_PLAYER

class TicTacToeGameActivity : AppCompatActivity() {


    private lateinit var binding: ActivityTicTacToeGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicTacToeGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ticTacToeView.setFirstPlayerName(intent.getStringExtra(FIRST_PLAYER))
        binding.ticTacToeView.setSecondPlayerName(intent.getStringExtra(SECOND_PLAYER))
    }
}