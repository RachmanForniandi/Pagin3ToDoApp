package com.richarddewan.paging3_todo.data.local.db.rxdoa

import androidx.paging.PagingSource
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.richarddewan.paging3_todo.data.local.entity.TaskEntity

interface TaskRxDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMany(tasks: List<TaskEntity>)

    @Query("SELECT * FROM tasks ORDER BY id ASC")
    fun getTasks(): PagingSource<Int, TaskEntity>

    @Query("DELETE FROM tasks")
    suspend fun clearTasks()
}