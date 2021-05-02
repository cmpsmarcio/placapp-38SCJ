package com.ghostapps.placapp.domain.models

class RecordModel (
    var homeTeamName: String,
    var basketsOfOneHome: Int,
    var basketsOfTwoHome: Int,
    var basketsOfThreeHome: Int,

    var awayTeamName: String,
    var basketsOfOneAway: Int,
    var basketsOfTwoAway: Int,
    var basketsOfThreeAway: Int,

    val date: Long
)
{
    constructor() : this(
        homeTeamName = "",
        basketsOfOneHome = 0,
        basketsOfTwoHome = 0,
        basketsOfThreeHome = 0,

        awayTeamName = "",
        basketsOfOneAway = 0,
        basketsOfTwoAway = 0,
        basketsOfThreeAway = 0,
        date = 0
    )
}