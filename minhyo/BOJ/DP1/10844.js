const fs = require('fs')

const input = Number(fs.readFileSync("/dev/stdin").toString().trim())
let dp = Array.from(Array(input + 1), () => new Array(10).fill(0))
const MOD = 1000000000

for (let i = 1; i < 10; i++) {
    dp[1][i] = 1
}

for (let i = 2; i <= input; i++) {
    for (let j = 0; j < 10; j++) {
        if (j === 0) {
            dp[i][j] = dp[i - 1][1] % MOD
        }
        else if (j === 9) {
            dp[i][j] = dp[i - 1][8] % MOD
        }
        else {
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD
        }
    }
}

let sum = dp[input].reduce((a, b) => (a + b) % MOD, 0)

console.log(sum)
