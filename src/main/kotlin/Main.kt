fun main() {
    val startScreen = Archives("Start")
    Navigator.setOfScreens.add(startScreen)
    Navigator.setOfScreens.last().showMenu()
    Navigator.setOfScreens.last().processChoice(Navigator.setOfScreens.last().fillInChoice())
}

