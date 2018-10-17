package bowling
import scala.annotation.tailrec




case class BowlingGame(score: Int = 0, frameNumber : Int = 1, frames : List[Frame] = List(), memory : Int = 0) {


  def addFrame(shots : Frame): BowlingGame = {
    this.copy(frames = frames ++ List(shots))
  }

  def addScore(value: Int): BowlingGame = {
    this.copy(score = this.score + value)
  }

  def increaseFrameCount(): BowlingGame = {
    this.copy(frameNumber = this.frameNumber + 1)
  }

  //TODO
  def calculateScore() : BowlingGame = {
    this.copy()
  }
}

object BowlingGame {

  def roll(bowling : BowlingGame, firstRoll : Int, secondRoll : Int) : BowlingGame = {
    val bowling1 = bowling.addScore(firstRoll)
    val bowling2 = bowling1.addScore(secondRoll)
    bowling2.increaseFrameCount()
  }

  def makeFrame(firstShot : Int, secondShot : Int) : Frame ={
    Frame.attributeStatus(Frame(firstShot, secondShot))
  }


  @tailrec
  final def playGame(bowlingGame : BowlingGame): BowlingGame ={
    if (bowlingGame.frameNumber <= 10) {
      val first = Frame.rollFirst()
      val second = Frame.rollSecond(first)
      val currentFrame = makeFrame(first, second)
      val bowling2 = bowlingGame.addFrame(currentFrame)
      val bowling3 = bowling2.increaseFrameCount()
      playGame(bowling3)
    }
    else {
      bowlingGame
    }
  }

}
