const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n').map(Number)
const n = input[0]
const wines = input.slice(1)

let dp = new Array(n).fill(0)

dp[0] = wines[0]
if (n > 1) dp[1] = wines[0] + wines[1]
if (n > 2) dp[2] = Math.max(wines[0] + wines[2], wines[1] + wines[2], dp[1])

for (let i = 3; i < n; i++) {
    dp[i] = Math.max(dp[i - 1], dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i])
}

console.log(dp[n - 1])
