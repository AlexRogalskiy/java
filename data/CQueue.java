/**
*
*	Custom Queue implementation
*
*/
public class CQueue<T> {
	private static class CQueueNode<T> {
		private T data;
		private CQueueNode<T> next;

		public CQueueNode(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
	        return "CQueueNode {data: " + this.data + ", next: " + this.next + "}";
	    }

		@Override
	    public boolean equals(Object obj) {
	    	if(obj == this) {
	    		return true;
	    	}
	    	if(null == obj || obj.getClass() != this.getClass()) {
	    		return false;
	    	}
		    CQueueNode<T> another = (CQueueNode<T>) obj;
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

	private CQueueNode<T> first;
	private CQueueNode<T> last;

	public void add(T item) {
		CQueueNode<T> temp = new CQueueNode<T>(item);
		if(null != last) {
			last.next = temp;
		}
		last = t;
		if(this.isEmpty()) {
			first = last;
		}
	}

	public T remove() {
		if(this.isEmpty()) {
			throw new EmptyQueueException();
		}
		T data = first.data;
		first = first.next;
		if(this.isEmpty()) {
			this.last = null;
		}
		return data;
	}

	public T peek() {
		if(this.isEmpty()) {
			throw new EmptyQueueException();
		}
		return first.data;
	}

	public boolean isEmpty() {
		return (null == first);
	}
}