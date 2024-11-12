const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const [N, K] = input[0].split(' ').map(Number)

let WV = []

for (let i = 1; i < input.length; i++) {
    let tmp = input[i].split(' ').map(Number)
    WV.push(tmp)
}
let dp = Array(K + 1).fill(0)

for (let [W, V] of WV) {
    console.log(W, V)
    for (let i = K; i >= W; i--) {
        dp[i] = Math.max(dp[i], dp[i - W] + V)
    }
}



console.log(dp[K])