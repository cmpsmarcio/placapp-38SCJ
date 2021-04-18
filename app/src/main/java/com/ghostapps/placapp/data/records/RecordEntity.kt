package com.ghostapps.placapp.data.records

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ghostapps.placapp.domain.models.RecordModel
import com.google.gson.annotations.SerializedName

@Entity(tableName = RecordEntity.TABLE_NAME)
class RecordEntity(
    @SerializedName("team_a_name")
    val homeTeamName: String,
    @SerializedName("team_b_name")
    val awayTeamName: String,

    @SerializedName("team_a_baskets_of_one")
    val basketsOfOneHome: Int,
    @SerializedName("team_a_baskets_of_two")
    val basketsOfTwoHome: Int,
    @SerializedName("team_a_baskets_of_three")
    val basketsOfThreeHome: Int,

    @SerializedName("team_b_baskets_of_one")
    val basketsOfOneAway: Int,
    @SerializedName("team_b_baskets_of_two")
    val basketsOfTwoAway: Int,
    @SerializedName("team_b_baskets_of_three")
    val basketsOfThreeAway: Int,

    @PrimaryKey
    @SerializedName("timestamp")
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