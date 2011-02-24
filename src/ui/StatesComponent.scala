package ui

import swing._
import event._
import geogame.{State, USA}
import java.awt.Font
import java.awt.Color

/**
 * Created by IntelliJ IDEA.
 * User: shadaj
 * Date: 1/15/11
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */

class StatesComponent(applet: StatesApplet) extends BoxPanel(Orientation.Vertical) {
  var i = 0
  var states = USA.states
  var wrongStates = List[State]()
  val capitalReply = new Label(" ")
  val abbreviationReply = new Label(" ")

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
    text = "For state: " + states(i).name
  }

  val defaultFont = new Font("SansSerif", Font.PLAIN, 16)
  contents += whatIsState
  contents += new Label("Enter the capital: ")
  contents += capital
  contents += capitalReply
  contents += new Label("Enter the abbreviation: ")
  contents += abbreviation
  contents += abbreviationReply
  contents += thisIsMyAnswer



  contents.foreach(_.font = defaultFont)
  whatIsState.font = new Font("SansSerif", Font.BOLD, 20)


  border = Swing.EmptyBorder(30, 20, 20, 20)

  listenTo(thisIsMyAnswer)

  reactions += {
    case ButtonClicked(button) =>
      var capitalCorrect = true
      var abbreviationCorrect = true
      val currentState = states(i)
      if (capital.text.trim == currentState.capital) {
        capitalReply.foreground = Color.green
        capitalReply.text = "You got the capital correct!"
      } else {
        capitalReply.foreground = Color.red
        capitalReply.text = "The capital is: " + currentState.capital
        capitalCorrect = false

      }
      if (abbreviation.text.trim == currentState.abbreviation) {
        abbreviationReply.foreground = Color.orange
        abbreviationReply.text = "You got the abbreviation correct!"
      } else {
        abbreviationReply.foreground = Color.red
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