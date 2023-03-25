package com.example.mathdicegamerk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.mathdicegamerk.databinding.ActivityMainBinding
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //Turn variable is set to false for Player 1's turn and true for Player 2
    private var Turn=false
    private var SecondRoll=false

    private var Jackpot=5
    private var Player1points=0
    private var Player2points=0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)
        //RollDice button
        binding.Submitbtn.setEnabled(false)
        binding.AnswerInput.setEnabled(false)
        binding.RollDice.setOnClickListener{
            binding.RollDice.setEnabled(false)
            var diceNumber= Random.nextInt(1,7)
            var pictureTitle="@drawable/dice"+diceNumber
            var pictureID= resources.getIdentifier(pictureTitle, "@drawable", getPackageName())
            binding.DiceImage.setImageResource(pictureID)
            getOperation(diceNumber)



        }


    }


    private fun getOperation(diceNumber: Int){
        var diceNumberLocal=diceNumber
        //get the two operands using random
        var Operand1= Random.nextInt(0,100)
        var Operand2= Random.nextInt(0,100)
        var operator=""



            //use when to perform different tasks depending on dice roll number
        when (diceNumberLocal) {
                1 -> {

                    operator = "+"



                    binding.Message.text = ""

                    binding.Number1.text=Operand1.toString()
                    binding.Operator.text=operator
                    binding.Number2.text=Operand2.toString()
                    binding.Equals.text="="
                    var correct=Operand1 + Operand2
                    binding.AnswerInput.setEnabled(true)
                    binding.Submitbtn.setEnabled(true)
                    binding.Submitbtn.setOnClickListener{
                        binding.Submitbtn.setEnabled(false)
                        binding.RollDice.setEnabled(true)
                        var response=binding.AnswerInput.text.toString().toInt()

                        binding.AnswerInput.setEnabled(false)
                        if(response==correct) {
                            if (Turn) {
                                if(SecondRoll==true){
                                    Player1points+=2
                                    SecondRoll=false
                                }
                                else{
                                    Player1points++
                                } }
                            else {
                                if(SecondRoll==true){
                                    Player2points+=2
                                    SecondRoll=false
                                }
                                else{
                                    Player2points++
                                }
                            }
                            binding.Feedback.text="That is correct!"
                        }
                        else{
                            binding.Feedback.text="That is incorrect!"
                            Jackpot+=1
                        }


                        //Code for displaying points
                        binding.P1points.text=Player1points.toString()
                        binding.P2points.text=Player2points.toString()
                        binding.JPpoints.text=Jackpot.toString()
                        if(Player1points>=20){
                            binding.Message.text="Player 1 Wins!"
                            binding.RollDice.setEnabled(false)

                        }
                        else if(Player2points>=20){
                            binding.Message.text="Player 2 Wins!"
                            binding.RollDice.setEnabled(false)

                        }



                    }}
                2 -> {
                    operator = "-"

                    binding.Message.text = ""

                    binding.Number1.text=Operand1.toString()
                    binding.Operator.text=operator
                    binding.Number2.text=Operand2.toString()
                    binding.Equals.text="="
                    var correct=Operand1-Operand2
                    binding.AnswerInput.setEnabled(true)
                    binding.Submitbtn.setEnabled(true)
                    binding.Submitbtn.setOnClickListener{
                        binding.Submitbtn.setEnabled(false)
                        binding.RollDice.setEnabled(true)
                        var response=binding.AnswerInput.text.toString().toInt()
                        binding.AnswerInput.setEnabled(false)
                        if(response==correct) {
                            if (Turn) {
                                if(SecondRoll==true){
                                    Player1points+=4
                                    SecondRoll=false

                                }
                                else{
                                    Player1points+=2
                                } }
                            else {
                                if(SecondRoll==true){
                                    Player2points+=4
                                    SecondRoll=false

                                }
                                else{
                                    Player2points+=2
                                }
                            }
                            binding.Feedback.text="That is correct!"
                        }
                        else{
                            binding.Feedback.text="That is incorrect!"
                            Jackpot+=2
                        }

                        //code for displaying points
                        binding.P1points.text=Player1points.toString()
                        binding.P2points.text=Player2points.toString()
                        binding.JPpoints.text=Jackpot.toString()
                        if(Player1points>=20){
                            binding.Message.text="Player 1 Wins!"
                            binding.RollDice.setEnabled(false)

                        }
                        else if(Player2points>=20){
                            binding.Message.text="Player 2 Wins!"
                            binding.RollDice.setEnabled(false)

                        }



                    }


                }
                3 -> {
                    Operand1 = Random.nextInt(0, 21)
                    Operand2 = Random.nextInt(0, 21)

                    operator = "*"

                    binding.Message.text = ""

                    binding.Number1.text=Operand1.toString()
                    binding.Operator.text=operator
                    binding.Number2.text=Operand2.toString()
                    binding.Equals.text="="
                    var correct=Operand1 *Operand2
                    binding.AnswerInput.setEnabled(true)
                    binding.Submitbtn.setEnabled(true)
                    binding.Submitbtn.setOnClickListener{
                        binding.Submitbtn.setEnabled(false)
                        binding.RollDice.setEnabled(true)
                        var response=binding.AnswerInput.text.toString().toInt()
                        binding.AnswerInput.setEnabled(false)
                        if(response==correct) {
                            if (Turn) {
                                if(SecondRoll==true){
                                    Player1points+=6
                                    SecondRoll=false

                                }
                                else{
                                    Player1points+=3
                                } }
                            else {
                                if(SecondRoll==true){
                                    Player2points+=6
                                    SecondRoll=false

                                }
                                else{
                                    Player2points+=3
                                }
                            }
                            binding.Feedback.text="That is correct!"
                        }
                        else{
                            binding.Feedback.text="That is incorrect!"
                            Jackpot+=3
                        }



                        //Code for displaying points
                        binding.P1points.text=Player1points.toString()
                        binding.P2points.text=Player2points.toString()
                        binding.JPpoints.text=Jackpot.toString()
                        if(Player1points>=20){
                            binding.Message.text="Player 1 Wins!"
                            binding.RollDice.setEnabled(false)

                        }
                        else if(Player2points>=20){
                            binding.Message.text="Player 2 Wins!"
                            binding.RollDice.setEnabled(false)

                        }



                    }
                }
                4 -> {
                    SecondRoll=true
                    binding.Message.text = "Roll Again!"
                    binding.RollDice.setEnabled(true)
                    binding.AnswerInput.setEnabled(false)

                    binding.Number1.text=""
                    binding.Operator.text=""
                    binding.Number2.text=""
                    binding.Equals.text=""





                }
                5 -> {
                    binding.Message.text = "Turn Lost!"

                    binding.RollDice.setEnabled(true)
                    binding.AnswerInput.setEnabled(false)
                    if(SecondRoll==true){
                        SecondRoll=false
                    }

                    binding.Number1.text=""
                    binding.Operator.text=""
                    binding.Number2.text=""
                    binding.Equals.text=""


                }
                6 -> {

                    Operand1 = Random.nextInt(0, 21)
                    Operand2 = Random.nextInt(0, 21)

                    operator = "*"

                    binding.Message.text = "Try Jackpot"

                    binding.Number1.text=Operand1.toString()
                    binding.Operator.text=operator
                    binding.Number2.text=Operand2.toString()
                    binding.Equals.text="="
                    var correct=Operand1 *Operand2
                    binding.AnswerInput.setEnabled(true)
                    binding.Submitbtn.setEnabled(true)
                    binding.Submitbtn.setOnClickListener{
                        binding.Submitbtn.setEnabled(false)
                        binding.RollDice.setEnabled(true)
                        var response=binding.AnswerInput.text.toString().toInt()
                        binding.AnswerInput.setEnabled(false)
                        if(response==correct) {
                            if (Turn) {
                                if(SecondRoll==true)
                                {   Player1points+=2*Jackpot
                                    SecondRoll=false
                                }
                                else{
                                    Player1points+=Jackpot
                                } }
                            else {
                                if(SecondRoll==true)
                                {   Player2points+=2*Jackpot
                                    SecondRoll=false
                                }

                                else{
                                    Player2points+=Jackpot
                                }
                            }
                            binding.Feedback.text="That is correct!"
                            Jackpot=5
                        }
                        else{
                            binding.Feedback.text="That is incorrect!"
                            Jackpot+=3
                        }
                        //code for displaying player points and jackpot
                        binding.P1points.text=Player1points.toString()
                        binding.P2points.text=Player2points.toString()
                        binding.JPpoints.text=Jackpot.toString()
                        if(Player1points>=20){
                            binding.Message.text="Player 1 Wins!"
                            binding.RollDice.setEnabled(false)

                        }
                        else if(Player2points>=20){
                            binding.Message.text="Player 2 Wins!"
                            binding.RollDice.setEnabled(false)

                        }





                    }

                }

            }

        binding.Feedback.text=" "




        Turn=!Turn
        //display which player's turn it is
        if(Turn) {
            binding.PlayerTurn.text ="Player 1's Turn"
        }
        else{
            binding.PlayerTurn.text ="Player 2's Turn"
        }
        if(diceNumberLocal==4){
            Turn=!Turn
        }






    }
}