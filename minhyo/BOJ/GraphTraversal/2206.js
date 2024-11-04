const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const [N, M] = input[0].split(' ').map(Number)
const path = []

for (let i = 1; i < input.length; i++) {
    path.push(input[i].split('').map(Number))
}


const dx = [1, -1, 0, 0]
const dy = [0, 0, 1, -1]
const check = Array.from(Array(N), () => Array.from(Array(M), () => Array(2).fill(-1)))

class Deque {
    constructor() {
        this.data = []
        this.head = 0
        this.tail = 0
    }

    push(value) {
        this.data[this.tail++] = value
    }

    shift() {
        if (this.size() === 0) return undefined
        const value = this.data[this.head]
        delete this.data[this.head++]
        return value
    }

    size() {
        return this.tail - this.head
    }
}

function bfs() {
    let queue = new Deque
    queue.push([0, 0, 0])
    check[0][0][0] = 1

    while (queue.size() > 0) {
        let [cx, cy, wall] = queue.shift()

        if (cx === N - 1 && cy === M - 1) {
            return check[cx][cy][wall]
        }
        for (let i = 0; i < 4; i++) {
            let nx = cx + dx[i]
            let ny = cy + dy[i]
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {

                if (path[nx][ny] === 1 && wall === 0 && check[nx][ny][1] === -1) {
                    check[nx][ny][1] = check[cx][cy][wall] + 1
                    queue.push([nx, ny, 1])
                } else if (path[nx][ny] === 0 && check[nx][ny][wall] === -1) {
                    check[nx][ny][wall] = check[cx][cy][wall] + 1
                    queue.push([nx, ny, wall])
                }
            }
        }
    }
    return -1
}

console.log(bfs())