function closestToRight(arr, queries) {
    let results = [];

    queries.forEach(query => {
        let left = 0, right = arr.length - 1, answer = -1;

        while (left <= right) {
            let mid = Math.floor((left + right) / 2);

            if (array[mid] >= query) {
                answer = mid; // este índice es candidato para la respuesta
                right = mid - 1; // buscamos más a la izquierda
            } else {
                left = mid + 1; // descartamos la mitad izquierda
            }
        }

        // Si no encontramos un índice válido, devolvemos n + 1; en caso contrario, el índice es +1 para 1-based
        results.push(answer === -1 ? arr.length + 1 : answer + 1);
    });

    return results;
}

// Ejemplo de uso
const array = [3, 3, 5, 8, 9];
const queries = [2, 4, 8, 1, 10];
console.log(closestToRight(array, queries));