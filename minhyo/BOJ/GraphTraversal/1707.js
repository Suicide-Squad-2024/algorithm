const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')


const K = Number(input[0])
let index = 1

for (let i = 0; i < K; i++) {
    let [V, E] = input[index].split(' ').map(Number)
    index++
    let path = new Array(V)
    for (let i = 0; i < V; i++) {
        path[i] = []
    }
    for (let i = 0; i < E; i++) {
        let [u, v] = input[index].split(' ').map(Number)
        path[u - 1].push(v - 1)
        path[v - 1].push(u - 1)
        index++
    }

    let color = new Array(V).fill(-1)

    let result = true


    function bfs(x) {
        let queue = [x]
        color[x] = 0

        while (queue.length > 0) {
            let nx = queue.shift()
            for (let n of path[nx]) {
                if (color[n] === -1) {
                    color[n] = 1 - color[nx]
                    queue.push(n)
                } else if (color[n] === color[nx]) {
                    result = false
                    return
                }
            }

        }
    }
    for (let j = 0; j < V; j++) {
        if (color[j] === -1) {
            bfs(j)
            if (!result) break
        }
    }
    console.log(result ? "YES" : "NO")
}