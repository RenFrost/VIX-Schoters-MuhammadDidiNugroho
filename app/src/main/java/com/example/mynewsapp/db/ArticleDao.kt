package com.example.mynewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mynewsapp.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun  deleteArticle(article: Article)
}