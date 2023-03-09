//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        ArrayList<Node> ans = new ArrayList<>();
        int[]arr1= new int[26];
        int[]arr2 = new int[26];
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<s.length(); i++){
            arr1[s.charAt(i)-'a']++;
            if(arr1[s.charAt(i)-'a'] == 1){
                count1++;
            }
        }
        Node temp = head;
        while(temp!=null){
            arr2[temp.data-'a']++;
            if(arr2[temp.data-'a'] == arr1[temp.data-'a']){
                count2++;
            }
            while(arr2[temp.data-'a'] > arr1[temp.data-'a']){
                if(arr2[head.data-'a'] == arr1[head.data-'a'])
                    count2--;
                arr2[head.data-'a']--;
                head =head.next;
            }
            if(count1 == count2){
                ans.add(head);
                Node t = temp.next;
                temp.next = null;
                temp = t;
                head = t;
                count2 = 0;
                Arrays.fill(arr2,0);
            }
            else
                temp = temp.next;
        }
        return ans;
    }
}