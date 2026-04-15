package com.example.unscramble.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unscramble.data.Word
import com.example.unscramble.data.WordRepository
import kotlinx.coroutines.launch

data class WordUiState(val word: String = "")

class AddWordViewModel(private val wordRepository: WordRepository) : ViewModel() {

    var wordUiState by mutableStateOf(WordUiState())
        private set

    fun updateUiState(newWord: String) {
        wordUiState = wordUiState.copy(word = newWord)
    }

    fun saveWord() {
        if (wordUiState.word.isNotBlank()) {
            viewModelScope.launch {
                wordRepository.insertWord(Word(word = wordUiState.word))
                wordUiState = wordUiState.copy(word = "") // Reset input
            }
        }
    }
}