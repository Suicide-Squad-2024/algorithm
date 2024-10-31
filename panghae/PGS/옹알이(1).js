function solution(babbling) {
    let answer = 0;
    const words = new Set();

    const permutation = (arr, num) => {
        const res = [];
        if (num === 1) {
            return arr.map((value) => [value]);
        }

        arr.forEach((value, index, self) => {
            const resultArr = [...self.slice(0, index), ...self.slice(index + 1)];
            const permutationResult = permutation(resultArr, num - 1);
            const attach = permutationResult.map((v) => [value, ...v]);
            res.push(...attach);
        });

        return res;
    };

    for (let i = 1; i <= 4; i += 1) {
        const result = permutation(['aya', 'ye', 'woo', 'ma'], i)
        for (const r of result) {
            words.add(r.join(''));
        }
    }

    for (const babble of babbling) {
        if (words.has(babble)) {
            answer += 1;
        }
    }

    return answer;
}

console.log(solution(["aya", "yee", "u", "maa", "wyeoo"]));
console.log(solution(["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]));