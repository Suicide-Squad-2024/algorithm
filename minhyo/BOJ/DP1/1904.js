const fs = require('fs')

const input = Number(fs.readFileSync("/dev/stdin").toString().trim())

let res = new Array(input).fill(0)
res[0] = 1
res[1] = 2
for (let i = 2; i < input; i++) {
    res[i] = (res[i - 1] + res[i - 2]) % 15746
}
console.log(res[input - 1])