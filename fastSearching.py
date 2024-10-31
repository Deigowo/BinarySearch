import bisect

def fast_searching(arr, queries):
    results = []
    for left, right in queries:
        left_index = bisect.bisect_left(arr, left)
        right_index = bisect.bisect_right(arr, right) - 1
        count = max(0, right_index - left_index + 1)
        results.append(count)
    return results

# Ejemplo de uso
arr = [1, 3, 5, 7, 9]
queries = [(1, 5), (4, 9), (2, 6)]
print(fast_searching(arr, queries))  # Output esperado: [3, 3, 2]
