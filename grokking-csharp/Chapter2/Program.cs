Console.WriteLine("Selection sort result:");

foreach (var i in SelectionSort(new[] { 5, 4, 2, 3, 1 }))
{
    Console.WriteLine(i);
}

Console.WriteLine("Generic selection sort result:");

foreach (var i in GenericSelectionSort(new[] { "aaa", "a", "aa", "aaaaa", "aaaa" }))
{
    Console.WriteLine(i);
}

int FindSmallest(int[] array)
{
    var smallest = array.First();
    var smallestIndex = 0;
    
    for (var i = 0; i < array.Length; i++)
    {
        if (array[i] < smallest)
        {
            smallest = array[i];
            smallestIndex = i;
        }
    }

    return smallestIndex;
}

int[] SelectionSort(int[] array)
{
    var temp = new List<int>(array);
    var result = new List<int>();
    
    for (var i = 0; i < result.Count + temp.Count; i++)
    {
        var smallest = FindSmallest(array);
        result.Add(array[smallest]);
        temp.RemoveAt(smallest);
        array = temp.ToArray();
    }

    return result.ToArray();
}

int GenericFindSmallest<T>(T[] array) where T : IComparable
{
    var smallest = array.First();
    var smallestIndex = 0;
    
    for (var i = 0; i < array.Length; i++)
    {
        if (array[i].CompareTo(smallest) < 0)
        {
            smallest = array[i];
            smallestIndex = i;
        }
    }

    return smallestIndex;
}

T[] GenericSelectionSort<T>(T[] array) where T: IComparable
{
    var temp = new List<T>(array);
    var result = new List<T>();
    
    for (var i = 0; i < result.Count + temp.Count; i++)
    {
        var smallest = GenericFindSmallest(array);
        result.Add(array[smallest]);
        temp.RemoveAt(smallest);
        array = temp.ToArray();
    }

    return result.ToArray();
}