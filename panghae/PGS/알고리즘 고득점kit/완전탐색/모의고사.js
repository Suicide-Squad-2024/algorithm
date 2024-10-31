function solution(answers) {
    let answerLength = answers.length;
    const correctCount = [0, 0, 0];
    const first = [1, 2, 3, 4, 5];
    const second = [2, 1, 2, 3, 2, 4, 2, 5];
    const third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

    for (let i = 0; i < answerLength; i += 1) {
        if (answers[i] === first[i % first.length]) {
            correctCount[0] += 1;
        }
        if (answers[i] === second[i % second.length]) {
            correctCount[1] += 1;
        }
        if (answers[i] === third[i % third.length]) {
            correctCount[2] += 1;
        }
    }
    const answer = [];
    const maxCorrect = Math.max(...correctCount);
    correctCount.forEach((count, index) => {
        if (count === maxCorrect) {
            answer.push(index + 1);
        }
    });

    return answer;
}

console.log(solution([1, 2, 3, 4, 5]));
console.log(solution([1, 3, 2, 4, 2]));