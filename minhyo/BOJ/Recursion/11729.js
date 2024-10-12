

const fs = require('fs');


const N = Number(fs.readFileSync("/dev/stdin").toString().trim())

let res = []
function hanoi(n, from, aux, to) {
    if (n == 1) {
        res.push(`${from} ${to}`)
        return
    }
    hanoi(n - 1, from, to, aux)
    res.push(`${from} ${to}`)
    hanoi(n - 1, aux, from, to)
}

hanoi(N, 1, 2, 3)
console.log(res.length)
console.log(res.join("\n"))
