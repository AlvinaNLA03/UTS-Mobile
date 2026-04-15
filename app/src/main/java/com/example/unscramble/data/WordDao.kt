package com.example.unscramble.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface WordDao {
    // Menyimpan kata baru. Mengabaikan jika ada konflik (meskipun dengan autoGenerate ID jarang terjadi)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)
}