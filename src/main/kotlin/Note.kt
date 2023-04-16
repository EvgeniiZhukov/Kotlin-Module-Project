

class Note(name : String) : Item(name), SystemMenu {
    override val listOfItems: MutableList<out SystemMenu>
        get() = TODO("Not yet implemented")
    var text = ""
}