package ui

import swing._
import event._
import geogame.{State, USA}

/**
 * Created by IntelliJ IDEA.
 * User: shadaj
 * Date: 1/15/11
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */

class StatesComponent extends BoxPanel(Orientation.Vertical) {
  var i = 0
  var states = USA.states
  var wrongStates = List[State]()
  val capitalReply = new Label
  val abbreviationReply = new Label

  object capital extends TextField {
    columns = 5
  }

  object abbreviation extends TextField {
    columns = 5
  }

  val thisIsMyAnswer = new Button {
    text = "Check the answer"
  }
  var whatIsState = new Label {
    text = "The state is: " + states(i).name
  }


  contents += whatIsState
  contents += new Label("Write the capital here: ")
  contents += capital
  contents += new Label("Write the abbreviation here: ")
  contents += abbreviation
  contents += thisIsMyAnswer
  contents += capitalReply
  contents += abbreviationReply
  border = Swing.EmptyBorder(30, 20, 20, 20)

  listenTo(thisIsMyAnswer)

  reactions += {
    case ButtonClicked(button) =>
      var capitalCorrect = true
      var abbreviationCorrect = true
      val currentState = states(i)
      if (capital.text.trim == currentState.capital) {
        capitalReply.text = "You got the capital correct!"
      } else {
        capitalReply.text = "The capital is: " + currentState.capital
        capitalCorrect = false

      }
      if (abbreviation.text.trim == currentState.abbreviation) {
        abbreviationReply.text = "You got the abbreviation correct!"
      } else {
        abbreviationReply.text = "The abbreviation is: " + currentState.abbreviation
        abbreviationCorrect = false
      }
      if (!(capitalCorrect && abbreviationCorrect)) {
        wrongStates = currentState :: wrongStates
      }
      if (states.length - 1 == i) {
        if (wrongStates.length == 0) {
          wrongStates = USA.states
        }
        i = 0
        states = wrongStates.reverse
        wrongStates = List()
      } else {
        i += 1
      }
      capital.text = ""
      abbreviation.text = ""
      whatIsState.text = "The state is: " + states(i).name
  }
}