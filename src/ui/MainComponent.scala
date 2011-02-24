package ui
import swing._
import event._

/**
 * Created by IntelliJ IDEA.
 * User: shadaj
 * Date: 2/23/11
 * Time: 8:51 PM
 * To change this template use File | Settings | File Templates.
 */

class MainComponent(applet: StatesApplet) extends BoxPanel(Orientation.Vertical) {
  val Play = new Button {
    text = "Play"

  }
  val HowTo = new Button {
    text = "How to Play"
  }
  contents += Play
  contents +=  HowTo

  border = Swing.EmptyBorder(30, 20, 20, 20)
  listenTo(Play)
  listenTo(HowTo)
  reactions += {
    case ButtonClicked(Play) => applet.showGame
    case ButtonClicked(HowTo) => applet.showHowto
  }

}