const fs = require('fs')

const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map(Number)

let dp = new Array(input[0] + 1).fill(0)

if (input[0] === 1) {
    console.log(input[1])
    process.exit(0)
}
else if (input[0] === 2) {
    console.log(input[1] + input[2])
    process.exit(0)
}

dp[1] = input[1]
dp[2] = input[1] + input[2]

for (let i = 3; i < input[0] + 1; i++) {
    dp[i] = Math.max(dp[i - 2] + input[i], dp[i - 3] + input[i] + input[i - 1])
}

console.log(dp[dp.length - 1])

// i번째 계단을 밟았을 경우, i-2계단을 밟고, 2계단 올라온 경우가 있을 수 있고, i - 3계단을 밟고, 2계단을 올라와(i - 2계단을 건너 뛰고) i - 1 계단을 밟고, i계단을 밟는 경우가 있다.