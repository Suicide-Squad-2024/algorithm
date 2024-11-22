const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const [N, B] = input[0].split(' ').map(Number)

const ma = []

for (let i = 1; i < input.length; i++) {
    let tmp = input[i].split(' ').map(Number)
    for (let j = 0; j < tmp.length; j++) {
        tmp[j] = tmp[j] % 1000
    }
    ma.push(tmp)
}

const result = pow(ma, B);
result.forEach(row => console.log(row.join(' ')));

function pow(A, exp) {
    if (exp === 1) {
        return A.map(row => row.map(val => val % 1000))
    }
    let half = pow(A, Math.floor(exp / 2))

    res = mPow(half, half)

    if (exp % 2 === 1) {
        res = mPow(res, ma)
    }
    return res
}


function mPow(o1, o2) {
    let res = Array.from(Array(N), () => Array(N).fill(0))

    for (let i = 0; i < N; i++) {
        for (let j = 0; j < N; j++) {
            for (let k = 0; k < N; k++) {
                res[i][j] += o1[i][k] * o2[k][j]
                res[i][j] = res[i][j] % 1000
            }
        }
    }
    return res
}