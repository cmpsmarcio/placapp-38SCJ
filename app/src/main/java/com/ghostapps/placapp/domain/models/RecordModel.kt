package com.ghostapps.placapp.domain.models

class RecordModel (
    val homeTeamName: String,
    val basketsOfOneHome: Int,
    val basketsOfTwoHome: Int,
    val basketsOfThreeHome: Int,

    val awayTeamName: String,
    val basketsOfOneAway: Int,
    val basketsOfTwoAway: Int,
    val basketsOfThreeAway: Int,

    val data: Long
)