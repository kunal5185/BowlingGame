package com.example.bowlinggame.model

class BowlingGame {
    // Main scoring function: accepts a roll string like "9-9-9-9-9-9-9-9-9-9-"
    fun scoreFromString(rollString: String): Int {
        val rolls = parseRolls(rollString)
        var score = 0
        var rollIndex = 0
        repeat(10) { frameIndex ->
            if (rolls.getOrNull(rollIndex) == 10) { // Strike
                score += 10 + (rolls.getOrNull(rollIndex + 1)
                    ?: 0) + (rolls.getOrNull(rollIndex + 2) ?: 0)
                rollIndex += 1
            } else if (((rolls.getOrNull(rollIndex) ?: 0) + (rolls.getOrNull(rollIndex + 1)
                    ?: 0)) == 10
            ) { // Spare
                score += 10 + (rolls.getOrNull(rollIndex + 2) ?: 0)
                rollIndex += 2
            } else { // Open frame
                score += (rolls.getOrNull(rollIndex) ?: 0) + (rolls.getOrNull(rollIndex + 1) ?: 0)
                rollIndex += 2
            }
        }
        return score
    }

    // Helper function to parse bowling notation strings into rolls
    private fun parseRolls(rolls: String): List<Int> {
        val result = mutableListOf<Int>()
        for (char in rolls) {
            when (char) {
                'X', 'x' -> result.add(10)

                '/' -> {
                    // Spare: 10 minus previous roll
                    val prev = result.lastOrNull() ?: 0
                    result.add(10 - prev)
                }

                '-' -> result.add(0)

                else -> result.add(Character.getNumericValue(char))
            }
        }
        return result
    }
}
