const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')


let [N, K] = input[0].split(' ').map(Number)

let coin = []

for (let i = 1; i < input.length; i++) {
    coin.push(Number(input[i]))
}

let res = 0
for (let i = coin.length - 1; i >= 0; i--) {
    if (K >= coin[i]) {
        let tmp = Math.floor(K / coin[i])
        res = tmp + res
        K = K - tmp * coin[i]
        if (K === 0) {
            console.log(res)
            break
        }
    }
}
