const fs = require('fs')

const input = Number(fs.readFileSync('/dev/stdin').toString().trim())

let dp = new Array(input + 1).fill(0)

for (let i = 2; i < input + 1; i++) {
    dp[i] = dp[i - 1] + 1

    if (i % 2 === 0) {
        dp[i] = Math.min(dp[i], dp[i / 2] + 1)
    }

    if (i % 3 === 0) {
        dp[i] = Math.min(dp[i], dp[i / 3] + 1)
    }
}

console.log(dp[input])

//bottom-up으로 생각
//dp 배열에 최소 연산 횟수를 저장한다.진한 값(더 작은 값)이 해당 인덱스에 저장된다.

//    dp[1]: 시작점이니 0
// dp[2]: 2에서 1을 빼면 1 ➡ dp[1] + 1(1) / 2에서 2를 나누면 1 ➡ dp[1] + 1(1)
// dp[3]: 3에서 1을 빼면 2 ➡ dp[2] + 1(2) / 3에서 3을 나누면 1 ➡ dp[1] + 1(1)
// dp[4]: 4에서 1을 빼면 3 ➡ dp[3] + 1(2) / 4에서 2를 나누면 2 ➡ dp[2] + 1(2)
// dp[9]: 9에서 1을 빼면 8 ➡ dp[8] + 1(3) / 9에서 3을 나누면 3 ➡ dp[3] + 1(2)
// dp[10]: 10에서 1을 빼면 9 ➡ dp[9] + 1(3) / 10에서 2를 나누면 5 ➡ dp[5] + 1(4)

