function closestToLeft(arr, queries) {
    return queries.map(query => {
        let left = 0, right = arr.length;
        
        while (left < right) {
            let mid = Math.floor((left + right) / 2);
            if (arr[mid] <= query) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left > 0 ? left : 0;
    });
}

// Ejemplo de uso
const array = [3, 3, 5, 8, 9];
const queries = [2, 4, 8, 1, 10];
console.log(closestToLeft(array, queries));  // Output esperado: [0, 2, 4, 0, 5]
