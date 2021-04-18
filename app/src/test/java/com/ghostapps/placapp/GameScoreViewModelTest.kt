package com.ghostapps.placapp

import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.ghostapps.placapp.viewModel.gameScore.GameScoreContract
import com.ghostapps.placapp.viewModel.gameScore.GameScoreViewModel
import com.nhaarman.mockito_kotlin.*
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

class GameScoreViewModelTest {
    private val gameScoreContractMock: GameScoreContract = mock {}
    private val insertRegisterMock: InsertRegister = mock {
        given { it.execute(any()) }.willReturn { true }
    }

    private lateinit var sut: GameScoreViewModel

    @Before
    fun initialize() {
        sut = GameScoreViewModel(gameScoreContractMock, insertRegisterMock)
    }

    @Test
    fun `Should update team names correctly`() {
        val teamAName = "team_a"
        val teamBName = "team_b"

        sut.onCreate(teamAName, teamBName)

        assertEquals(sut.homeTeamName, teamAName)
        assertEquals(sut.awayTeamName, teamBName)
    }

    @Test
    fun `Should increase home team score when onScoreHomeIncreaseOne is Called`() {
        sut.onScoreHomeIncreaseOne()
        assertEquals(sut.formattedHomeTeamScore, "01")

        sut.onScoreHomeIncreaseOne()
        assertEquals(sut.formattedHomeTeamScore, "02")

        assertEquals(sut.formattedNumberOfBasketsOneHome, "02")
    }

    @Test
    fun `Should increase home team score when onScoreHomeIncreaseTwo is Called`() {
        sut.onScoreHomeIncreaseTwo()
        assertEquals(sut.formattedHomeTeamScore, "02")

        sut.onScoreHomeIncreaseTwo()
        assertEquals(sut.formattedHomeTeamScore, "04")

        assertEquals(sut.formattedNumberOfBasketsTwoHome, "02")
    }

    @Test
    fun `Should increase home team score when onScoreHomeIncreaseThree is Called`() {
        sut.onScoreHomeIncreaseThree()
        assertEquals(sut.formattedHomeTeamScore, "03")

        sut.onScoreHomeIncreaseThree()
        assertEquals(sut.formattedHomeTeamScore, "06")

        assertEquals(sut.formattedNumberOfBasketsThreeHome, "02")
    }

    @Test
    fun `Should decrease home team score when onScoreHomeDecreaseOne is Called`() {
        sut.onScoreHomeIncreaseOne()
        assertEquals(sut.formattedHomeTeamScore, "01")

        sut.onScoreHomeDecreaseOne()
        assertEquals(sut.formattedHomeTeamScore, "00")

        assertEquals(sut.formattedNumberOfBasketsOneHome, "00")
    }

    @Test
    fun `Should decrease home team score when onScoreHomeDecreaseTwo is Called`() {
        sut.onScoreHomeIncreaseTwo()
        assertEquals(sut.formattedHomeTeamScore, "02")

        sut.onScoreHomeDecreaseTwo()
        assertEquals(sut.formattedHomeTeamScore, "00")

        assertEquals(sut.formattedNumberOfBasketsTwoHome, "00")
    }

    @Test
    fun `Should decrease home team score when onScoreHomeDecreaseThree is Called`() {
        sut.onScoreHomeIncreaseThree()
        assertEquals(sut.formattedHomeTeamScore, "03")

        sut.onScoreHomeDecreaseThree()
        assertEquals(sut.formattedHomeTeamScore, "00")

        assertEquals(sut.formattedNumberOfBasketsThreeHome, "00")
    }

    @Test
    fun `Should increase away team score when onScoreAwayIncreaseOne is Called`() {
        sut.onScoreAwayIncreaseOne()
        assertEquals(sut.formattedAwayTeamScore, "01")

        sut.onScoreAwayIncreaseOne()
        assertEquals(sut.formattedAwayTeamScore, "02")

        assertEquals(sut.formattedNumberOfBasketsOneAway, "02")
    }

    @Test
    fun `Should increase away team score when onScoreAwayIncreaseTwo is Called`() {
        sut.onScoreAwayIncreaseTwo()
        assertEquals(sut.formattedAwayTeamScore, "02")

        sut.onScoreAwayIncreaseTwo()
        assertEquals(sut.formattedAwayTeamScore, "04")

        assertEquals(sut.formattedNumberOfBasketsTwoAway, "02")
    }

    @Test
    fun `Should increase away team score when onScoreAwayIncreaseThree is Called`() {
        sut.onScoreAwayIncreaseThree()
        assertEquals(sut.formattedAwayTeamScore, "03")

        sut.onScoreAwayIncreaseThree()
        assertEquals(sut.formattedAwayTeamScore, "06")

        assertEquals(sut.formattedNumberOfBasketsThreeAway, "02")
    }

    @Test
    fun `Should decrease away team score when onScoreAwayDecreaseOne is Called`() {
        sut.onScoreAwayIncreaseOne()
        assertEquals(sut.formattedAwayTeamScore, "01")

        sut.onScoreAwayDecreaseOne()
        assertEquals(sut.formattedAwayTeamScore, "00")

        assertEquals(sut.formattedNumberOfBasketsOneAway, "00")
    }

    @Test
    fun `Should decrease away team score when onScoreAwayDecreaseTwo is Called`() {
        sut.onScoreAwayIncreaseTwo()
        assertEquals(sut.formattedAwayTeamScore, "02")

        sut.onScoreAwayDecreaseTwo()
        assertEquals(sut.formattedAwayTeamScore, "00")

        assertEquals(sut.formattedNumberOfBasketsTwoAway, "00")
    }

    @Test
    fun `Should decrease away team score when onScoreAwayDecreaseThree is Called`() {
        sut.onScoreAwayIncreaseThree()
        assertEquals(sut.formattedAwayTeamScore, "03")

        sut.onScoreAwayDecreaseThree()
        assertEquals(sut.formattedAwayTeamScore, "00")

        assertEquals(sut.formattedNumberOfBasketsThreeAway, "00")
    }

    @Test
    fun `Should execute onExitPressed, insertRegister and exit`() {
        sut.onExitPressed()
        verify(insertRegisterMock, times(1)).execute(any())
        verify(gameScoreContractMock, times(1)).onExitPressed()
        verify(gameScoreContractMock, times(0)).onInsertRegisterFails()
    }
}