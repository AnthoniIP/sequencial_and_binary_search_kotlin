fun main() {

    val randomList = generateList(quantity = 99, maxValue = 200)

    val positionsSequencial = sequencialSearch(searchValue = 15, intList = randomList)
    val positionsBinary = binarySearch(searchValue = 15, intList = quicksort(randomList))

    println(randomList)
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


fun binarySearch(intList: List<Int>, searchValue: Int): Int {

    var low = 0
    var high = intList.size - 1
    var mid: Int
    while (low <= high) {
        mid = low + ((high - low) / 2)
        when {
            searchValue > intList[mid] -> low =
                mid + 1    // element is greater than middle element of array, so it will be in right half of array
            searchValue == intList[mid] -> return mid // found the element
            searchValue < intList[mid] -> high =
                mid - 1   //element is less than middle element of array, so it will be in left half of the array.
        }
    }
    return -1
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

    for (number in 0 .. quantity) {
        val randomNumber = (0..maxValue).random()
        list.add(randomNumber)

    }
    return list


}