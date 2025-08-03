package com.example.bowlinggame.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bowlinggame.model.BowlingGame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BowlingViewModel : ViewModel() {
    private val game = BowlingGame()
    private val _input = MutableStateFlow("")
    private val _score = MutableStateFlow(0)

    val input: StateFlow<String> = _input
    val score: StateFlow<Int> = _score

    fun onInputChanged(str: String) {
        _input.value = str
        // Validate roll string
        if (isValidRollString(str)) {
            _score.value = game.scoreFromString(str)
        } else {
            _score.value = 0 // or show error
        }
    }


    private fun isValidRollString(str: String): Boolean {
        // Allow only "X", "/", "-", digits
        return str.all { it == 'X' || it == '/' || it == '-' || it.isDigit() }
    }
}
