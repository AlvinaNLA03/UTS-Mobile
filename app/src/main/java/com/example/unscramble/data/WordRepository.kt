package com.example.unscramble.data

interface WordRepository {
    suspend fun insertWord(word: Word)
}

class OfflineWordRepository(private val wordDao: WordDao) : WordRepository {
    override suspend fun insertWord(word: Word) = wordDao.insert(word)
}