import java.util.*;

class job_sequential{
    static class data{
        int profit ;
        int deadline;
        String name;
        data(int profit,int deadline,String name){
            this.profit=profit;
            this.deadline=deadline;
            this.name=name;
        } 

    }
    static double arrange(data d[],int capacity){
        Arrays.sort(d,(data a,data b)->Integer.compare(a.profit,b.profit));
        int total_dead=0;
        int total_pro=0;
        for (data de:d){

        
        if(total_dead+de.deadline<=capacity){
            total_dead+=de.deadline;
           total_pro+=de.profit;

        }
        else{
            break;
        }
        
        }
        return total_pro;
    }

    public static void main(String[] args) {
        data d[]=new data[5];
        d[0]=new data(20,10,"ab");
        d[1]=new data(30,5,"abc");
        d[2]=new data(20,15,"abd");
        d[3]=new data(20,50,"abe");
        d[4]=new data(20,20,"abf");
       double pro=arrange(d,50);

        System.out.println("max profit="+pro);
    }
}