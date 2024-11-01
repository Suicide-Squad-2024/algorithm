function solution(numbers, target) {
    let answer = 0;

    const q = [[0, 0]];
    let start = 0;
    let end = 1;

    while (start < end) {
        const [sum, index] = q[start++];

        if (index === numbers.length) {
            if (sum === target) {
                answer += 1;
            }
        } else {
            q[end++] = [sum + numbers[index], index + 1];
            q[end++] = [sum - numbers[index], index + 1];
        }
    }

    return answer;
}

console.log(solution([1, 1, 1, 1, 1], 3));
console.log(solution([4, 1, 2, 1], 4));

