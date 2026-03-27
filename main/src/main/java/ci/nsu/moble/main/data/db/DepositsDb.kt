package ci.nsu.moble.main.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ci.nsu.moble.main.data.dao.DepositDao
import ci.nsu.moble.main.data.entity.DepCalcs

@Database(entities = [DepCalcs::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun depositDao() : DepositDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "DepositsDb"
                ).build().also { INSTANCE = it }
            }
        }
    }
}