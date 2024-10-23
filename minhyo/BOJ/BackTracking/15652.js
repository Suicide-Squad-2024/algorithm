const fs = require('fs');


const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const [N, M] = input[0].split(' ').map(Number)


let arr = []
let result = []

function dfs(start, depth) {
    if (depth === M) {
        result.push(arr.join(' '))
        return
    }

    for (let i = start; i < N; i++) {
        arr.push(i + 1)
        dfs(i, depth + 1)
        arr.pop()

    }
}

dfs(0, 0)

console.log(result.join('\n'))