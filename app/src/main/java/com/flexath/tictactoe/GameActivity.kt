package com.flexath.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() , View.OnClickListener {

    private var matrix:ArrayList<ArrayList<String>> = arrayListOf(arrayListOf(" "," "," "),arrayListOf(" "," "," "),arrayListOf(" "," "," "))

    private var playerOneMarks = 0
    private var playerTwoMarks = 0
    private var playerDrawMarks = 0

    private var playerOneTurn:Boolean = true
    private var turn:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_game)

        btnOne.setOnClickListener(this)
        btnTwo.setOnClickListener(this)
        btnThree.setOnClickListener(this)
        btnFour.setOnClickListener(this)
        btnFive.setOnClickListener(this)
        btnSix.setOnClickListener(this)
        btnSeven.setOnClickListener(this)
        btnEight.setOnClickListener(this)
        btnNine.setOnClickListener(this)

        btnReset.setOnClickListener {
            resetGame()
        }

    }

   private fun checkWinner() : Boolean {

        if ((matrix[0][0] == "X" && matrix[0][1] == "X" && matrix[0][2] == "X") ||
            (matrix[0][0] == "X" && matrix[1][0] == "X" && matrix[2][0] == "X") ||
            (matrix[0][2] == "X" && matrix[1][2] == "X" && matrix[2][2] == "X") ||
            (matrix[2][0] == "X" && matrix[2][1] == "X" && matrix[2][2] == "X") ||
            (matrix[0][0] == "X" && matrix[1][1] == "X" && matrix[2][2] == "X") ||
            (matrix[0][2] == "X" && matrix[1][1] == "X" && matrix[2][0] == "X") ||
            (matrix[0][1] == "X" && matrix[1][1] == "X" && matrix[2][1] == "X") ||
            (matrix[1][0] == "X" && matrix[1][1] == "X" && matrix[1][2] == "X")) {
            playerOneMarks = playerOneMarks.plus(1)
            playerOneScore.text = playerOneMarks.toString()
            Toast.makeText(this, "Player One Won !", Toast.LENGTH_SHORT).show()
            return true
        }
        else if ((matrix[0][0] == "O" && matrix[0][1] == "O" && matrix[0][2] == "O") ||
            (matrix[0][0] == "O" && matrix[1][0] == "O" && matrix[2][0] == "O") ||
            (matrix[0][2] == "O" && matrix[1][2] == "O" && matrix[2][2] == "O") ||
            (matrix[2][0] == "O" && matrix[2][1] == "O" && matrix[2][2] == "O") ||
            (matrix[0][0] == "O" && matrix[1][1] == "O" && matrix[2][2] == "O") ||
            (matrix[0][2] == "O" && matrix[1][1] == "O" && matrix[2][0] == "O") ||
            (matrix[0][1] == "O" && matrix[1][1] == "O" && matrix[2][1] == "O") ||
            (matrix[1][0] == "O" && matrix[1][1] == "O" && matrix[1][2] == "O")
        ) {
            playerTwoMarks = playerTwoMarks.plus(1)
            playerTwoScore.text = playerTwoMarks.toString()
            Toast.makeText(this, "Player Two Won !", Toast.LENGTH_SHORT).show()
            return true
        }
        else{
            turn++
            return false
        }
    }

    private fun clearGrid() {
        btnOne.text = ""
        btnTwo.text = ""
        btnThree.text = ""
        btnFour.text = ""
        btnFive.text = ""
        btnSix.text = ""
        btnSeven.text = ""
        btnEight.text = ""
        btnNine.text = ""
        for(i in 0..2) {
            for(j in 0..2) {
                matrix[i][j] = ""
            }
        }
        turn = 0
    }

    private fun score() {
        if(checkWinner()) {
            clearGrid()
        }else{
            if(turn == 9 && !checkWinner()) {
                playerDrawMarks = playerDrawMarks.plus(1)
                playerDrawScore.text = playerDrawMarks.toString()
                clearGrid()
            }
        }
    }

    private fun resetGame() {
        val resetScore = 0
        clearGrid()
        playerOneMarks = 0
        playerTwoMarks = 0
        playerDrawMarks = 0
        playerOneScore.text = resetScore.toString()
        playerTwoScore.text = resetScore.toString()
        playerDrawScore.text = resetScore.toString()
    }


    override fun onClick(view:View) {

        if(playerOneTurn) {
            playerOneBtn.setBackgroundColor(Color.GREEN)
            playerTwoBtn.setBackgroundColor(Color.parseColor("#a5d6a7"))
        }
        else{
            playerTwoBtn.setBackgroundColor(Color.GREEN)
            playerOneBtn.setBackgroundColor(Color.parseColor("#a5d6a7"))
        }

        when(view.id) {
            R.id.btnOne -> {
                if(playerOneTurn) {
                    btnOne.text = "X"
                    matrix[0][0] = "X"
                    playerOneTurn = false
                }
                else{
                    btnOne.text = "O"
                    matrix[0][0] = "O"
                    playerOneTurn = true
                }
                score()
            }

            R.id.btnTwo -> {
                if(playerOneTurn) {
                    btnTwo.text = "X"
                    matrix[0][1] = "X"
                    playerOneTurn = false
                }
                else{
                    btnTwo.text = "O"
                    matrix[0][1] = "O"
                    playerOneTurn = true
                }
                score()
            }

            R.id.btnThree -> {
                if(playerOneTurn) {
                    btnThree.text = "X"
                    matrix[0][2] = "X"
                    playerOneTurn = false
                }
                else{
                    btnThree.text = "O"
                    matrix[0][2] = "O"
                    playerOneTurn = true
                }
                score()
            }

            R.id.btnFour -> {
                if(playerOneTurn) {
                    btnFour.text = "X"
                    matrix[1][0] = "X"
                    playerOneTurn = false
                }
                else{
                    btnFour.text = "O"
                    matrix[1][0] = "O"
                    playerOneTurn = true
                }
                score()
            }

            R.id.btnFive -> {
                if(playerOneTurn) {
                    btnFive.text = "X"
                    matrix[1][1] = "X"
                    playerOneTurn = false
                }
                else{
                    btnFive.text = "O"
                    matrix[1][1] = "O"
                    playerOneTurn = true
                }
                score()
            }

            R.id.btnSix -> {
                if(playerOneTurn) {
                    btnSix.text = "X"
                    matrix[1][2] = "X"
                    playerOneTurn = false
                }
                else{
                    btnSix.text = "O"
                    matrix[1][2] = "O"
                    playerOneTurn = true
                }
                score()
            }

            R.id.btnSeven -> {
                if(playerOneTurn) {
                    btnSeven.text = "X"
                    matrix[2][0] = "X"
                    playerOneTurn = false
                }
                else{
                    btnSeven.text = "O"
                    matrix[2][0] = "O"
                    playerOneTurn = true
                }
                score()
            }

            R.id.btnEight -> {
                if(playerOneTurn) {
                    btnEight.text = "X"
                    matrix[2][1] = "X"
                    playerOneTurn = false
                }
                else{
                    btnEight.text = "O"
                    matrix[2][1] = "O"
                    playerOneTurn = true
                }
                score()
            }

            R.id.btnNine -> {
                if(playerOneTurn) {
                    btnNine.text = "X"
                    matrix[2][2] = "X"
                    playerOneTurn = false
                }
                else{
                    btnNine.text = "O"
                    matrix[2][2] = "O"
                    playerOneTurn = true
                }
                score()
            }
        }
    }
}