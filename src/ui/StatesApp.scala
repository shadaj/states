package ui

import swing._

/**
 * Created by IntelliJ IDEA.
 * User: shadaj
 * Date: 1/15/11
 * Time: 9:28 PM
 * To change this template use File | Settings | File Templates.
 */

object StatesApp extends SimpleSwingApplication {
  def top = new MainFrame {
    contents = new StatesComponent
  }
}