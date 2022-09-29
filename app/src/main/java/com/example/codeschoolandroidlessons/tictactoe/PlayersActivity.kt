package com.example.codeschoolandroidlessons.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.codeschoolandroidlessons.MainActivity
import com.example.codeschoolandroidlessons.databinding.ActivityPlayersBinding
import com.example.codeschoolandroidlessons.databinding.ActivityTicTacToeGameBinding

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
                intent.putExtra("firstPlayer", firstPlayerName)
                intent.putExtra("secondPlayer", secondPlayerName)
                startActivity(intent)
            }
        }
    }
}