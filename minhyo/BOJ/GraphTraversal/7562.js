const fs = require('fs')

const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const T = Number(input[0])
input.shift()
const dx = [1, 2, 2, 1, -1, -2, -2, -1]
const dy = [-2, -1, 1, 2, 2, 1, -1, -2]

for (let i = 0; i < T; i++) {

    let I = Number(input[0])
    let [sx, sy] = input[1].split(' ').map(Number)
    let [px, py] = input[2].split(' ').map(Number)

    input.splice(0, 3);

    let board = Array.from(Array(I), () => Array(I).fill(-1))
    function bfs(x, y) {
        let queue = [[x, y]]
        board[x][y] = 0
        while (queue.length > 0) {

            let [cx, cy] = queue.shift()
            if (cx === px && cy === py) {
                return board[cx][cy];
            }

            for (let j = 0; j < 8; j++) {
                const nx = cx + dx[j]
                const ny = cy + dy[j]

                if (nx >= 0 && nx < I && ny >= 0 && ny < I && board[nx][ny] === -1) {
                    board[nx][ny] = board[cx][cy] + 1
                    queue.push([nx, ny])
                }
            }
        }
        return -1
    }

    console.log(bfs(sx, sy))


}