package com.example.codeschoolandroidlessons.tictactoe

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.ViewTictactoeBinding

class TicTacToeView : ConstraintLayout {

    var binding = ViewTictactoeBinding.inflate(LayoutInflater.from(context), this, true)

    private var combinationsList: MutableList<IntArray> = mutableListOf(
        intArrayOf(0, 1, 2),
        intArrayOf(6, 7, 8),
        intArrayOf(3, 4, 5),
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(2, 4, 6),
        intArrayOf(0, 4, 8)
    )
    var boxPositions = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var playerTurn = 1
    var totalSelectedBoxes = 1

    companion object {
        var countX = 0
        var countO = 0
        const val EMPTY_STRING = ""
    }

    private var firstPlayerName: String = EMPTY_STRING
    private var secondPlayerName: String = EMPTY_STRING

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init(attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr) {
        init(attributeSet)
    }


    @SuppressLint("Recycle")
    private fun init(attributeSet: AttributeSet?) {
        attributeSet?.let {
            val a = context.obtainStyledAttributes(attributeSet, R.styleable.TicTacToeView)
            setFirstPlayerName(a.getString(R.styleable.TicTacToeView_firstPlayerName) ?: EMPTY_STRING)
            setSecondPlayerName(a.getString(R.styleable.TicTacToeView_secondPlayerName) ?: EMPTY_STRING)
            a.recycle()
        }
    }

    fun setFirstPlayerName(firstPlayerName: String?) {
        this.firstPlayerName = firstPlayerName ?: EMPTY_STRING
        binding.TextViewFirstPlayer.text = this.firstPlayerName
    }

    fun setSecondPlayerName(secondPlayerName: String?) {
        this.secondPlayerName = secondPlayerName ?: EMPTY_STRING
        binding.TextViewSecondPlayer.text = this.secondPlayerName
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

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

    @SuppressLint("SetTextI18n")
    private fun performAction(imageView: ImageView, selectedPosition: Int) {
        boxPositions[selectedPosition] = playerTurn
        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.ic_cross)
            if (winCheck()) {
                val dialog = MyDialog(
                    context,
                    "${binding.TextViewFirstPlayer.text} has win the match",
                    this
                )
                dialog.setCancelable(false)
                dialog.show()
                countX++
                binding.TextviewScoreX.text = "score $countX"
            } else if (totalSelectedBoxes == 9) {
                val dialog = MyDialog(
                    context,
                    "the result is draw",
                    this
                )
                dialog.setCancelable(false)
                dialog.show()
            } else {
                changePlayerTurn(2)
                totalSelectedBoxes++
            }
        } else {
            imageView.setImageResource(R.drawable.ic_circle)
            if (winCheck()) {
                val dialog = MyDialog(
                    context,
                    "${binding.TextViewSecondPlayer.text} has win the match",
                    this
                )
                dialog.setCancelable(false)
                dialog.show()
                countO++
                binding.TextviewScoreO.text = "score $countX"
            } else if (selectedPosition == 9) {
                val dialog = MyDialog(
                    context,
                    "the result is draw",
                    this
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
            binding.firstPlayerLayout.setBackgroundResource(R.drawable.round_back_blue_border)
            binding.secondPlayerLayout.setBackgroundResource(R.drawable.round_back_dark_blue_border)
        } else {
            binding.secondPlayerLayout.setBackgroundResource(R.drawable.round_back_dark_blue_border)
            binding.firstPlayerLayout.setBackgroundResource(R.drawable.round_back_blue_border)
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
        binding.imageview1.setImageResource(R.drawable.ic_empty)
        binding.imageview2.setImageResource(R.drawable.ic_empty)
        binding.imageview3.setImageResource(R.drawable.ic_empty)
        binding.imageview4.setImageResource(R.drawable.ic_empty)
        binding.imageview5.setImageResource(R.drawable.ic_empty)
        binding.imageview6.setImageResource(R.drawable.ic_empty)
        binding.imageview7.setImageResource(R.drawable.ic_empty)
        binding.imageview8.setImageResource(R.drawable.ic_empty)
        binding.imageview9.setImageResource(R.drawable.ic_empty)

    }

}
