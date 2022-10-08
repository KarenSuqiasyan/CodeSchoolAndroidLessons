package com.example.codeschoolandroidlessons.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.codeschoolandroidlessons.databinding.ActivityPlayersBinding

class PlayersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startGameButton.setOnClickListener {
            val firstPlayerName = binding.EditTextFirstPlayer.text.toString()
            val secondPlayerName = binding.EditTextSecondPlayer.text.toString()
            if (firstPlayerName.isEmpty() || secondPlayerName.isEmpty()) {
                Toast.makeText(
                    this@PlayersActivity,
                    "please enter players names",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, TicTacToeGameActivity::class.java)
                intent.putExtra(FIRST_PLAYER, firstPlayerName)
                intent.putExtra(SECOND_PLAYER, secondPlayerName)
                startActivity(intent)
            }
        }
    }

    companion object {
        const val FIRST_PLAYER = "firstPlayer"
        const val SECOND_PLAYER = "secondPlayer"
    }
}