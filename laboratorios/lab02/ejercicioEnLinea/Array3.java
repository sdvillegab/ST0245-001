/**
 * Ejercicios de codingbat Array3
 * 
 * @author Julian Ramirez,Samuel Villegas
 */
public class Array3 {

    /**
     * seriesUp
     * 
     * @param n
     * @return int[]
     */
    public int[] seriesUp(int n) {
        int lon = (n * (n + 1)) / 2;
        int vec[] = new int[lon];
        int indice = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                vec[indice] = j;
                indice++;
            }
        }
        return vec;
    }

    /**
     * countClumps
     * 
     * @param int[]
     * @return int
     */
    public int countClumps(int[] nums) {
        int count = 0;
        for(int i = 0;i < nums.length;i++){
          int n = nums[i];  
          boolean group = false;
          for(int j = i+1; j < nums.length && n == nums[j]; j++){
              if(group == false){
                count++;
                group = true;
              }
              i+=1;
          }
        }
        return count;
      }

      /**
       * maxSpan
       * 
       * @param int[]
       * @return int
       */
      public int maxSpan(int[] nums) {
        if(nums.length<=1)return nums.length;      
              int aum=1;      
              for (int i = 0; i < nums.length; i++) {
                  for(int j = i+1;j<nums.length;j++){
                      if(nums[i] == nums[j]){
                          if((j-i+1)>aum){
                              aum = j-i+1;
                          }
                      }
                  }
              }
        return aum;
      }

      /**
       * canBalance
       * 
       * @param int[]
       * @return boolean
       * 
       */
    public boolean canBalance(int[] nums) {
        int aum1=0;
        int aum2=0;      
        for(int j = 0;j<nums.length;j++){
             aum2+=nums[j];
        }     
        for (int i = 0; i < nums.length; i++) {
             aum1+=nums[i];
            aum2-=nums[i];
           if(aum1==aum2)return true;
        }
        return false;
    }

    /**
     * linearIn
     * 
     * @param int[],int[]
     * @return boolean
     */
    public boolean linearIn(int[] outer, int[] inner) {
        if(inner.length == 0) return true;
         int j =0;    
        for (int k = 0; k < outer.length; k++) {
             if(outer[k] == inner [j])j++;   
             if(j == inner.length) return true;
        }      
         return false;
    }
        
    

}
