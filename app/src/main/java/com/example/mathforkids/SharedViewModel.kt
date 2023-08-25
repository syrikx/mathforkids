package com.example.mathforkids

import android.content.Context
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import kotlinx.coroutines.delay

data class Problem(val num1: Int, val num2: Int, val operator: String)

class SharedViewModel : ViewModel() {
//    var problem = Problem (1,1,"+")
    private val _starsList = MutableLiveData<List<Boolean>>(listOf(false, false, false, false, false, false, false, false, false, false))
    val starsList: LiveData<List<Boolean>> get() = _starsList
    private val _isAnswerVisible = MutableLiveData<Int>(View.GONE)
    val isAnswerVisible : LiveData<Int> get() = _isAnswerVisible
    private val _noCorrectAnswers = MutableLiveData<Int>(0)
    val noCorrectAnswers : LiveData<Int> get() = _noCorrectAnswers
    private val _num1 = MutableLiveData<Int>()
    val num1: LiveData<Int> get() = _num1
    private val _operator = MutableLiveData<String>()
    val operator: LiveData<String> get() = _operator
    private val _num2 = MutableLiveData<Int>()
    val num2: LiveData<Int> get() = _num2
    private val _answer = MutableLiveData<Int>()
    val answer: LiveData<Int> get() = _answer

    val sampleText : String = "this is sampleText"
    val sampleColor : Int = R.color.color0

    fun init(context: Context){
    }

    fun updateStars(correctAnswers: Int) {
        val newStarsList = _starsList.value?.mapIndexed { index, _ ->
            index < correctAnswers
        }
        _starsList.value = newStarsList!!
    }

    fun resetProblem() {
        var problem = generateRandomProblem()
        _num1.value = problem.num1
        _operator.value = problem.operator
        _num2.value = problem.num2
        _answer.value = calculateAnswer(problem.num1, problem.num2, problem.operator)
        _isAnswerVisible.postValue(View.GONE)
    }

    private fun generateRandomProblem(): Problem {
        val operators = listOf("+", "-", "×", "÷")
        val randomOperator = operators.random()

        return when (randomOperator) {
            "-" -> {
                var num1 = (0..9).random()
                var num2 = (0..9).random()
                while (num1 < num2) {
                    num1 = (0..9).random()
                    num2 = (0..9).random()
                }
                Problem(num1, num2, randomOperator)
            }
            "÷" -> {
                val num2 = (1..9).random() // 0을 제외
                val num1 = num2 * (1..9).random()
                Problem(num1, num2, randomOperator)
            }
            else -> {
                val num1 = (0..9).random()
                val num2 = (0..9).random()
                Problem(num1, num2, randomOperator)
            }
        }
    }

    // 정답을 계산하는 함수
    fun calculateAnswer(num1: Int, num2: Int, operator: String): Int {
        return when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "×" -> num1 * num2
            "÷" -> num1 / num2
            else -> 0
        }
    }

    private val _inputValue = MutableLiveData<String>()
    val inputValue: LiveData<String> get() = _inputValue

    fun appendNumber(num: Int) {
        val currentValue = _inputValue.value ?: ""
        val updatedValue = "$currentValue$num"
        _inputValue.value = updatedValue
//        Log.d("MathForKids", "_inputValue: ${_inputValue.value}")
//        Log.d("MathForKids", "inputValue: ${inputValue.value}")
    }

    fun resetAnswer(){
        _inputValue.value = ""
    }

    fun submitAnswer() {
        val userAnswer = inputValue.value
        _isAnswerVisible.postValue(View.VISIBLE)

        userAnswer?.let {
            if (it.isBlank()) return
            Log.d("MathForKids", "inputValue: $userAnswer, _answer: ${_answer.value}, isCorrect: ${userAnswer == _answer.value.toString()}")

            if (userAnswer == _answer.value.toString()) {
                handleCorrectAnswer(it)
            } else {
                handleIncorrectAnswer(_answer.value.toString(), it)
            }
        }
    }

    fun handleCorrectAnswer(answer : String){
        _noCorrectAnswers.value = _noCorrectAnswers.value?.plus(1)
        resetProblem()
    }

    fun handleIncorrectAnswer(answer : String, input : String){

    }


//    val num1Color = MediatorLiveData<Int>().apply {
//        this.addSource(num1) { num ->
//            value = when (num) {
//                0 -> R.color.color0
//                else -> R.color.colorDefault
//            }
//        }
//    }


}
