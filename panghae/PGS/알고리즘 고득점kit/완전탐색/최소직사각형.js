function solution(sizes) {
    let minWidth = 0;
    let minHeight = 0;

    sizes.forEach((value) => {
        value.sort((a, b) => b - a);
        const [w, h] = value;
        minWidth = Math.max(minWidth, w);
        minHeight = Math.max(minHeight, h);
    });

    return minWidth * minHeight;
}

console.log(solution([[60, 50], [30, 70], [60, 30], [80, 40]]));
console.log(solution([[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]));
console.log(solution([[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]));