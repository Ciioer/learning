package Offer;

public class num09Fibonacci {
    public int Fibonacci(int n) {
        int resOne = 0;
        int resTwo =1 ;
        int res =0;
        if(n==0){
            return resOne;
        } else if (n==1){
            return resTwo;
        }
        for(int i =2;i<=n;i++){
            res =resOne+resTwo;
            resOne=resTwo;
            resTwo= res;
        }
        return res;

    }
}
