/**
*
*	Custom Stack implementation
*
*/
public class CStack<T> {
	private static class CStackNode<T> {
		private T data;
		private CStackNode<T> next;

		public CStackNode(T node) {
			this.data = data;
		}

		@Override
		public String toString() {
	        return "CStackNode {data: " + this.data + ", next: " + this.next + "}";
	    }

		@Override
	    public boolean equals(Object obj) {
	    	if(obj == this) {
	    		return true;
	    	}
	    	if(null == obj || obj.getClass() != this.getClass()) {
	    		return false;
	    	}
		    CStackNode<T> another = (CStackNode<T>) obj;
		    if ((null != this.data && this.data.equals(another.data)) &&
		       	(null != this.next && this.next.equals(another.next))) {
		    		return true;
		    }
		    return false;
		}

		@Override 
        public int hashCode() {
			final int prime = 31;
			int result = 1;
	        result = prime * result + (null == this.data) ? 0 : this.data.hashCode();
	        result = prime * result + (null == this.next) ? 0 : this.next.hashCode();
	        return result;
	    }
	}

	private CStackNode<T> top;

	public T pop() {
		if(this.isEmpty()) {
			throw new EmptyStackException();
		}
		T item = top.data;
		top = top.next;
		return item;
	}

	public void push(T itme) {
		CStackNode<T> temp = new CStackNode<T>(item);
		temp.next = top;
		top = temp;
	}

	public T peek() {
		if(this.isEmpty()) {
			throw new EmptyStackException();
		}
		return top.data;
	}

	public boolean isEmpty() {
		return (null == top);
	}
}