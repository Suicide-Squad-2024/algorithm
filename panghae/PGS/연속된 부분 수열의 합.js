function solution(sequence, k) {
    let answer = [];

    let start = 0;
    let end = 0;
    let sum = 0;
    let minLength = Infinity;

    while (end < sequence.length) {
        sum += sequence[end];

        while (sum > k && start <= end) {
            sum -= sequence[start];
            start += 1;
        }

        if (sum === k) {
            const currentLength = end - start + 1;
            if (currentLength < minLength) {
                minLength = currentLength;
                answer = [start, end];
            }
        }
        end += 1;
    }
    return answer;
}

console.log(solution([1, 2, 3, 4, 5], 7));
console.log(solution([1, 1, 1, 2, 3, 4, 5], 5));
console.log(solution([2, 2, 2, 2, 2], 6));