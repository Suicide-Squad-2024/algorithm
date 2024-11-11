const fs = require('fs');


const N = Number(fs.readFileSync("/dev/stdin").toString().trim())

let res = []
let tmp = Math.floor(N / 5) + 1
for (let i = 0; i < tmp; i++) {
    if ((N - 5 * i) % 3 === 0) {
        let a = (N - 5 * i) / 3
        res.push(a + i)
    }
}
if (res.length === 0) {
    console.log(-1)
}
else {
    console.log(Math.min(...res))
}