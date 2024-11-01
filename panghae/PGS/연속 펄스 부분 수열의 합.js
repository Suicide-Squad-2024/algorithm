function solution(sequence) {
    let answer = -Infinity;
    let pulse = 1;
    let first = 0;
    let second = 0;
    let firstMin = 0;
    let secondMin = 0;

    sequence.forEach((value, index) => {
        first += value * pulse;
        second += value * -pulse;

        answer = Math.max(answer, first - firstMin, second - secondMin);

        firstMin = Math.min(first, firstMin);
        secondMin = Math.min(second, secondMin);

        pulse *= -1;
    });

    return answer;
}

console.log(solution([2, 3, -6, 1, 3, -1, 2, 4]));

// 2 -3 -6 -1 3 1 2 -4
// -2 3 6 1 -3 -1 -2 4