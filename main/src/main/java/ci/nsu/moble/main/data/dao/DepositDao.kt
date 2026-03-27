package ci.nsu.moble.main.data.dao

import androidx.room.Dao
import androidx.room.Query
import ci.nsu.moble.main.data.entity.DepCalcs

@Dao
interface DepositDao {
    @Query("select * from DepCal")
    fun getAll(): List<DepCalcs>
}