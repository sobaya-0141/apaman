package sobaya.app.room.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import sobaya.app.room.data.entity.Car

@Dao
interface CarDao {

    @Insert
    fun insert(car: Car)

    @Update
    fun update(car: Car)

    @Delete
    fun delete(car: Car)

    @Query("SELECT * FROM Car")
    fun findAll(): List<Car>

    @Query("SELECT * FROM CAR WHERE :id")
    fun findId(id: Int): Car

    @Query("SELECT * FROM Car")
    fun findAllLiveData(): LiveData<List<Car>>

    @Query("DELETE FROM Car")
    fun deleteAll()
}