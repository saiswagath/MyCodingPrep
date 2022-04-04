

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void topView(Node root) {
      if (root == null)
        return;   // There is no top view of of a tree having  root null
        
        Queue<Node> qt = new LinkedList<Node>();
        Queue<Integer> qi = new LinkedList();
        // Declare Map to maintain hd and node data.
        Map<Integer,Integer> topView = new TreeMap<>();
        // We first add the root into the queue along with it's hd 0.
        qt.add(root);
        qi.add(0);
        
        // Standard level order traversal using Queue
        while (!qt.isEmpty())
        {
            Node curr = qt.poll(); 
            int hd = qi.poll();    
            if (!topView.containsKey(hd))
            {
                topView.put(hd,curr.data);
            }
            
            // Now add the left and right child of each node
            // to continue level order traversal
            
            if (curr.left != null)
            {
                qt.add(curr.left);
                qi.add(hd-1);
            }
            
            if (curr.right != null)
            {
                qt.add(curr.right);
                qi.add(hd + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : topView.entrySet()) {
            System.out.print(entry.getValue()+" ");
        }
      
    }

