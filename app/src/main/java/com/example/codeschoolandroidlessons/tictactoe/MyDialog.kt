package com.example.codeschoolandroidlessons.tictactoe

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.os.Message
import com.example.codeschoolandroidlessons.databinding.ActivityTicTacToeGameBinding
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
    }
}