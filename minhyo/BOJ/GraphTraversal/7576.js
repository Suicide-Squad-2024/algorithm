const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const [M, N] = input[0].split(' ').map(Number)

const board = []

for (let i = 1; i < input.length; i++) {
    let tmp = input[i].split(' ').map(Number)
    board.push(tmp)
}


let check = Array.from(Array(N), () => new Array(M).fill(true))


const dx = [1, -1, 0, 0]
const dy = [0, 0, 1, -1]

let queue = []
let tT = 0
let rT = 0

for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
        if (board[i][j] === 1) {
            queue.push([i, j])
            rT++
        }
        if (board[i][j] !== -1) {
            tT++
        }
    }
}

let day = -1

while (queue.length > 0) {
    let nQueue = []

    for (let i = 0; i < queue.length; i++) {
        const [x, y] = queue[i]
        for (let j = 0; j < 4; j++) {
            const nx = x + dx[j]
            const ny = y + dy[j]
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] === 0) {
                board[nx][ny] = 1
                nQueue.push([nx, ny])
                rT++
            }
        }
    }
    queue = nQueue
    day++
}

if (rT === tT) {
    console.log(day)
} else {
    console.log(-1)
}