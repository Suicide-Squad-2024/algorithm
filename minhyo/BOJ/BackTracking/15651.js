const fs = require('fs');


const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const [N, M] = input[0].split(' ').map(Number)

let vis = new Array(N).fill(false)

let arr = []
let result = []

function dfs(depth) {
    if (depth === M) {
        result.push(arr.join(' '))
        return
    }

    for (let i = 0; i < N; i++) {
        if (!vis[i]) {
            arr.push(i + 1)
            dfs(depth + 1)
            arr.pop()
        }

    }
}

dfs(0)

console.log(result.join('\n')) //바로바로 출력하면 시간초과, 한번에 출력하는 것을 습관화하도록 하자