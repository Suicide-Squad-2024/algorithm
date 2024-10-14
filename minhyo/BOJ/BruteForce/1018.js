

const fs = require('fs');


const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

let chess = []

for (let i = 1; i < input.length; i++) {
    let tmp = input[i].split('')
    chess.push(tmp)
}

let N, M = input[0].split(' ').map(Number)

let a = M[0] - 7
let b = M[1] - 7
let result = []
for (let i = 0; i < a; i++) {
    for (let j = 0; j < b; j++) {
        check(i, j)
    }
}

function check(a, b) {
    let bf = 0
    let wf = 0
    for (let i = a; i < 8 + a; i++) {
        for (let j = b; j < 8 + b; j++) {
            if (i % 2 === 0 && j % 2 === 0 && chess[i][j] != 'B') {
                bf++
            }
            if (i % 2 === 0 && j % 2 === 1 && chess[i][j] != 'W') {
                bf++
            }
            if (i % 2 === 1 && j % 2 === 0 && chess[i][j] != 'W') {
                bf++
            }
            if (i % 2 === 1 && j % 2 === 1 && chess[i][j] != 'B') {
                bf++
            }

            if (i % 2 === 0 && j % 2 === 0 && chess[i][j] != 'W') {
                wf++
            }
            if (i % 2 === 0 && j % 2 === 1 && chess[i][j] != 'B') {
                wf++
            }
            if (i % 2 === 1 && j % 2 === 0 && chess[i][j] != 'B') {
                wf++
            }
            if (i % 2 === 1 && j % 2 === 1 && chess[i][j] != 'W') {
                wf++
            }
        }
    }
    result.push(bf)
    result.push(wf)
}

console.log(Math.min(...result))