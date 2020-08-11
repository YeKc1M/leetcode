public class GasStation {
    public static void main(String[] args){
        System.out.println("hello world!");
        int[] gas={1,2,3,4,5};
        int[] cost={3,4,5,1,2};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res=-1;
        int n=gas.length;
        for(int i=0;i<n;i++){
            int l=0;
            boolean canCompelete=true;
            for(int j=0;j<n;j++){
                if(gas[(i+j)%n]+l>=cost[(i+j)%n]){
                    l+=(gas[(i+j)%n]-cost[(i+j)%n]);
                }else{
                    canCompelete=false;
                    break;
                }
            }
            if(canCompelete) return i;
        }
        return res;
    }
}