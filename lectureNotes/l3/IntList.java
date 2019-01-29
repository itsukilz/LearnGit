public class IntList {
	public int first;
	public IntList rest;

	public IntList (int f, IntList r) {
		first = f;
		rest = r;
	}

	public int size() {
		if (rest == null) {
			return 1; 
		} else {
			return this.rest.size() + 1;
		}
	}

	/** get the size of this IntList using no recursion*/
	public int iterativeSize() {
		IntList p = this;
		int count = 1;
		while (p.rest != null) {
			p = p.rest;
			count += 1;
		}
		return count;
	}

	/** get the ith item of this IntList by recursion*/
	public int get(int i) {
		if (i == 1) {
			return first;
		} else {
			return rest.get(i - 1);
		}
	}


	/** get the ith item of this IntList by iteration*/
	// public int iterativeGet (int i) {
	// 	IntList p = this;
	// 	int count = 1;
	// 	while (p.rest != null) {
	// 		if (i == count) {
	// 			return p.first;
	// 		} else {
	// 			p =  p.rest;
	// 			count += 1;
	// 		}
	// 	}
	// 	return p.first;
	// }


	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);

		System.out.println(L.iterativeSize());
	}
}