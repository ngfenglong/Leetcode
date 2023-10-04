package designhashmap

const size = 10001

type MyHashMap struct {
	list [size]*Node
}

type Node struct {
	key, val int
	next     *Node
}

func Constructor() MyHashMap {
	return MyHashMap{}
}

func (this *MyHashMap) Put(key int, value int) {
	hashed := key % size
	if this.list[hashed] == nil {
		this.list[hashed] = &Node{key, value, nil}
		return
	}

	node := this.list[hashed]
	if node.key == key {
		node.val = value
		return
	}

	for node.next != nil {
		if node.next.key == key {
			node.next.val = value
			return
		}
		node = node.next
	}

	node.next = &Node{key, value, nil}
}

func (this *MyHashMap) Get(key int) int {
	hashed := key % size
	for node := this.list[hashed]; node != nil; node = node.next {
		if node.key == key {
			return node.val
		}
	}

	return -1
}

func (this *MyHashMap) Remove(key int) {
	hashed := key % size
	node := this.list[hashed]
	if node == nil {
		return
	}

	if node.key == key {
		this.list[hashed] = node.next
		return
	}

	for node.next != nil {
		if node.next.key == key {
			node.next = node.next.next
			return
		}
		node = node.next
	}
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Put(key,value);
 * param_2 := obj.Get(key);
 * obj.Remove(key);
 */
