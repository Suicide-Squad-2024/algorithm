const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')
const N = parseInt(input[0])



let path = []
const visited = Array.from({ length: N }, () => Array(N).fill(false))
for (let i = 1; i < input.length; i++) {
    let tmp = input[i].split('').map(Number)
    path.push(tmp)
}


const dx = [-1, 1, 0, 0]; //상하좌우우
const dy = [0, 0, -1, 1]


function bfs(x, y) {
    const queue = [[x, y]]
    visited[x][y] = true
    let count = 1

    while (queue.length > 0) {
        const [cx, cy] = queue.shift()

        for (let i = 0; i < 4; i++) {
            const nx = cx + dx[i]
            const ny = cy + dy[i]

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (path[nx][ny] === 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true
                    queue.push([nx, ny])
                    count++
                }
            }
        }
    }
    return count
}
let res = []


for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
        if (path[i][j] === 1 && !visited[i][j]) {
            res.push(bfs(i, j))
        }
    }
}

res.sort((a, b) => a - b)

console.log(res.length)
res.forEach(count => console.log(count))