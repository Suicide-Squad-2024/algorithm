const fs = require('fs')

const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const N = Number(input[0])
const path = []


for (let i = 1; i < input.length; i++) {
    path.push(input[i].split(' ').map(Number))
}

path.sort((a, b) => a[0] - b[0])


const bPath = []

for (let i = 0; i < N; i++) {
    bPath.push(path[i][1])
}

const dp = new Array(N).fill(1)

for (let i = 1; i < N; i++) {
    for (let j = 0; j < i; j++) {
        if (bPath[j] < bPath[i]) {
            dp[i] = Math.max(dp[i], dp[j] + 1)
        }
    }
}


console.log(N - Math.max(...dp))