package com.example.bowlinggame

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BowlingGameTest {
    private lateinit var game: BowlingGame

    @Before
    fun setUp() {
        game = BowlingGame()
    }

    @Test
    fun testAllStrikesString() {
        assertEquals(300, game.scoreFromString("XXXXXXXXXXXX"))
    }

    @Test
    fun testAllNinesMissString() {
        assertEquals(90, game.scoreFromString("9-9-9-9-9-9-9-9-9-9-"))
    }

    @Test
    fun testAllFivesSparesString() {
        assertEquals(150, game.scoreFromString("5/5/5/5/5/5/5/5/5/5/5"))
    }

}