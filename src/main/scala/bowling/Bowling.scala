package bowling


object Bowling extends App {

  def startGame(): Unit = {
    val bowlingGame = BowlingGame()
    val finishedGame = BowlingGame.playGame(bowlingGame)

    val finishedGameAndScored = finishedGame.calculateScore()
    println(finishedGameAndScored.score)
  }


  startGame()
}
