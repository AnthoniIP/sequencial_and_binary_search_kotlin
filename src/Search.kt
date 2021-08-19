fun main() {

    val randomList = generateList(quantity = 99, maxValue = 200)
    val orderedList = quicksort(randomList)

    val positionsSequencial = sequencialSearch(searchValue = 15, intList = orderedList)
    val positionsBinary = binarySearch(searchValue = 15, intList = orderedList)

    println("Lista aleatória: $randomList")
    println("Lista ordenada: $orderedList")
    println("indices encontrados [Sequencial]: $positionsSequencial")
    println("indices encontrados [Binária]: $positionsBinary")


}

fun sequencialSearch(searchValue: Int, intList: List<Int>): List<Int> {

    val positionList = mutableListOf<Int>()

    for (position in intList.indices) {
        if (intList[position] == searchValue) {
            positionList.add(position)

        } else {
            if (position == intList.size) println("Não encontrou o número : $searchValue")
        }
    }

    return positionList

}


private fun binarySearch(searchValue: Int, intList: List<Int>): List<Int> {

    val positionList = mutableListOf<Int>()

    var low = 0
    var high = intList.size - 1
    var mid: Int

    while (low <= high) {
        mid = (low + high) / 2
        if (searchValue < intList[mid]) {
            high = mid - 1
        } else if (searchValue >= intList[mid]) {
            low = mid + 1
        } else {
            positionList.add(intList[mid])
            high = mid - 1
        }
    }
    return positionList
}

fun quicksort(items: List<Int>): List<Int> {
    if (items.count() < 2) {
        return items
    }
    val pivot = items[items.count() / 2]

    val equal = items.filter { it == pivot }


    val less = items.filter { it < pivot }


    val greater = items.filter { it > pivot }

    return quicksort(less) + equal + quicksort(greater)
}


fun generateList(quantity: Int, maxValue: Int): List<Int> {


    val list = mutableListOf<Int>()

    for (number in 0..quantity) {
        val randomNumber = (0..maxValue).random()
        list.add(randomNumber)

    }
    return list


}