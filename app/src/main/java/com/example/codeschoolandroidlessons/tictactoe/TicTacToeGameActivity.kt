package com.example.codeschoolandroidlessons.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.ActivityMainBinding
import com.example.codeschoolandroidlessons.databinding.ActivityTicTacToeGameBinding

class TicTacToeGameActivity : AppCompatActivity() {

    private var combinationsList: MutableList<IntArray> = mutableListOf()
    var boxPositions = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var playerTurn = 1
    var totalSelectedBoxes = 1


    private lateinit var binding: ActivityTicTacToeGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicTacToeGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        combinationsList.add(intArrayOf(0, 1, 2))
        combinationsList.add(intArrayOf(3, 4, 5))
        combinationsList.add(intArrayOf(6, 7, 8))
        combinationsList.add(intArrayOf(0, 3, 6))
        combinationsList.add(intArrayOf(1, 4, 7))
        combinationsList.add(intArrayOf(2, 5, 8))
        combinationsList.add(intArrayOf(2, 4, 6))
        combinationsList.add(intArrayOf(0, 4, 8))

        val firstPlayerName = intent.getStringExtra("firstPlayer")
        val secondPlayerName = intent.getStringExtra("secondPlayer")

        binding.TextViewPlayerOne.text = firstPlayerName
        binding.TextViewPlayerTwo.text = secondPlayerName

        binding.imageview1.setOnClickListener { p0 ->
            if (isSelected(0)) {
                performAction(p0 as ImageView, 0)
            }
        }

        binding.imageview2.setOnClickListener { p0 ->
            if (isSelected(1)) {
                performAction(p0 as ImageView, 1)
            }
        }
        binding.imageview3.setOnClickListener { p0 ->
            if (isSelected(2)) {
                performAction(p0 as ImageView, 2)
            }
        }

        binding.imageview4.setOnClickListener { p0 ->
            if (isSelected(3)) {
                performAction(p0 as ImageView, 3)
            }
        }
        binding.imageview5.setOnClickListener { p0 ->
            if (isSelected(4)) {
                performAction(p0 as ImageView, 4)
            }
        }

        binding.imageview6.setOnClickListener { p0 ->
            if (isSelected(5)) {
                performAction(p0 as ImageView, 5)
            }
        }
        binding.imageview7.setOnClickListener { p0 ->
            if (isSelected(6)) {
                performAction(p0 as ImageView, 6)
            }
        }

        binding.imageview8.setOnClickListener { p0 ->
            if (isSelected(7)) {
                performAction(p0 as ImageView, 7)
            }
        }
        binding.imageview9.setOnClickListener { p0 ->
            if (isSelected(8)) {
                performAction(p0 as ImageView, 8)
            }
        }
    }

    private fun performAction(imageView: ImageView, selectedPosition: Int) {
        boxPositions[selectedPosition] = playerTurn
        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.x)
            if (winCheck()) {
                val dialog = MyDialog(
                    this@TicTacToeGameActivity,
                    "${binding.TextViewPlayerOne.text} $ has win the match",
                    this@TicTacToeGameActivity
                )
                dialog.setCancelable(false)
                dialog.show()
            } else if (totalSelectedBoxes == 9) {
                val dialog = MyDialog(
                    this@TicTacToeGameActivity,
                    "the result is draw",
                    this@TicTacToeGameActivity
                )
                dialog.setCancelable(false)
                dialog.show()
            } else {
                changePlayerTurn(2)
                totalSelectedBoxes++
            }
        } else {
            imageView.setImageResource(R.drawable.o)
            if (winCheck()) {
                val dialog = MyDialog(
                    this@TicTacToeGameActivity,
                    "${binding.TextViewPlayerTwo.text} $ has win the match",
                    this@TicTacToeGameActivity
                )
                dialog.setCancelable(false)
                dialog.show()
            } else if (selectedPosition == 9) {
                val dialog = MyDialog(
                    this@TicTacToeGameActivity,
                    "the result is draw",
                    this@TicTacToeGameActivity
                )
                dialog.setCancelable(false)
                dialog.show()
            } else {
                changePlayerTurn(1)
                totalSelectedBoxes++
            }
        }
    }

    private fun changePlayerTurn(currentPlayerTurn: Int) {
        playerTurn = currentPlayerTurn
        if (playerTurn == 1) {
            binding.playerOneLayout.setBackgroundResource(R.drawable.round_back_blue_border)
            binding.playerTwoLayout.setBackgroundResource(R.drawable.round_back_dark_blue_border)
        } else {
            binding.playerTwoLayout.setBackgroundResource(R.drawable.round_back_dark_blue_border)
            binding.playerOneLayout.setBackgroundResource(R.drawable.round_back_blue_border)
        }
    }

    private fun winCheck(): Boolean {
        var bool = false
        for (item in 0 until combinationsList.size) {
            val combination = combinationsList[item]
            if (boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn && boxPositions[combination[2]] == playerTurn)
                bool = true
        }
        return bool
    }

    private fun isSelected(position: Int): Boolean {
        var bool = false
        if (boxPositions[position] == 0)
            bool = true
        return bool
    }

    fun replay() {
        boxPositions = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        playerTurn = 1
        totalSelectedBoxes = 1
        binding.imageview1.setBackgroundResource(R.drawable.ic_empty)
        binding.imageview2.setBackgroundResource(R.drawable.ic_empty)
        binding.imageview3.setBackgroundResource(R.drawable.ic_empty)
        binding.imageview4.setBackgroundResource(R.drawable.ic_empty)
        binding.imageview5.setBackgroundResource(R.drawable.ic_empty)
        binding.imageview6.setBackgroundResource(R.drawable.ic_empty)
        binding.imageview7.setBackgroundResource(R.drawable.ic_empty)
        binding.imageview8.setBackgroundResource(R.drawable.ic_empty)
        binding.imageview9.setBackgroundResource(R.drawable.ic_empty)

    }
}