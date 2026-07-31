import java.util.*;
public class Trapping_Rainwater {
    public static int trap(int height[]){
        Stack<Integer> s=new Stack<>();
        int trappedWater=0;
        for(int i=0;i<height.length;i++){
            while(!s.isEmpty() && height[i]>height[s.peek()]){
                int top=s.pop();
                if(s.isEmpty()) break;
                int distance=i-s.peek()-1;
                int boundedHeight=Math.min(height[i],height[s.peek()])-height[top];
                trappedWater+=distance*boundedHeight;
            }
            s.push(i);
        }return trappedWater;
    }
    public static void main(String args[]){
        int height[]={7,0,4,2,5,0,6,4,0,3};
        System.out.println(trap(height));
    }
}
