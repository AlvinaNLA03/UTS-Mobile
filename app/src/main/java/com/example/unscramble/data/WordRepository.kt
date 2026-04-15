package com.example.unscramble.data

object WordRepository {
    private val _allWords = mutableSetOf("android", "kotlin", "compose", "unscramble")

    val allWords: Set<String> get() = _allWords

    fun addWord(word: String) {
        if (word.isNotBlank()) {
            _allWords.add(word.lowercase().trim())
        }
    }
}