package bowling

import org.scalatest.{FunSpec, Matchers}

class BowlingSpec extends FunSpec with Matchers {

  it("should return an Int between 0 and 300") {
    val bowling = BowlingGame()
    val finishedBowling = BowlingGame.playGame(bowling)
    assert(finishedBowling.score >= 0 && finishedBowling.score <= 300)
  }

  it("should return 0 if you only roll gutter") {
    val bowling = BowlingGame()
    val finishedBowling = BowlingGame.roll(bowling, 0, 0)
    assert(bowling.score == 0 && bowling.frameNumber == 1)
    assert(finishedBowling.score == 0 && finishedBowling.frameNumber == 2)
  }

  it("should return 300 if you only roll strikes") {
    val bowling = BowlingGame()
    val finishedBowling = BowlingGame.roll(bowling, 10, 0)
    assert(bowling.score == 0 && bowling.frameNumber == 1)
    assert(finishedBowling.score == 300 && finishedBowling.frameNumber == 2)
  }

  it("should make a Strike if you roll a 10 on the first shot") {
    val frame = Frame(10)
    val frameWithStatus = Frame.attributeStatus(frame)
    assert(frameWithStatus.status == "strike")
  }

  it("shoukd make a Spare if you roll a 10 on the second shot") {
    val frame = Frame(0,10)
    val frameWithStatus = Frame.attributeStatus(frame)
    assert(frameWithStatus.status == "spare")
  }

  it("shouldn't make a particular shot if you don't roll a 10 on either shot") {
    val frame = Frame(3, 5)
    val frameWithStatus = Frame.attributeStatus(frame)
    assert(frameWithStatus.status == "")
  }

  it("should have 2 frames if you add 2 frames to a game.") {
    val game = BowlingGame()
    val game2 = game.addFrame(BowlingGame.makeFrame(4,6)).addFrame(BowlingGame.makeFrame(2,7))
    assert(game2.frames.size == 2)
  }

  it("should have the correct rolls for each frame added to a game.") {
    val game = BowlingGame()
    val game2 = game.addFrame(BowlingGame.makeFrame(4,6)).addFrame(BowlingGame.makeFrame(2,7))
    assert(game2.frames.head.firstShot == 4 & game2.frames.head.secondShot == 6 && game2.frames(1).firstShot == 2 && game2.frames(1).secondShot == 7  )
  }

  it("should calculate the score of a typical game correctly") {
    val game = BowlingGame()
    val game2 = game.addFrame(BowlingGame.makeFrame(4,10)).addFrame(BowlingGame.makeFrame(2,7))
    val game3 = game2.calculateScore()
    assert(game3.score == 19)
  }
}
