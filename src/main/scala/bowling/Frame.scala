package bowling

import scala.util.Random

/**
  *
  * @param firstShot the result of the first roll
  * @param secondShot the result of the second roll
  * @param status can either be empty string, spare or strike.
  */
case class Frame(firstShot : Int = 0, secondShot : Int = 0, status : String = "", lastShotBonus : Int = 0) {

  def setStatus(newStatus : String = ""): Frame = {
    this.copy(status = newStatus)
  }

}

object Frame{
  def rollFirst(): Int = {
    val firstRoll = Random.nextInt(11)
    firstRoll + rollSecond(firstRoll)
  }

  def rollSecond(firstRoll: Int): Int = {
    Random.nextInt(11 - firstRoll) + firstRoll
  }

  def attributeStatus(frame : Frame) : Frame = {
    if (frame.firstShot == 10) {
      frame.setStatus("strike")
    }
    else if (frame.secondShot == 10){
      frame.setStatus("spare")
    }
    else {
      frame
    }
  }
}