package com.ghostapps.placapp.ui.gameRecords.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ghostapps.placapp.domain.models.RecordModel
import kotlinx.android.synthetic.main.item_game_record.view.*

class RecordsListViewHolder(
    itemView: View,
    private val onDeletePressed: (recordModel: RecordModel) -> Unit
): RecyclerView.ViewHolder(itemView) {
    fun bind(recordModel: RecordModel) {
        itemView.itemGameRecordHomeTeamName.text = recordModel.homeTeamName
        itemView.itemGameRecordHomeTeamScore.text = (recordModel.basketsOfOneHome + recordModel.basketsOfTwoHome * 2 + recordModel.basketsOfThreeHome * 3).toString()

        itemView.itemGameRecordHomeBasketsOfOne.text = recordModel.basketsOfOneHome.toString()
        itemView.itemGameRecordHomeBasketsOfTwo.text = recordModel.basketsOfTwoHome.toString()
        itemView.itemGameRecordHomeBasketsOfThree.text = recordModel.basketsOfThreeHome.toString()


        itemView.itemGameRecordAwayTeamName.text = recordModel.awayTeamName
        itemView.itemGameRecordAwayTeamScore.text = (recordModel.basketsOfOneAway + recordModel.basketsOfTwoAway * 2 + recordModel.basketsOfThreeAway * 3).toString()

        itemView.itemGameRecordAwayBasketsOfOne.text = recordModel.basketsOfOneAway.toString()
        itemView.itemGameRecordAwayBasketsOfTwo.text = recordModel.basketsOfTwoAway.toString()
        itemView.itemGameRecordAwayBasketsOfThree.text = recordModel.basketsOfThreeAway.toString()

        itemView.itemGameRecordDelete.setOnClickListener {
            onDeletePressed(recordModel)
        }
    }
}