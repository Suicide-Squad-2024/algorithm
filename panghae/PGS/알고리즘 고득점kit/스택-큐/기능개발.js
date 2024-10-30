function solution(progresses, speeds) {
    let answer = [];
    let days = 0;

    const q = progresses.map((value, index) => [value, speeds[index]]);

    let tmpCount = 0;

    while (q.length) {
        const [currentWork, workPerDay] = q[0];
        if (currentWork + days * workPerDay >= 100) {
            tmpCount += 1;
            q.shift();
        } else {
            if (tmpCount) {
                answer.push(tmpCount);
                tmpCount = 0;
            }
            days += Math.ceil((100 - (currentWork + days * workPerDay)) / workPerDay);
        }
    }
    answer.push(tmpCount);

    return answer;
}

console.log(solution([93, 30, 55], [1, 30, 5]));
console.log(solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1]));