package copylistwithrandompointer

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

func copyRandomList(head *Node) *Node {
	if head == nil {
		return head
	}

	mapping := make(map[*Node]*Node)

	newHead := &Node{Val: head.Val}
	newTemp := newHead
	temp := head

	mapping[head] = newHead

	for temp.Next != nil {
		temp = temp.Next
		newTemp.Next = &Node{Val: temp.Val}
		newTemp = newTemp.Next
		mapping[temp] = newTemp
	}

	temp, newTemp = head, newHead
	for temp != nil {
		if temp.Random != nil {
			newTemp.Random = mapping[temp.Random]
		}
		temp, newTemp = temp.Next, newTemp.Next
	}

	return newHead

}
