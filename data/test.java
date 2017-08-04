
boolean getBit(int num, int i) {
	return ((num & (1 << i)) != 0);
}

int setBit(int num, int i) {
	return num | (1 << i);
}

int clearBit(int num, int i) {
	int mask = ~(1 << i);
	return num & mask;
}

int clearBitsMSBthroughI(int num, int i) {
	int mask = (1 << i) - 1;
	return num & mask;
}

int clearBithsIthrough0(int num, int i) {
	int mask = ~(-1 >>> (31 - i));
	return num & mask;
}

int updateBit(int num, int i, boolean bitIs1) {
	int value = flag ? 1 : 0;
	int mask = ~(1 << i);
	return (num & mask) | (value << i);
}

//-----------------------------------------------------

x ^ 0s = x
x & 0s = 0
x | 0s = x

x ^ 1s = ~x
x & 1s = x
x | 1s = 1s

x ^ x = 0
x & x = x
x | x = x

concat(1, 2^(N-1)-K)

//-----------------------------------------------------

void searchDFS(Node root) {
	if(null == root) return;
	visit(root);
	root.visited = true;
	for (Node n : root.adjacent) {
		if(!n.visited) {
			searchDFS(n);
		}
	}
}

void searchBFS(Node root) {
	Queue queue = new Queue();
	root.marked = true;
	queue.enqueue(root);

	while(!queue.isEmpty()) {
		Node r = queue.dequeue();
		visit(r);
		for (Node n : r.adjacent) {
			if(!n.marked) {
				n.marked = true;
				queue.enqueue(n);
			}
		}
	}
}

//-----------------------------------------------------

void inOrderTraversal(TreeNode node) {
	if(null != node) {
		inOrderTraversal(node.left);
		visit(node);
		inOrderTraversal(node.right);
	}
}

void preOrderTraversal(TreeNode node) {
	if(null != node) {
		visit(node);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
}

void postOrderTraversal(TreeNode node) {
	if(null != node) {
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		visit(node);
	}
}

//-----------------------------------------------------

// downward dynamic
int fibonacci(int n) {
	return fibonacci(n, new int[n+1]);
}

int fibonacci(int i, int[] memo) {
	if(0 == i || 1 == i) return i;
	if(0 == memo[i]) {
		memo[i] = fibonacci(i-1, memo) + fibonacci(i-2, memo);
	}
	return memo[i];
}
//upward dynamic
int fibonacci(int n) {
	if(0 == n) return 0;
	else if(1 == n) return 1;

	int[] memo = new int[n];
	memo[0] = 0; memo[1] = 1;
	for (int i=2; i<n; i++) {
		memo[i] = memo[i-1] + memo[i-2];
	}
	return memo[n-1] + memo[n-2];
}

int fibonacci(int n) {
	if(0 == n) return 0;
	int a = 0, b = 1;
	for (int i=2; i<n; i++) {
		int c = a + b;
		a = b;
		b = c;
	}
	return (a + b);
}

//-----------------------------------------------------
// merge sort
worst - O(n*log(n))
average - O(n*log(n))
memory - O(n)

void mergeSort(int[] array) {
	int[] temp = new int[array.length];
	mergesort(array, temp, 0, array.length-1);
}

void mergeSort(int[] array, int[] temp, int low, int high) {
	if(low < high) {
		int middle = Math.floor((low + high) / 2);
		mergeSort(array, temp, low, middle);
		mergeSort(array, temp, middle+1, high);
		merge(array, temp, low, middle, high);
	}
}

void merge(int[] array, int[] temp, int low, int middle, int high) {
	for (int i=low; i<=high; i++) {
		temp[i] = array[i];
	}

	int tempLeft = low;
	int tempRight = middle + 1;
	int current = low;

	while(tempLeft <= middle && tempRight <= high) {
		if(temp[tempLeft] <= temp[tempRight]) {
			array[current] = temp[tempLeft];
			tempLeft++;
		} else {
			array[current] = temp[tempRight];
			tempRight++;
		}
		current++;
	}

	int residue = middle - tempLeft;
	for (int i=0; i<=residue; i++) {
		array[current+i] = temp[tempLeft+i];
	}
}

// quick sort
average - O(n*log(n))
worst - O(n*n)
memory - O(log(n))

void quickSort(int[] array, int left, int right) {
	int index = partition(array, left, right);
	if(left < index-1) {
		quickSort(array, left, index-1);
	}
	if(index < right) {
		quickSort(array, index, right);
	}
}

int partition(int[] array, int left, int right) {
	int pivot = array[Math.floor((left + right) / 2)];
	while(left <= right) {
		while(array[left] < pivot) left++;
		while(array[right] > pivot) right--;

		if(left <= right) {
			swap(array, left, right);
			left++;
			right--;
		}
	}
	return left;
}

void swap(int[] array, int left, int right) {
	int temp = array[left];
	array[left] = array[right];
	array[right] = temp;
}

// bitwise sort
average - O(k*n)

//-----------------------------------------------------

int binarySearch(int[] array, int value) {
	int low = 0;
	int high = array.length - 1;
	int middle;

	while(low <= high) {
		middle = Math.floor((low + high) / 2);
		if(array[middle] < value) {
			low = middle + 1;
		} else  if(array[middle] > value) {
			high = middle - 1;
		} else {
			return mid;
		}
	}
	return -1;
}

int binarySearchRecursive(int[] array, int value, int low, int high) {
	if(low > high) return -1;
	int middle = Math.floor((low + high) / 2);
	if(array[middle] < value) {
		return binarySearchRecursive(array, value, middle+1, hig);
	} else if(array[middle] > value) {
		return binarySearchRecursive(array, value, low, middle-1);
	} else {
		return middle;
	}
}

//-----------------------------------------------------