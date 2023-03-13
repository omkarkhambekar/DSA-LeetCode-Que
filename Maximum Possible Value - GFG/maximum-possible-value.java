//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine().trim());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            input_line = read.readLine().trim().split("\\s+");
            int B[]= new int[N];
            for(int i = 0; i < N; i++)
                B[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.maxPossibleValue(N, A, B); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long maxPossibleValue(int N, int A[] ,int B[]) { 
        // code here
       long totalPeri = 0;
       long totalStick = 0;
       long minLen = Integer.MAX_VALUE;
       
       for(int i=0; i<N; i++){
           if(B[i]%2!=0){
               B[i] = B[i]-1;
           }
           if(B[i] >=2){
               minLen =Math.min(minLen,A[i]);
           }
           totalStick += B[i];
           totalPeri += A[i] * B[i];
       }
       if(totalStick%4!=0){
           totalPeri-=2*minLen;
       }
       return totalPeri;
       
       
    }
} 