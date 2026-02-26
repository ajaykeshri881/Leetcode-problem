// class Solution {
//     public int numSteps(String s) {
//         int l = s.length() - 1;
//         int carry = 0;
//         int count = 0;
        
//         while (l > 0) {
//             if (Character.getNumericValue(s.charAt(l)) + carry == 0) {
//                 carry = 0;
//                 count++;
//             } else if (Character.getNumericValue(s.charAt(l)) + carry == 2) {
//                 carry = 1;
//                 count++;
            
//             } else {
//                 carry = 1;
//                 count += 2;
//             }
//             l--;
//         }
      
//         if (carry == 1) {
//             count++;
//         }
        
//         return count;
//     }
// }

class Solution {
    public int numSteps(String s) {
        Stack<Integer> st=new Stack<>();
        for(char c:s.toCharArray()) st.push(c-'0');
        int carry=0;
        int steps=0;
        while(st.size()>1){
            if(st.peek()==1&&carry==1){ 
                st.pop();
                steps++;
            }else if(st.peek()==1){ 
                st.pop();
                steps+=2;
                carry=1;
            }else if(st.peek()==0&&carry==1){
                st.pop();
                st.push(1);
                carry=0;
            }else{
                st.pop();
                steps++;
            }
        }
        if(carry==1) steps++;
        return steps;
    }
}