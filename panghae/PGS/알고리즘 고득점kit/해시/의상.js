function solution(clothes) {
    let answer = 1

    const clothObj = {};

    for (const [detail, type] of clothes) {
        if (clothObj?.[type]) {
            clothObj[type].push(detail);
        } else {
            clothObj[type] = [detail];
        }
    }

    const countList = []
    Object.values(clothObj).forEach((value) => {
        countList.push(value.length + 1);
    });

    for (const c of countList) {
        answer *= c;
    }

    return answer - 1;
}

console.log(solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]))
console.log(solution([["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]))