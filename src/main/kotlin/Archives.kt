import java.util.*


class Archives (name : String): SystemMenu, Item(name) {
    override val listOfItems: MutableList<Archive> = mutableListOf(Archive("Создать архив"), Archive("Выход"))
    override fun createNewItem() {
        var scanner = Scanner(System.`in`)
        var archiveEnd = listOfItems.get(listOfItems.size-1)
        println("Введите имя нового архива:")
        listOfItems.set(listOfItems.size-1, Archive(scanner.nextLine()))
        listOfItems.add(archiveEnd)
        showMenu()
        processChoice(fillInChoice())
    }
}