//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.secondSmallest(S,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String secondSmallest(int S, int D){
        // code here
        if(S>=D*9) return "-1";
        
        char[] ch = new char[D];
        S = S-1;
        for(int i=D-1; i>0; i--){
            if(S>9){
                ch[i] = (char)(9+'0');
                S -= 9;
            }
            else{
                ch[i] = (char)(S+'0');
                S = 0;
            }
        }
        ch[0] = (char)(S+1+'0');
        
        int idx = D-1;
        for(int i=D-1; i>=0; i--){
            if(ch[i] == '9'){
                idx = i;
            }
            else{
                break;
            }
        }
        ch[idx]-=1;
        ch[idx-1]+=1;
        
        return String.valueOf(ch);
    }
}