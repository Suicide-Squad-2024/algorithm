const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim()

let parts = input.split('-')

let result = parts[0].split('+').map(Number).reduce((acc, curr) => acc + curr, 0)


for (let i = 1; i < parts.length; i++) {
    let sum = parts[i].split('+').map(Number).reduce((acc, curr) => acc + curr, 0)
    result -= sum
}

console.log(result)