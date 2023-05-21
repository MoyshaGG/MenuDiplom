package com.example.diplom.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.diplom.model.PCBuild

@Dao
interface PCBuildDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pcBuild: PCBuild): Long

    @Update
    suspend fun update(pcBuild: PCBuild)

    @Delete
    suspend fun delete(pcBuild: PCBuild)

    @Query("SELECT * FROM pc_builds")
    fun getAllBuilds(): LiveData<List<PCBuild>>

    @Query("SELECT * FROM pc_builds WHERE id = :id")
    suspend fun getBuild(id: Long): PCBuild
}