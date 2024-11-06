const fs = require('fs')

const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const n = Number(input[0])
let tri = []
for (let i = 1; i < input.length; i++) {
    let tmp = input[i].split(' ').map(Number)
    tri.push(tmp)
}

for (let i = 1; i < tri.length; i++) {
    for (let j = 0; j < tri[i].length; j++) {
        if (j === 0) {
            tri[i][j] = tri[i][j] + tri[i - 1][j]
        }
        else if (j === tri[i].length - 1) {
            tri[i][j] = tri[i][j] + tri[i - 1][j - 1]
        }
        else {
            tri[i][j] = tri[i][j] + Math.max(tri[i - 1][j - 1], tri[i - 1][j])
        }
    }
}

console.log(Math.max(...tri[tri.length - 1]))