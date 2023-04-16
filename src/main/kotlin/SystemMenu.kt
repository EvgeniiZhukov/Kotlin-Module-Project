import java.util.*


interface SystemMenu {
    abstract val name : String
    abstract val listOfItems : MutableList<out SystemMenu>
    fun fillInChoice() : Int {
        var scanner = Scanner(System.`in`)
        var choice : Int
        while(true){
            if (scanner.hasNextInt()){
                choice = scanner.nextLine().toInt()
                if(0<=choice && choice<=listOfItems.size-1){
                    break
                }
                println("Введите число от 0 до" + (listOfItems.size - 1))
            }
            else{
                println("Вы должны ввести именно число, а не текст")
                scanner.nextLine()
            }
        }
        return choice
    }
    fun processChoice(index : Int) {
        when(index){
            0 -> createNewItem()
            listOfItems.size-1 -> exit()
            else -> showItem(index)
        }
    }

    fun showMenu() {
        for(i in 0 until listOfItems.size){
            println("$i. " + listOfItems[i])
        }
    }
    fun exit() {
        Navigator.setOfScreens.remove(this)
        if(Navigator.setOfScreens.isNotEmpty()){
            Navigator.setOfScreens.last().showMenu()
            Navigator.setOfScreens.last().processChoice(Navigator.setOfScreens.last().fillInChoice())
        }
        println("До свидания!")
    }
    fun createNewItem() {

    }
    fun showItem(index : Int) {
        Navigator.setOfScreens.add(listOfItems[index])
        Navigator.setOfScreens.last().showMenu()
        Navigator.setOfScreens.last().processChoice(Navigator.setOfScreens.last().fillInChoice())
    }
}