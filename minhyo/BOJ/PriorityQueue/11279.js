class MaxHeap {
    #tree;
    #size;

    constructor() {
        this.#tree = []
        this.#tree.push(null)
        this.#size = 0
    }
    push(e) {
        this.#tree.push(e)
        this.#size++
        if (this.#size == 1)
            return
        this.#shift_up(this.#tree.length - 1)
    }
    #shift_up(index) {
        let parent = Math.floor(index / 2)
        if (parent == 0)
            return
        if (this.#tree[index] > this.#tree[parent]) {
            let temp = this.#tree[parent]
            this.#tree[parent] = this.#tree[index]
            this.#tree[index] = temp
            this.#shift_up(parent)
        }
    }
    pop() {
        if (this.#size == 0)
            return 0
        let element = this.#tree[1]
        if (this.#size > 1)
            this.#tree[1] = this.#tree.pop()
        else
            this.#tree.pop()
        this.#size--
        this.#shift_down(1)
        return element
    }
    #shift_down(index) {
        let lchild = this.#tree[index * 2] == undefined ? index : index * 2
        let rchild = this.#tree[index * 2 + 1] == undefined ? index : index * 2 + 1
        let bigger_child = this.#tree[lchild] > this.#tree[rchild] ? lchild : rchild

        if (this.#tree[index] < this.#tree[bigger_child]) {
            let temp = this.#tree[bigger_child]
            this.#tree[bigger_child] = this.#tree[index]
            this.#tree[index] = temp
            this.#shift_down(bigger_child)
        }
    }
}

const fs = require('fs')
const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n').map(Number);

input.shift()
let result = ""
let heap = new MaxHeap()
input.forEach(e => {
    let n = parseInt(e)
    if (n == 0)
        result += heap.pop() + "\n"
    else
        heap.push(n)
})
console.log(result)