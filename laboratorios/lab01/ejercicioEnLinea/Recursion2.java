public class Recursion2{
    public boolean splitOdd10(int[] nums) {
        return splitOdd10aux(nums, 0,0,0);
    }   
   public boolean splitOdd10aux(int [] nums, int indice,int suma1, int suma2){     
        if(indice >= nums.length)
            return (suma1%2 !=0 && suma2%10 == 0) || (suma2%10 ==0 && suma2 %2 != 0);//c_1
        return splitOdd10aux(nums,indice+1,suma1+nums[indice],suma2) || 
        splitOdd10aux(nums,indice+1,suma1,suma2+nums[indice]);//c_2+T(n-1)+T(n-1)
    }

    public boolean groupSum6(int start, int[] nums, int target) {
        if(start>=nums.length || nums.length == 0)return target == 0;//c_1
        if(nums[start]%6 == 0) return groupSum6(start+1, nums, target-nums[start]);//c_2+T(n-1)
        else return groupSum6(start+1, nums, target-nums[start]) || groupSum6(start+1, nums, target);//c_3+T(n-1)+T(n-1)
    }

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start>=nums.length)return target == 0;//c_1
        return groupNoAdj(start+2, nums, target-nums[start]) || groupNoAdj(start+2,nums,target) ||
        groupNoAdj(start+1, nums, target) || groupNoAdj(start+1,nums,target);//c_2+2T(n-2)+2T(n-1)
    }
     
    public boolean splitArray(int[] nums) {
        return splitArrayAux
        (nums,0,0,0);
    }
    public boolean splitArrayAux(int [] nums, int indice,int suma1, int suma2){
        if(indice >= nums.length){ return (suma1 == suma2); }//c_1
        return splitArrayAux(nums,indice+1,suma1+nums[indice],suma2) || 
        splitArrayAux(nums,indice+1,suma1,suma2+nums[indice]);//c_2+2T(n-1)
    }

    public boolean split53(int[] nums) {
        return split53aux(nums,0,0,0);
      }
      public boolean split53aux(int [] nums, int indice,int suma1, int suma2){
              if(indice >= nums.length){ return (suma1 == suma2); }//c_1
              else if(nums[indice]%3==0){return split53aux(nums,indice+1,suma1+nums[indice],suma2);}//c_2+T(n-1)
              else if(nums[indice]%5==0){return split53aux(nums,indice+1,suma1,suma2+nums[indice]);}//c_3+T(n-1)
              else{ return split53aux(nums,indice+1,suma1+nums[indice],suma2) || 
                    split53aux(nums,indice+1,suma1,suma2+nums[indice]);}//c_4+2T(n-1)
      }
}