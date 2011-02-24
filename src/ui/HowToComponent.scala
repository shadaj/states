package ui
import swing._
import event._
import java.awt.Font

/**
 * Created by IntelliJ IDEA.
 * User: shadaj
 * Date: 2/23/11
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */

class HowToComponent(applet: StatesApplet) extends BoxPanel(Orientation.Vertical) {
  val HomeButton = new Button {
    text = "Go back to home"
  }
  val PlayButton = new Button {
    text = "Start the game"
  }
  val head = new Label {
    text = "How To Play"
  }
  head.font = new Font("SansSerif", Font.BOLD, 20)
  val text = new Label {
    text = "Some text"
  }
  contents += head
  contents += text
  contents += HomeButton
  contents += PlayButton
  border = Swing.EmptyBorder(30, 20, 20, 20)
  listenTo(HomeButton)
  listenTo(PlayButton)
  reactions += {
    case ButtonClicked(HomeButton) => applet.showMain
    case ButtonClicked(PlayButton) => applet.showGame
  }
}