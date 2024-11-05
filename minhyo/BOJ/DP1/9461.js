const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n').map(Number)

input.shift()
let res = new Array(100).fill(0)
res[0] = 1
res[1] = 1
res[2] = 1
res[3] = 2
res[4] = 2
input.forEach((num) => {
    if (num < 5) {
        console.log(res[num - 1])
    }
    else {
        for (let i = 5; i < num; i++) {
            res[i] = res[i - 1] + res[i - 5]
        }
        console.log(res[num - 1])
    }
})