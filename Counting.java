package gcphillips.hw4;

import edu.princeton.cs.algs4.StdRandom;

/** Copy to your USERID.hw4 package and make changes. */
public class Counting {
	
	/**
	 * This skeletal structure needs to be modified to solve this problem. Feel free to add code anywhere...
	 */
	public static void main(String[] args) {
		System.out.println("N\tMaxAVHt\tMaxAVDp\tMaxAVZr\tAVZero%\tMaxRBHt\tMaxRBDp\tMaxRBZr\tRBZero%");
		int MaxAVHt = -1;
		int MaxAVDp = -1;
		int MaxAVZr = -1;
		int AVZeroP = -1;
		int MaxRBHt = -1;
		int MaxRBDp = -1;
		int MaxRBZr = -1;
		int RBZeroP = -1;
		
		
		for (int N = 32; N <= 262144; N*= 2) {
			
			
			AVL<Integer> AVTree = new AVL<Integer>();
			RedBlackBST<Integer, Integer> RBTree = new RedBlackBST<Integer, Integer>();
			
			
			int NUMTRIAL= 100;
			for (int T = 0; T < NUMTRIAL; T++) {
				
				// This constructs the array of N-1 values (where N is a power of 2) and 
				// it uses StdRandom.setSeed() to ensure all students will get the same result
				int[] vals = new int[N-1];
				for (int i = 0; i < N-1; i++) {
					vals[i] = i+1;
				}
				StdRandom.setSeed(T);
				StdRandom.shuffle(vals);
				
				// note: Insert the integers in vals into a new AVL or RedBlack Tree in order from left to right
				
				
				
				// Make the AVL Tree
				for (int v : vals) {
					AVTree.insert(v);
				}
				
				// Makes the RB Tree
				for (int v : vals) {
					RBTree.put(v,v);
				}
				
				
				// determines the max height of AVL
				int AVLheight = AVTree.root.height;
				if (AVLheight > MaxAVHt) { MaxAVHt = AVLheight; }
				
				
				// determines the max depth difference
				int AVLdepth_difference = AVTree.root.height - AVTree.minDepth();
				if (AVLdepth_difference > MaxAVDp) { MaxAVDp = AVLdepth_difference; }
				
				
				// determines the maximal count of nodes in a single AVL tree whose height difference is 0
				//int AVLMode0 = AVTree.counts();
				//if (AVLMode0 > MaxAVZr) { MaxAVZr = AVLMode0; }
				
				
				// The next one
				AVZeroP = MaxAVZr / N;
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			// Data Line out
			System.out.println(N + "\t" + 
								MaxAVHt + "\t" + 
								MaxAVDp + "\t" + 
								MaxAVZr + "\t" + 
								AVZeroP + "\t" + 
								MaxRBHt + "\t" + 
								MaxRBDp + "\t" + 
								MaxRBZr + "\t" + 
								RBZeroP);
		}
	}
}


