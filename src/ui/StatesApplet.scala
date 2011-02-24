package ui

import swing._

/**
 * Created by IntelliJ IDEA.
 * User: shadaj
 * Date: 1/15/11
 * Time: 9:41 PM
 * To change this template use File | Settings | File Templates.
 */

class StatesApplet extends Applet {
  def showMain {
    ui.contents = new MainComponent(this)
  }

  def showHowto {
    ui.contents = new HowToComponent(this)
  }

  def showGame {
    ui.contents = new StatesComponent(this)
  }

  object ui extends UI {


    def init(): Unit = {showMain}
  }

}
