package com.kuki.kotlinproject.databse

import androidx.room.*
import com.kuki.kotlinproject.databse.Student

@Dao  // Database access object   增删改查
interface StudentDao {

    // vararg 可变参数
    // void a(Student... stus)   vs   vararg students: Student
    @Insert
    fun insertStudents(vararg students: Student)

    @Update
    fun updateStudents(vararg students: Student)

    // 根据条件删除
    @Delete
    fun deleteStudents(vararg students: Student)

    // 删除全部
    @Query("DELETE FROM student")
    fun deleteAllStudents()

    // 查询全部
    @Query("SELECT * FROM student ORDER BY ID DESC")
    fun queryAllStudents() : List<Student>
}