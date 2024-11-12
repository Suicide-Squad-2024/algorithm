const fs = require('fs')

const [A, B] = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const a = A.split('')
const b = B.split('')

let dp = Array.from(new Array(a.length + 1), () => Array(b.length + 1).fill(0))

let maxLength = 0


for (let i = 1; i <= a.length; i++) {
    for (let j = 1; j <= b.length; j++) {
        if (a[i - 1] == b[j - 1]) {
            dp[i][j] = dp[i - 1][j - 1] + 1
            maxLength = Math.max(maxLength, dp[i][j])
        } else {
            dp[i][j] = 0
        }
    }
}
console.log(maxLength)