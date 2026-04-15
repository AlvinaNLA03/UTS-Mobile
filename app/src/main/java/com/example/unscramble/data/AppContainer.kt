package com.example.unscramble.data

import android.content.Context

interface AppContainer {
    val wordRepository: WordRepository
}

class DefaultAppContainer(private val context: Context) : AppContainer {
    override val wordRepository: WordRepository by lazy {
        OfflineWordRepository(AppDatabase.getDatabase(context).wordDao())
    }
    class AppDataContainer(private val context: Context) : AppContainer {
        override val wordRepository: WordRepository by lazy {
            OfflineWordRepository(WordDatabase.getDatabase(context).wordDao())
        }
    }
}