
/*boolean getBit(int num, int i) {
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
}*/