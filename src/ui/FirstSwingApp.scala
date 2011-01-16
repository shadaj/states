package ui

import scala.swing._
import scala.swing.event._

/**
 * Created by IntelliJ IDEA.
 * User: shadaj
 * Date: 1/15/11
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */

object FirstSwingApp extends SimpleSwingApplication {
  var aliceSize = 5

  def top = new MainFrame {
    title = "Alice In Wonderland"
    val eatMeButton = new Button {
      text = "Eat me"
    }
    val drinkMeButton = new Button {
      text = "Drink me"
    }
    val label = new Label {
      text = "Size: 5"
    }
    contents = new BoxPanel(Orientation.Vertical) {
      contents += eatMeButton
      contents += drinkMeButton
      contents += label
      border = Swing.EmptyBorder(30, 30, 10, 30)
    }
    listenTo(eatMeButton)
    listenTo(drinkMeButton)

    eatMeButton.reactions += {
      case ButtonClicked(_) =>
        aliceSize -= 1
        println("-" + aliceSize)
        label.text = "Size: " + aliceSize
    }
    drinkMeButton.reactions += {
      case ButtonClicked(_) => {
        aliceSize += 1
        println("+" + aliceSize)
        label.text = "Size: " + aliceSize
      }
    }
  }
}