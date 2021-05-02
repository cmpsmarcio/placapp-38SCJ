package com.ghostapps.placapp.data.records

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ghostapps.placapp.domain.models.RecordModel
import com.google.gson.annotations.SerializedName
import com.google.firebase.*

@Entity(tableName = RecordEntity.TABLE_NAME)
class RecordEntity(
    val homeTeamName: String,
    val awayTeamName: String,
    val basketsOfOneHome: Int,
    val basketsOfTwoHome: Int,
    val basketsOfThreeHome: Int,
    val basketsOfOneAway: Int,
    val basketsOfTwoAway: Int,
    val basketsOfThreeAway: Int,

    @PrimaryKey
    val date: Long
) {
    companion object {
        const val TABLE_NAME = "records_database"

        fun fromModel(recordModel: RecordModel): RecordEntity {
            return RecordEntity(
                homeTeamName = recordModel.homeTeamName,
                awayTeamName = recordModel.awayTeamName,
                basketsOfOneHome = recordModel.basketsOfOneHome,
                basketsOfTwoHome = recordModel.basketsOfTwoHome,
                basketsOfThreeHome = recordModel.basketsOfThreeHome,
                basketsOfOneAway = recordModel.basketsOfOneAway,
                basketsOfTwoAway = recordModel.basketsOfTwoAway,
                basketsOfThreeAway = recordModel.basketsOfThreeAway,
                date = recordModel.date
            )
        }
    }

    fun toModel(): RecordModel {
        return RecordModel(
            homeTeamName = homeTeamName,
            awayTeamName = awayTeamName,
            basketsOfOneHome = basketsOfOneHome,
            basketsOfTwoHome = basketsOfTwoHome,
            basketsOfThreeHome = basketsOfThreeHome,
            basketsOfOneAway = basketsOfOneAway,
            basketsOfTwoAway = basketsOfTwoAway,
            basketsOfThreeAway = basketsOfThreeAway,
            date = date
        )
    }
}