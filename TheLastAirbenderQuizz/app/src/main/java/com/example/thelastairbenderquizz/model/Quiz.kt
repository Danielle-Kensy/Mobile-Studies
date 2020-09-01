package com.example.thelastairbenderquizz.model

import android.content.Context
import com.example.thelastairbenderquizz.R

class Quiz (val context: Context) {
    companion object {

        var context: Context? = null
        val questionsArray = ArrayList<Question>()

//        init {
//            generateQuestions()
//            questionsShuffle()
//        }
  
        fun generateQuestions() {
            questionsArray.add(
                Question(
                    context!!.getString(R.string.question_one),
                    context!!.getString(R.string.question_one_option_a),
                    context!!.getString(R.string.question_one_option_b),
                    context!!.getString(R.string.question_one_option_c),
                    context!!.getString(R.string.question_one_option_a)
                    )
                )

            questionsArray.add(
                Question(
                    context!!.getString(R.string.question_two),
                    context!!.getString(R.string.question_two_option_a),
                    context!!.getString(R.string.question_two_option_b),
                    context!!.getString(R.string.question_two_option_c),
                    context!!.getString(R.string.question_two_option_b)
                )
            )

            questionsArray.add(
                Question(
                    context!!.getString(R.string.question_three),
                    context!!.getString(R.string.question_three_option_a),
                    context!!.getString(R.string.question_three_option_b),
                    context!!.getString(R.string.question_three_option_c),
                    context!!.getString(R.string.question_three_option_c)
                )
            )

            questionsArray.add(
                Question(
                    context!!.getString(R.string.question_four),
                    context!!.getString(R.string.question_four_option_a),
                    context!!.getString(R.string.question_four_option_b),
                    context!!.getString(R.string.question_four_option_c),
                    context!!.getString(R.string.question_four_option_a)
                )
            )

            questionsArray.add(
                Question(
                    context!!.getString(R.string.question_five),
                    context!!.getString(R.string.question_five_option_a),
                    context!!.getString(R.string.question_five_option_b),
                    context!!.getString(R.string.question_five_option_c),
                    context!!.getString(R.string.question_five_option_b)
                )
            )

            questionsArray.add(
                Question(
                    context!!.getString(R.string.question_six),
                    context!!.getString(R.string.question_six_option_a),
                    context!!.getString(R.string.question_six_option_b),
                    context!!.getString(R.string.question_six_option_c),
                    context!!.getString(R.string.question_six_option_a)
                )
            )

            questionsArray.add(
                Question(
                    context!!.getString(R.string.question_seven),
                    context!!.getString(R.string.question_seven_option_a),
                    context!!.getString(R.string.question_seven_option_b),
                    context!!.getString(R.string.question_seven_option_c),
                    context!!.getString(R.string.question_seven_option_a)
                )
            )

            questionsArray.add(
                Question(
                    context!!.getString(R.string.question_eight),
                    context!!.getString(R.string.question_eight_option_a),
                    context!!.getString(R.string.question_eight_option_b),
                    context!!.getString(R.string.question_eight_option_c),
                    context!!.getString(R.string.question_eight_option_c)
                )
            )

            questionsArray.add(
                Question(
                    context!!.getString(R.string.question_nine),
                    context!!.getString(R.string.question_nine_option_a),
                    context!!.getString(R.string.question_nine_option_b),
                    context!!.getString(R.string.question_nine_option_c),
                    context!!.getString(R.string.question_nine_option_a)
                )
            )

            questionsArray.add(
                Question(
                    context!!.getString(R.string.question_ten),
                    context!!.getString(R.string.question_ten_option_a),
                    context!!.getString(R.string.question_ten_option_b),
                    context!!.getString(R.string.question_ten_option_c),
                    context!!.getString(R.string.question_ten_option_b)
                )
            )
        }

        fun questionsShuffle() {
            questionsArray.shuffle()
        }

        fun score(): Int {
            var score = 0
            for(question in questionsArray) {
                if(question.correctAnswer) {
                    score++
                }
            }
            return score
        }

        fun checkAverageOfCorrectAnswers(): Double {
            return (score() / 3.0) * 100
        }

        fun finalMessage(): String {
            if(checkAverageOfCorrectAnswers()>80) {
                return "Great!"
            } else if(checkAverageOfCorrectAnswers()>50) {
                return "Not bad!"
            } else {
                return "You suck"
            }
        }

        fun verifyTheCorrectAnswer(answer: String): Boolean {
            if(answer.equals(questionsArray.get(0).correctOptionAnswer)) {
                questionsArray.get(0).correctAnswer = true
                return true
            } else {
                return false
            }
        }

        fun clearAll() {
            questionsArray.clear()
            generateQuestions()
        }
    }
}
