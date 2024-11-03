const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const T = Number(input[0])
input.shift()

for (let i = 0; i < T; i++) {
    const [M, N, K] = input[0].split(' ').map(Number)

    let board = Array.from(Array(M), () => new Array(N).fill(0))

    for (let i = 1; i < K + 1; i++) {
        let [x, y] = input[i].split(' ').map(Number)
        board[x][y] = 1
    }

    let check = Array.from(Array(M), () => new Array(N).fill(true))


    const dx = [-1, 1, 0, 0]
    const dy = [0, 0, -1, 1]

    let count = 0

    function bfs(x, y) {
        const queue = [[x, y]]
        check[x][y] = false

        while (queue.length > 0) {
            const [cx, cy] = queue.shift()
            for (let i = 0; i < 4; i++) {
                const nx = cx + dx[i]
                const ny = cy + dy[i]

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (board[nx][ny] === 1 && check[nx][ny]) {
                        check[nx][ny] = false
                        queue.push([nx, ny])
                    }
                }
            }
        }
        count++
    }

    for (let i = 0; i < M; i++) {
        for (let j = 0; j < N; j++) {
            if (board[i][j] === 1 && check[i][j]) {
                bfs(i, j)
            }
        }
    }

    console.log(count)
    if (i < T - 1) {
        for (let i = 0; i < K + 1; i++) {
            input.shift()
        }
    }
}
