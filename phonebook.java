import java.util.*;

class phonebook{
 static int bin(int si,int ei,Long key,Long[] arr){
    int mid=si+(ei-si)/2;
    if(si>ei)return -1;
    else{
    if(arr[mid]==key){
        return mid;

    }
    else if(arr[mid]>key)
    bin(si,mid-1,key,arr);
    else
    bin(mid+1,ei,key,arr);
    }
    return 1;

}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<Long,String> s=new HashMap<>(); 
        s.put(9370156300L,"sourabh");
        s.put(987654321L,"sujit");
        s.put(8421921166L,"piyush");
        s.put(9359404704L,"samarth");
        s.put(9860099236L,"gourav sankpal");


int i=0;
        Long arr[]=new Long[s.size()];
        for(Long k : s.keySet()){
         arr[i++]=k;
        }
        Arrays.sort(arr);
        int si=0;
        int ei=s.size()-1;
        System.out.println("enter contact no to search");
        Long key=sc.nextLong();
        bin(si,ei,key,arr);
    int result=bin(si,ei,key,arr);

    if(result==-1){
        System.out.println("wrong no");
    }
    else{
        System.out.println(key+" - "+s.get(key));
    }
    }
}