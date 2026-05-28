/* class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int bestLen = Integer.MAX_VALUE;
        int bestIdx = Integer.MAX_VALUE;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();
        
        for (int i = 0; i < wordsContainer.length; i++) {
            String word = wordsContainer[i];
            int len = word.length();
            TrieNode curr = root;
            
            if (len < curr.bestLen || (len == curr.bestLen && i < curr.bestIdx)) {
                curr.bestLen = len;
                curr.bestIdx = i;
            }
            
            for (int j = len - 1; j >= 0; j--) {
                int charIdx = word.charAt(j) - 'a';
                
                if (curr.children[charIdx] == null) {
                    curr.children[charIdx] = new TrieNode();
                }
                
                curr = curr.children[charIdx];
                
                if (len < curr.bestLen || (len == curr.bestLen && i < curr.bestIdx)) {
                    curr.bestLen = len;
                    curr.bestIdx = i;
                }
            }
        }
        
        int[] ans = new int[wordsQuery.length];
        
        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];
            int len = query.length();
            TrieNode curr = root;
            
            for (int j = len - 1; j >= 0; j--) {
                int charIdx = query.charAt(j) - 'a';
                if (curr.children[charIdx] == null) {
                    break;
                }
                curr = curr.children[charIdx];
            }
            ans[i] = curr.bestIdx;
        }
        
        return ans;
    }
}  */


class Solution {
    public static class Trie{

	private class Node{
		char data;
		HashMap<Character,Node>child=new HashMap<>();
		boolean isTerminal;
	    int idx = -1;

        int minLen = Integer.MAX_VALUE;
	}
	private Node root;
	public Trie() {
		Node nn=new Node();
		nn.data='*';
		root=nn;
	}
	public void Insert(String word,int ind) {
		  if(word.length() < root.minLen) {

		        root.minLen = word.length();

		        root.idx = ind;
		    }
		Node temp=root;
		for(int i=0;i<word.length();i++) {
			char ch=word.charAt(i);
			if(!temp.child.containsKey(ch)) {
			
				Node nn=new Node();
				nn.data=ch;
				temp.child.put(ch, nn);
			
			}
			temp=temp.child.get(ch);
			if(word.length()<temp.minLen) {
				temp.minLen=word.length();
				temp.idx=ind;
			}
		}
		temp.isTerminal=true;
		
	}
	public int getIndex(String prefix) {
		Node temp=root;
		int ans =root.idx;
		for(int i=0;i<prefix.length();i++) {
			char ch=prefix.charAt(i);
			if(!temp.child.containsKey(ch)) {
				break;
			}
			temp=temp.child.get(ch);
			ans = temp.idx;
		}
		return ans;
	}
}
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        	Trie t=new Trie();
         for(int i = 0; i < wordsContainer.length; i++) {

		    t.Insert(rev(wordsContainer[i]), i);
		}
         int[]arr=new int[wordsQuery.length];
	 int i=0;
	 for(String a : wordsQuery) {

		    int b = t.getIndex(rev(a));

		    arr[i++] = b;
		}
        return arr;
    }
    public static String rev(String s) {

    return new StringBuilder(s).reverse().toString();
}
}