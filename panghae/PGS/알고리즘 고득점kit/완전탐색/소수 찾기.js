function solution(numbers) {
    let answer = 0;
    const numberArray = numbers.split('').map(value => Number(value));

    const permutation = (arr, num) => {
        const res = [];
        if (num === 1) {
            return arr.map(v => [v]);
        }

        arr.forEach((v, index, self) => {
            const rest = [...self.slice(0, index), ...self.slice(index + 1)];
            const permutations = permutation(rest, num - 1);
            const attach = permutations.map(permutation => [v, ...permutation]);
            res.push(...attach);
        });

        return res;
    };

    const isPrimeNumber = (number) => {
        let result = true;
        if (number === 1 || number === 0) {
            return false;
        }
        for (let i = 2; i <= Math.floor(Math.sqrt(number)); i += 1) {
            if (number % i === 0) {
                result = false;
                break;
            }
        }
        return result;
    };

    for (let i = 1; i <= numbers.length; i += 1) {
        const result = permutation(numberArray, i);
        const uniqueResult = Array.from(new Set(result.map(JSON.stringify)), JSON.parse)
        for (const item of uniqueResult) {
            if (item[0] === 0) {
                continue;
            }
            if (isPrimeNumber(Number(item.join('')))) {
                answer += 1;
            }
        }
    }
    return answer;
}

console.log(solution("17"));
console.log(solution("011"));

