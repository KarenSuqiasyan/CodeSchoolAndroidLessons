package com.example.codeschoolandroidlessons.tictactoe

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.codeschoolandroidlessons.MainActivity
import com.example.codeschoolandroidlessons.databinding.MyDialogLayoutBinding

class MyDialog(context: Context, message: String, ticTacToeView: TicTacToeView) :
    Dialog(context) {

    var massage: String
    private var ticTacToeView: TicTacToeView

    init {
        this.massage = message
        this.ticTacToeView = ticTacToeView
    }

    private lateinit var binding: MyDialogLayoutBinding

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MyDialogLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.messageTextView.text = massage

        binding.replayButton.setOnClickListener {
            ticTacToeView.replay()
            dismiss()
        }
        binding.exitButton.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
            dismiss()
        }
        binding.changeNamesButton.setOnClickListener {
            val intent = Intent(context, PlayersActivity::class.java)
            ticTacToeView.replay()
            TicTacToeView.countX = 0
            TicTacToeView.countO = 0
            context.startActivity(intent)
            dismiss()
        }
        binding.showScoreButton.setOnClickListener {
            val toast = Toast.makeText(
                context,
                "${ticTacToeView.binding.TextViewFirstPlayer.text} - ${TicTacToeView.countX} " +
                        "${ticTacToeView.binding.TextViewSecondPlayer.text} - ${TicTacToeView.countO}",
                Toast.LENGTH_LONG
            )
            toast.show()
        }
    }
}