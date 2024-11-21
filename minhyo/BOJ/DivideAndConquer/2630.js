const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

let N = Number(input[0])

const paper = []

for (let i = 1; i < input.length; i++) {
    let tmp = input[i].split(' ').map(Number)
    paper.push(tmp)
}

let wh = 0
let bl = 0

function isSame(x, y, size) {
    const color = paper[x][y]
    for (let i = x; i < x + size; i++) {
        for (let j = y; j < y + size; j++) {
            if (paper[i][j] != color) {
                return false
            }
        }
    }
    return true
}

function divide(x, y, size) {
    if (isSame(x, y, size)) {
        if (paper[x][y] == 0) {
            wh++
        }
        else bl++
        return

    }
    const newSize = size / 2
    divide(x, y, newSize)
    divide(x, y + newSize, newSize)
    divide(x + newSize, y, newSize)
    divide(x + newSize, y + newSize, newSize)
}

divide(0, 0, N)

console.log(wh)
console.log(bl)