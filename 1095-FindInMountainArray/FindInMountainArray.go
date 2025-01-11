package findinmountainarray

// Dummy MountainArray implementation for compilation
// Actual implementation of Mountain Array shoudl be done on LC website
type MountainArray struct {
	arr []int
}

func (this *MountainArray) get(index int) int {
	return this.arr[index]
}

func (this *MountainArray) length() int {
	return len(this.arr)
}

var cache map[int]int

func findInMountainArray(target int, mountainArr *MountainArray) int {
	cache = make(map[int]int)
	n := mountainArr.length()

	left := 1
	right := n - 2

	// Finding the peak idx
	for left != right {
		mid := (left + right) >> 1

		if getValue(mid, mountainArr) < getValue(mid+1, mountainArr) {
			left = mid + 1
		} else {
			right = mid
		}
	}

	peak := right

	// Searching the left side of the mountain array
	left = 0
	right = peak

	for left <= right {
		mid := (left + right) >> 1
		midValue := getValue(mid, mountainArr)

		if midValue == target {
			return mid
		} else if midValue < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	// Searching the right side of the mountain array
	left = peak
	right = n - 1

	for left <= right {
		mid := (left + right) >> 1
		midValue := getValue(mid, mountainArr)

		if midValue == target {
			return mid
		} else if midValue > target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	// Target not found
	return -1
}

func getValue(idx int, mountainArr *MountainArray) int {
	val, exists := cache[idx]
	if exists {
		return val
	}

	// Retrieve and insert into the cache
	val = mountainArr.get(idx)
	cache[idx] = val
	return val
}
