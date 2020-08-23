public class Recursion2{
    public boolean splitOdd10(int[] nums) {
        return splitOdd10aux(nums, 0,0,0);
    }   
   public boolean splitOdd10aux(int [] nums, int indice,int suma1, int suma2){     
        if(indice >= nums.length)
            return (suma1%2 !=0 && suma2%10 == 0) || (suma2%10 ==0 && suma2 %2 != 0);
        return splitOdd10aux(nums,indice+1,suma1+nums[indice],suma2) || 
        splitOdd10aux(nums,indice+1,suma1,suma2+nums[indice]);
    }

    public boolean groupSum6(int start, int[] nums, int target) {
        if(start>=nums.length || nums.length == 0)return target == 0;
        if(nums[start]%6 == 0) return groupSum6(start+1, nums, target-nums[start]);
        else return groupSum6(start+1, nums, target-nums[start]) || groupSum6(start+1, nums, target);
    }

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start>=nums.length)return target == 0;
        return groupNoAdj(start+2, nums, target-nums[start]) || groupNoAdj(start+2,nums,target) ||
        groupNoAdj(start+1, nums, target) || groupNoAdj(start+1,nums,target);
    }
           
}