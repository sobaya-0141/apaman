package sobaya.app.room

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import sobaya.app.room.data.Database
import sobaya.app.room.data.entity.Car
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.inMemoryDatabaseBuilder(applicationContext, Database::class.java).build()
//        val db = Room.databaseBuilder(applicationContext, Database::class.java, "apaman").build()
//        val db = Room.databaseBuilder(applicationContext, Database::class.java, "apaman").allowMainThreadQueries().build()
        carData(db)
    }

    fun carData(db: Database) {

        thread {
            with (db.carDao()) {
                deleteAll()
                insert(Car(name = "CX-3"))
                insert(Car(name = "CX-5"))
                insert(Car(name = "CX-8"))
                findAll().forEach {
                    Log.d("APAMAN", "ID:${it.id} NAME:${it.name}")
                }
                findId(1).apply {
                    Log.d("APAMAN-2", "ID:${id} NAME:${name}")
                }
                delete(Car(2, ""))
                findAll().forEach {
                    Log.d("APAMAN", "ID:${it.id} NAME:${it.name}")
                }
            }
        }
    }
}
