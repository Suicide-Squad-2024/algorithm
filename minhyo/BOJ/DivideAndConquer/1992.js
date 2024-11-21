const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const N = Number(input[0])
const tree = []
for (let i = 1; i < input.length; i++) {
    let tmp = input[i].split('').map(Number)
    tree.push(tmp)
}
function isSame(x, y, size) {
    const a = tree[x][y]
    for (let i = x; i < x + size; i++) {
        for (let j = y; j < y + size; j++) {
            if (a !== tree[i][j]) return false
        }
    }
    return true
}
let res = ''
function divide(x, y, size) {
    if (isSame(x, y, size)) {
        res += tree[x][y]
        return
    }
    res += '('
    let newSize = size / 2

    divide(x, y, newSize)
    divide(x, y + newSize, newSize)
    divide(x + newSize, y, newSize)
    divide(x + newSize, y + newSize, newSize)
    res += ')'
}

divide(0, 0, N)

console.log(res)