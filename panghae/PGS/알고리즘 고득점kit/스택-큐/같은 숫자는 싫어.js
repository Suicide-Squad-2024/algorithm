function solution(arr) {
    let answer = [];

    for (let i = 0; i < arr.length; i += 1) {
        if (answer.at(-1) !== arr[i]) {
            answer.push(arr[i]);
        }
    }

    return answer;
}

console.log(solution([1, 1, 3, 3, 0, 1, 1], [1, 3, 0, 1]));
console.log(solution([4, 4, 4, 3, 3], [4, 3]));