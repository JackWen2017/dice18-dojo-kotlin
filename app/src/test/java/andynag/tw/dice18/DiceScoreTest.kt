package andynag.tw.dice18

import org.junit.Assert
import org.junit.Test

class DiceScoreTest {

    @Test
    fun `All Same`() {
        for(point in 1..6){
            val input = listOf(Dice(point),Dice(point),Dice(point),Dice(point))
            val actual = Score.value(input)
            val expect = Score.DICE_18 + point
            Assert.assertEquals(expect, actual)
        }
    }

    @Test
    fun `One diff`() {
        val expect = 0
        for(point in 1..6) {
            for(point2 in 1..6){
                if(point != point2) {
                    val input = listOf(Dice(point),Dice(point),Dice(point),Dice(point2))
                    val actual = Score.value(input)
                    Assert.assertEquals(expect, actual)
                }
            }
        }
    }

    @Test
    fun `Two pair`() {
        for(point in 1..6) {
            for(point2 in point+1..6){
                if(point != point2) {
                    val input = listOf(Dice(point),Dice(point),Dice(point2),Dice(point2))
                    val actual = Score.value(input)
                    val expect = point2 * 2
                    Assert.assertEquals(expect, actual)
                }
            }
        }
    }

    @Test
    fun `Three diff`() {
        for(point in 1..6) {
            for(point2 in 1..6){
                if(point != point2) {
                    for(point3 in point2+1..6){
                        if(point != point3) {
                            val input = listOf(Dice(point),Dice(point),Dice(point2),Dice(point3))
                            val actual = Score.value(input)
                            val expect = point2 + point3
                            Assert.assertEquals(expect, actual)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun `All diff`() {
        val expect = 0
        for(point in 1..3) {
            for(point2 in point+1..6){
                for(point3 in point2+1..6){
                    for(point4 in point3+1..6){
                        val input = listOf(Dice(point),Dice(point2),Dice(point3),Dice(point4))
                        val actual = Score.value(input)
                        Assert.assertEquals(expect, actual)
                    }
                }
            }
        }
    }

}