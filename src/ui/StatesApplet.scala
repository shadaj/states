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

  object ui extends UI {

    contents = new StatesComponent

    def init(): Unit = {}
  }

}
