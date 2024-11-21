const fs = require('fs')

const [A, B, C] = fs.readFileSync("/dev/stdin").toString().trim().split(' ').map(BigInt)

function divide(a, b) { //모듈러 연산의 분배 법칙, (A x B) % C = ((A % C) x (B % C)) % C
    if (b == 0) {
        return BigInt(1)
    }
    else {
        const temp = divide(a, BigInt(parseInt(b / BigInt(2))))
        if (b % BigInt(2) == 0) {
            return (temp * temp) % C
        }
        else {
            return (temp * temp * a) % C
        }
    }
}


console.log(parseInt(divide(A, B)))