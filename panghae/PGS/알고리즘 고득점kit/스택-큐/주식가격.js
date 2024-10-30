function solution(prices) {
    let answer = Array(prices.length).fill(0);

    let stack = [];

    for (let i = 0; i < prices.length; i += 1) {
        if (stack.length) {
            while (stack.length) {
                if (stack.at(-1)[0] > prices[i]) {
                    const [, inputIndex] = stack.pop();
                    answer[inputIndex] = i - inputIndex;
                } else {
                    break
                }
            }
            stack.push([prices[i], i]);
        } else {
            stack.push([prices[i], 0]);
        }
    }

    while (stack.length) {
        const [, inputIndex] = stack.pop();
        answer[inputIndex] = prices.length - 1 - inputIndex;
    }
    return answer;
}

console.log(solution([1, 2, 3, 2, 3]));
console.log(solution([5, 4, 3, 2, 1]));