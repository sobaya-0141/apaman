package sobaya.app.room.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import sobaya.app.room.data.dao.CarDao
import sobaya.app.room.data.entity.Car

@Database(entities = [Car::class], exportSchema = false, version = 1)
abstract class Database: RoomDatabase() {
    abstract fun carDao(): CarDao
}