function solution(bridge_length, weight, truck_weights) {
    const bridgeQ = [];

    const reducer = (arr) => arr.reduce((acc, cur) => acc + cur, 0);
    let time = 0;

    while (truck_weights.length || bridgeQ.length) {
        if (bridgeQ.length) {
            const [, inputTime] = bridgeQ[0];
            if (time - inputTime === bridge_length) {
                bridgeQ.shift();
            }
        }
        const nextTruckWeight = truck_weights[0]
        if (reducer([...bridgeQ.map(value => value[0]), nextTruckWeight]) <= weight && bridgeQ.length <= bridge_length) {
            const truckWeight = truck_weights.shift();
            bridgeQ.push([truckWeight, time]);
        }
        time += 1;
    }
    return time;
}


console.log(solution(2, 10, [7, 4, 5, 6]));
console.log(solution(100, 100, [10]));
console.log(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]));