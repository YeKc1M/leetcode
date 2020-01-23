import java.util.Stack;

public class Solution {
    public boolean isValid(String s){
        int left=0;
        if(s.length()==0) return true;
        if(s.length()==1) return false;
        Stack stack=new Stack<>();
        stack.push(s.charAt(0));
        left++;
        for(int i=1;i<s.length();i++){
            char current=s.charAt(i);
            if(current=='('){
                left++;
                stack.push(current);
            }else if(current=='['){
                left++;
                stack.push(current);
            }else if(current=='{'){
                left++;
                stack.push(current);
            }else if(current==')'){
                if(stack.isEmpty()) return false;
                left--;
                char before=(char)stack.pop();
                if(before!='('){
                    return false;
                }
            }else if(current==']'){
                if(stack.isEmpty()) return false;
                left--;
                char before=(char)stack.pop();
                if(before!='['){
                    return false;
                }
            }else if(current=='}'){
                if(stack.isEmpty()) return false;
                left--;
                char before=(char)stack.pop();
                if(before!='{'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return left==0?true:false;
    }
    public static void main(String[] args){
        System.out.println("valid parentheses");
        //testStack();
        test("()");
    }
    private static void testStack(){
        Stack s=new Stack<>();
        s.add(1);
        s.add(2);
        System.out.println(s.peek());
    }
    public static void test(String s){
        System.out.println(new Solution().isValid(s));
    }
}