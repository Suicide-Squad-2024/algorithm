function solution(nums) {
    const getAmount = Math.floor(nums.length / 2);
    const phoneketmon = new Set(nums);

    if (getAmount > phoneketmon.size) {
        return phoneketmon.size;
    } else {
        return getAmount;
    }
}

console.log(solution([3, 1, 2, 3]))
console.log(solution([3, 3, 3, 2, 2, 4]))
console.log(solution([3, 3, 3, 2, 2, 2]))