package com.example.codeschoolandroidlessons.tictactoe

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
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
            System.out
        }
        binding.changeNamesButton.setOnClickListener {
            val intent = Intent(ticTacToeGameActivity, PlayersActivity::class.java)
            ticTacToeGameActivity.replay()
            ticTacToeGameActivity.startActivity(intent)
            dismiss()
        }
    }

}