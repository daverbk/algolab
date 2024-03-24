Console.WriteLine($"Result of successful binary search: {BinarySearch(new [] {1,3,5,7,9}, 3)}");
Console.WriteLine($"Result of unsuccessful binary search: {BinarySearch(new [] {1,3,5,7,9}, -1)}");

Console.WriteLine($"Result of successful generic binary search: {GenericBinarySearch(new [] {"ar","var","sara","larack","stipendium"}, "sara")}");
Console.WriteLine($"Result of unsuccessful generic binary search: {GenericBinarySearch(new [] {"ar","var","sara","larack","stipendium"}, "a")}");

int BinarySearch(int[] array, int item)
{
    var low = 0;
    var high = array.Length - 1;

    while (low <= high)
    {
        var mid = (low + high) / 2;
        var guess = array[mid];

        if (guess == item)
        {
            return mid;
        }

        if (guess > item)
        {
            high = mid - 1;
        }

        else
        {
            low = mid + 1;
        }
    }

    // -1 means the absence of an item
    return -1;
}

int GenericBinarySearch<T>(IEnumerable<T> list, T item) where T : IComparable<T>
{
    var enumerable = list.ToArray();
    
    var low = 0;
    var high = enumerable.Length - 1;
    
    while (low <= high)
    {
        var mid = (low + high) / 2;
        var guess = enumerable[mid];

        if (guess.CompareTo(item) == 0)
        {
            return mid;
        }

        if (guess.CompareTo(item) > 0)
        {
            high = mid - 1;
        }

        else
        {
            low = mid + 1;
        }
    }
    
    // -1 means the absence of an item
    return -1;
}