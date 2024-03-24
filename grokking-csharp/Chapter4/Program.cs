using Microsoft.VisualBasic.CompilerServices;

Console.WriteLine($"Recursive sum result: {RecursiveSum(new [] {1,5,3})}");
Console.WriteLine($"Generic recursive sum result: {GenericRecursiveSum(new [] {"a","bb","ccc"})}");
return;

int RecursiveSum(int[] array) =>
    array.Length == 0 ? 0 : array[0] + RecursiveSum(new List<int>(array).Skip(1).ToArray());

T? GenericRecursiveSum<T>(T[] array) where T : class =>
    array.Length == 0 ? null : (T)Operators.AddObject(array[0],GenericRecursiveSum(new List<T>(array).Skip(1).ToArray()))!; 

// Generic one looks strange :D