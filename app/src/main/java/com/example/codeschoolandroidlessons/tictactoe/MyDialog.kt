package com.example.codeschoolandroidlessons.tictactoe

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.codeschoolandroidlessons.MainActivity
import com.example.codeschoolandroidlessons.databinding.MyDialogLayoutBinding

class MyDialog(context: Context, message: String, ticTacToeGameActivity: TicTacToeGameActivity) :
    Dialog(context) {

    var massage: String
    var ticTacToeGameActivity: TicTacToeGameActivity

    init {
        this.massage = message
        this.ticTacToeGameActivity = ticTacToeGameActivity
    }

    private lateinit var binding: MyDialogLayoutBinding

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MyDialogLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.messageTextView.text = massage

        binding.replayButton.setOnClickListener {
            ticTacToeGameActivity.replay()
            dismiss()
        }
        binding.exitButton.setOnClickListener {
            val intent = Intent(ticTacToeGameActivity, MainActivity::class.java)
            ticTacToeGameActivity.startActivity(intent)
            dismiss()

        }
        binding.changeNamesButton.setOnClickListener {
            val intent = Intent(ticTacToeGameActivity, PlayersActivity::class.java)
            ticTacToeGameActivity.replay()
            ticTacToeGameActivity.startActivity(intent)
            dismiss()
        }
        binding.showScoreButton.setOnClickListener {
            val toast = Toast.makeText(
                ticTacToeGameActivity,
                "X score - ${TicTacToeGameActivity.countX} O score - ${TicTacToeGameActivity.countO}",
                Toast.LENGTH_LONG
            )
            toast.show()
        }
    }
}