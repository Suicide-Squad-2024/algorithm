const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')


let board = []

for (let i = 0; i < input.length; i++) {
    let tmp = input[i].split(' ').map(Number)

    board.push(tmp)
}

let check = []


for (let i = 0; i < input.length; i++) {
    for (let j = 0; j < input.length; j++) {
        if (board[i][j] == 0) {
            check.push([i, j])
        }
    }
}

function checkRow(n, x) {
    for (let i = 0; i < 9; i++) {
        if (board[x][i] == n) {
            return false
        }
    }
    return true;
}

function checkCol(n, y) {
    for (let i = 0; i < 9; i++) {
        if (board[i][y] == n) {
            return false
        }
    }
    return true;
}

function checkS(x, y, n) {
    tx = Math.floor(x / 3) * 3
    ty = Math.floor(y / 3) * 3
    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 3; j++) {
            if (n == board[tx + i][ty + j]) {
                return false
            }
        }
    }
    return true
}

function dfs(depth) {
    if (depth == check.length) {
        for (let i = 0; i < 9; i++) {
            console.log(board[i].join(' '))
        }
        process.exit(0) // 맞는 정답을 하나라고 찾으면 바로 종료시켜하기 때문에 return X
    }
    let x = check[depth][0]
    let y = check[depth][1]

    for (let i = 1; i < 10; i++) {
        if (checkRow(i, x) && checkCol(i, y) && checkS(x, y, i)) {
            board[x][y] = i
            dfs(depth + 1)
            board[x][y] = 0
        }
    }
}

dfs(0)