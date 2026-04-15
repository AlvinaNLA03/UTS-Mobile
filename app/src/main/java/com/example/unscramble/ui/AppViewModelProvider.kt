package com.example.unscramble.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.unscramble.UnscrambleApplication
import com.example.unscramble.WordsApplication

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            AddWordViewModel(wordsApplication().container.wordRepository)
        }
        initializer {
            GameViewModel(
                wordRepository = UnscrambleApplication().container.wordRepository
            )
        }

        // Initializer untuk AddWordViewModel
        initializer {
            AddWordViewModel(
                wordRepository = UnscrambleApplication().container.wordRepository
            )
        }
    }
}

// Fungsi bantu untuk mengambil Application class
fun CreationExtras.wordsApplication(): WordsApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as WordsApplication)