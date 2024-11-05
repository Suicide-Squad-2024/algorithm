const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const N = input[1].split(' ').map(Number)
let res = new Array(N.length).fill(0)
res[0] = N[0]

for (let i = 1; i < N.length; i++) {
    res[i] = Math.max(N[i], res[i - 1] + N[i])
}

console.log(Math.max(...res))