const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const N = Number(input[0])
const A = input[1].split(' ').map(Number)


const inDp = new Array(N).fill(1)
const deDp = new Array(N).fill(1)

for (let i = 1; i < N; i++) {
    for (let j = 0; j < i; j++) {
        if (A[j] < A[i]) {
            inDp[i] = Math.max(inDp[i], inDp[j] + 1)
        }
    }
}

for (let i = N - 2; i >= 0; i--) {
    for (let j = N - 1; j > i; j--) {
        if (A[j] < A[i]) {
            deDp[i] = Math.max(deDp[i], deDp[j] + 1)
        }
    }
}

let result = 0

for (let j = 0; j < N; j++) {
    result = Math.max(result, inDp[j] + deDp[j] - 1)
}
console.log(result)