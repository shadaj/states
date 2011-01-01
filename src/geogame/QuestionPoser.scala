package geogame

/**
 * Created by IntelliJ IDEA.
 * User: shadaj
 * Date: 12/31/10
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */

object QuestionPoser {
  def ask(state: State) = {
    val capital = readLine("What is the capital of " + state.name + ": ")
    val capitalResponse = capital.toLowerCase match {
      case state.capital.toLowerCase => ("You're right!", true)
      case _ => ("The correct answer is: " + state.capital, false)
    }
    println(capitalResponse._1)

    val abbreviation = readLine("What is the abbreviation of " + state.name + ": ")
    val abbreviationResponse = abbreviation match {
      case state.abbreviation => ("You're right!", true)
      case _ => ("The correct answer is: " + state.abbreviation, false)
    }
    println(abbreviationResponse._1)
    capitalResponse._2 && abbreviationResponse._2
  }

  def ask(states: List[State]) {
    var wrongStates = List[State]
    for (state <- states) {
      if (!ask(state)) {
        state :: wrongStates
      }
      ask(reverse(wrongStates))
      if (states.length == 50) {
        ask(states)
        return
      }
    }
  }
}