package com.ghostapps.placapp.viewModel.gameScore

import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.ghostapps.placapp.viewModel.BaseViewModel
import java.util.*

class GameScoreViewModel(
    private val contract: GameScoreContract,
    private val insertRegister: InsertRegister
) : BaseViewModel() {

    var homeTeamName = ""
    var awayTeamName = ""

    var formattedHomeTeamScore = "00"
    var formattedAwayTeamScore = "00"

    var formattedNumberOfBasketsOneHome = "00"
    var formattedNumberOfBasketsTwoHome = "00"
    var formattedNumberOfBasketsThreeHome = "00"

    var formattedNumberOfBasketsOneAway = "00"
    var formattedNumberOfBasketsTwoAway = "00"
    var formattedNumberOfBasketsThreeAway = "00"

    var basketsOfOneHome = 0
    var basketsOfTwoHome = 0
    var basketsOfThreeHome = 0

    var basketsOfOneAway = 0
    var basketsOfTwoAway = 0
    var basketsOfThreeAway = 0

    fun onCreate(homeTeamName: String, awayTeamName: String) {
        this.homeTeamName = homeTeamName
        this.awayTeamName = awayTeamName
    }

    fun onScoreHomeIncreaseOne() {
        basketsOfOneHome++
        updateScore()
    }

    fun onScoreHomeIncreaseTwo() {
        basketsOfTwoHome++
        updateScore()
    }

    fun onScoreHomeIncreaseThree() {
        basketsOfThreeHome++
        updateScore()
    }

    fun onScoreHomeDecreaseOne() {
        if (basketsOfOneHome > 0) {
            basketsOfOneHome--
            updateScore()
        }
    }

    fun onScoreHomeDecreaseTwo() {
        if (basketsOfTwoHome > 0) {
            basketsOfTwoHome--
            updateScore()
        }
    }

    fun onScoreHomeDecreaseThree() {
        if (basketsOfThreeHome > 0) {
            basketsOfThreeHome--
            updateScore()
        }
    }

    fun onScoreAwayIncreaseOne() {
        basketsOfOneAway++
        updateScore()
    }

    fun onScoreAwayIncreaseTwo() {
        basketsOfTwoAway++
        updateScore()
    }

    fun onScoreAwayIncreaseThree() {
        basketsOfThreeAway++
        updateScore()
    }

    fun onScoreAwayDecreaseOne() {
        if (basketsOfOneAway > 0) {
            basketsOfOneAway--
            updateScore()
        }
    }

    fun onScoreAwayDecreaseTwo() {
        if (basketsOfTwoAway > 0) {
            basketsOfTwoAway--
            updateScore()
        }
    }

    fun onScoreAwayDecreaseThree() {
        if (basketsOfThreeAway > 0) {
            basketsOfThreeAway--
            updateScore()
        }
    }

    fun onExitPressed() {
        Thread {
            val success = insertRegister.execute(RecordModel(
                    homeTeamName = homeTeamName,
                    awayTeamName = awayTeamName,
                    basketsOfOneHome = basketsOfOneHome,
                    basketsOfTwoHome = basketsOfTwoHome,
                    basketsOfThreeHome = basketsOfThreeHome,
                    basketsOfOneAway = basketsOfOneAway,
                    basketsOfTwoAway = basketsOfTwoAway,
                    basketsOfThreeAway = basketsOfThreeAway,
                    date = Date().time
                    ))

            if (success) {
                contract.onExitPressed()
            }
            else {
                contract.onInsertRegisterFails()
            }
        }.start()
    }


    private fun updateScore() {
        formattedHomeTeamScore = String.format("%02d", basketsOfOneHome + basketsOfTwoHome * 2 + basketsOfThreeHome * 3)
        formattedAwayTeamScore = String.format("%02d", basketsOfOneAway + basketsOfTwoAway * 2 + basketsOfThreeAway * 3)

        formattedNumberOfBasketsOneHome = String.format("%02d", basketsOfOneHome)
        formattedNumberOfBasketsTwoHome = String.format("%02d", basketsOfTwoHome)
        formattedNumberOfBasketsThreeHome = String.format("%02d", basketsOfThreeHome)

        formattedNumberOfBasketsOneAway = String.format("%02d", basketsOfOneAway)
        formattedNumberOfBasketsTwoAway = String.format("%02d", basketsOfTwoAway)
        formattedNumberOfBasketsThreeAway = String.format("%02d", basketsOfThreeAway)

        notifyChange()
    }
}