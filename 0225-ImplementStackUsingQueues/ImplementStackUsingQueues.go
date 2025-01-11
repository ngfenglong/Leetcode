package implementstackusingqueues

import "container/list"

type MyStack struct {
	q1, q2 *list.List
}

func Constructor() MyStack {
	return MyStack{
		q1: list.New(),
		q2: list.New(),
	}
}

func (this *MyStack) Push(x int) {
	for this.q1.Len() > 0 {
		this.q2.PushBack(this.q1.Remove(this.q1.Front()))
	}
	this.q1.PushBack(x)
	for this.q2.Len() > 0 {
		this.q1.PushBack(this.q2.Remove(this.q2.Front()))
	}
}

func (this *MyStack) Pop() int {
	val := this.Top()
	this.q1.Remove(this.q1.Front())
	return val
}

func (this *MyStack) Top() int {
	return this.q1.Front().Value.(int)
}

func (this *MyStack) Empty() bool {
	return this.q1.Len() == 0
}
