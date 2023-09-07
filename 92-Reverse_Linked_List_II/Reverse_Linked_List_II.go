package reverselinkedlistii

type ListNode struct {
	Val  int
	Next *ListNode
}

var nodeAfterReversedEnd *ListNode
var reversedStart *ListNode

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	if left == right {
		return head
	}

	temp := head
	if left == 1 {
		temp = &ListNode{Next: head}
	}

	newHead := temp
	for i := 1; i < left-1; i++ {
		temp = temp.Next
	}

	reverseEnd := reverseNodes(temp.Next, right-left)
	reverseEnd.Next = nodeAfterReversedEnd
	temp.Next = reversedStart

	if left == 1 {
		return newHead.Next
	}

	return newHead
}

func reverseNodes(node *ListNode, count int) *ListNode {
	if count == 0 {
		nodeAfterReversedEnd = node.Next
		reversedStart = node
		return node
	}

	count--
	reverseNodes(node.Next, count).Next = node
	return node
}
