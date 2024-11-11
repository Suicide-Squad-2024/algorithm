const fs = require('fs');


const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const [N, M] = input[0].split(' ').map(Number)

let vis = new Array(N).fill(false)

let arr = []


function dfs(depth) {
    if (depth === M) {
        console.log(arr.join(' '))
        return
    }

    for (let i = 0; i < N; i++) {
        if (!vis[i]) {
            vis[i] = true;
            arr.push(i + 1)
            dfs(depth + 1)
            arr.pop()
            vis[i] = false
        }
    }
}

dfs(0)

