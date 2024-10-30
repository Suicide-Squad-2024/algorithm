function solution(priorities, location) {
    let answer = 0;

    const q = priorities.map((value, index) => [value, index]);
    let answerCount = 0;

    while (q.length) {
        const [pri, loc] = q.shift();
        const qMax = Math.max(...q.map(value => value[0]));
        if (pri < qMax) {
            q.push([pri, loc]);
        } else {
            answerCount += 1;
            if (location === loc) {
                answer = answerCount;
                break;
            }
        }
    }
    return answer;
}

console.log(solution([2, 1, 3, 2], 2));
console.log(solution([1, 1, 9, 1, 1, 1], 0));