import java.util.*


class Archive(name: String) : Item(name) , SystemMenu{
    override val listOfItems = mutableListOf(Note("Создать заметку"),Note("Назад"))
    override fun createNewItem() {
        var scanner = Scanner(System.`in`)
        var archiveEnd = listOfItems.get(listOfItems.size-1)
        println("Введите имя новой заметки:")
        listOfItems[listOfItems.size-1] = Note(scanner.nextLine())
        println("Введите текст заметки:")
        listOfItems[listOfItems.size-1].text =scanner.nextLine()
        listOfItems.add(archiveEnd)
        showMenu()
        processChoice(fillInChoice())
    }

    override fun showItem(index: Int) {
        println("Имя заметки :"+ listOfItems[index])
        println("Содержание заметки: ")
        println(listOfItems[index].text)
        println("=====конец заметки=====")
        showMenu()
        processChoice(fillInChoice())
    }
}