public class Solution{
    public int romanToInt(String s){//normal solution
        if(s.length()==0){
            return 0;
        }
        int res=0;
        int i=0;
        for(i=0;i<s.length()-1;i++){
            switch(s.charAt(i)){
                case 'I'://1
                    char nextI=s.charAt(i+1);
                    if(nextI=='V'){
                        res+=4;
                        i++;
                    }else if(nextI=='X'){
                        res+=9;
                        i++;
                    }else{
                        res+=1;
                    }
                    break;
                case 'V'://5
                    res+=5;
                    break;
                case 'X'://10
                    char nextX=s.charAt(i+1);
                    if(nextX=='L'){
                        res+=40;
                        i++;
                    }else if(nextX=='C'){
                        res+=90;
                        i++;
                    }else{
                        res+=10;
                    }
                    break;
                case 'L'://50
                    res+=50;
                    break;
                case 'C'://100
                    char nextC=s.charAt(i+1);
                    if(nextC=='D'){
                        res+=400;
                        i++;
                    }else if(nextC=='M'){
                        res+=900;
                        i++;
                    }else{
                        res+=100;
                    }
                    break;
                case 'D'://500
                    res+=500;
                    break;
                case 'M'://1000
                    res+=1000;
                    break;
                default:
                    break;
            }
        }
        if(i!=s.length()){
            char last=s.charAt(s.length()-1);
            if(last=='I') res+=1;
            else if(last=='V') res+=5;
            else if(last=='X') res+=10;
            else if(last=='L') res+=50;
            else if(last=='C') res+=100;
            else if(last=='D') res+=500;
            else if(last=='M') res+=1000;
        }
        return res;
    }
    public int romanToInt1(String s){//reverse traversing s
        if(s.length()==0) return 0;
        int i=s.length()-1;
        int res=0;
        for(i=s.length()-1;i>0;i--){
            int current=singleRomanToInt(s.charAt(i));
            int before=singleRomanToInt(s.charAt(i-1));
            if(current>before){
                res+=current-before;
                i--;
            }else{
                res+=current;
            }
        }
        if(i==0){
            res+=singleRomanToInt(s.charAt(0));
        }
        return res;
    }
    public static int singleRomanToInt(char romanChar){
        int res=0;
        if(romanChar=='I') res=1;
        else if(romanChar=='V') res=5;
        else if(romanChar=='X') res=10;
        else if(romanChar=='L') res=50;
        else if(romanChar=='C') res=100;
        else if(romanChar=='D') res=500;
        else if(romanChar=='M') res=1000;
        return res;
    }
    public static void main(String[] args){
        //System.out.println("hello world!");
    }
}