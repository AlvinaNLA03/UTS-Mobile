package com.example.unscramble.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// 1. Definisikan Entity apa saja yang masuk ke database dan versinya
@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordDatabase : RoomDatabase() {

    // 2. Hubungkan dengan DAO
    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var Instance: WordDatabase? = null

        // 3. Fungsi untuk mendapatkan database (Singleton)
        fun getDatabase(context: Context): WordDatabase {
            // Jika instance sudah ada, kembalikan. Jika belum, buat baru.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    WordDatabase::class.java,
                    "word_database" // Nama file database yang disimpan di HP
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}