function solution(phone_book) {
    let answer = true
    phone_book.sort();
    for (let i = 0; i < phone_book.length - 1; i += 1) {
        if (phone_book[i + 1].startsWith(phone_book[i])) {
            answer = false;
        }
    }
    return answer;
}

console.log(solution(["119", "97674223", "1195524421"]));
console.log(solution(["123", "456", "789"]));
console.log(solution(["12", "123", "1235", "567", "88"]));