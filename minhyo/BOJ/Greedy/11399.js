const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const N = Number(input[0])

let P = input[1].split(' ').map(Number)
P.sort((a, b) => a - b)

let res = 0
for (let i = N - 1; i >= 0; i--) {
    let tmp = 0
    for (let j = 0; j < N - i; j++) {
        tmp += P[j]
    }
    res += tmp
}
console.log(res)