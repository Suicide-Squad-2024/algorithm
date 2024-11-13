const fs = require('fs')

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const N = Number(input[0])

const km = input[1].split(' ').map(el => BigInt(el))

const price = input[2].split(' ').map(el => BigInt(el))


let res = 0n //BigInt타입으로 안하면 부분점수
let tmp = price[0]
for (let i = 0; i < N - 1; i++) {

    if (price[i] < tmp) {
        tmp = price[i]
    }
    res += tmp * km[i]
}

console.log(String(res))