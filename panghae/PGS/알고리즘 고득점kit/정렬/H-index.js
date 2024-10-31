function solution(citations) {
    let answer = 0;
    citations.sort((a, b) => b - a);
    console.log(citations);

    citations.forEach((value, index) => {
        if ((index + 1) <= value) {
            answer = index + 1;
        }
    });

    return answer;
}

console.log(solution([3, 0, 6, 1, 5]));
console.log(solution([4, 2, 6, 10, 7, 4]))