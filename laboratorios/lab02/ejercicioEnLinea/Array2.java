
/**
 * Ejercicios de codingbat Array2
 * 
 * @autor Julian Ramirez,Samuel Villegas
 */
public class Array2{

    /**
     * countArray 
     * 
     * @param nums[] arreglo de enteros
     * @return int
     */
    public int countEvens(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
          if(nums[i] % 2 == 0){
              j++;
          }
        }
        return j;
    }

    /**
     * bigDiff 
     * 
     * @param nums[] arreglo de enteros
     * @return int
     */
    public int bigDiff(int[] nums) {
        int max = 0;
        int min = nums[0];
        for(int i = 0; i < nums.length;i++){
            if(nums[i] > max){
              max = nums[i];
            }
        }
         for(int i = 0; i  < nums.length; i++){
            if(nums[i] < min){
              min = nums[i];
            }
        }
        return max - min;
    }

    /**
     * sum13
     * 
     * @param  nums[] arreglo de enteros
     * @return int
     */
    public int sum13(int[] nums) {
        int suma = 0;
        if(nums.length == 0) return 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 13){
                suma += nums[i];
            }
            else{
              i += 1;
            }
        }
        return suma;
      }

     /**
       *sum67
       * 
       *  @param nums[] arreglo de enteros
       * @return int
      */
    public int sum67(int[] nums) {
        int suma = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 6){
                while(nums[i] != 7){
                  i++;
                }
            }
            else{
              suma += nums[i];
            }
        }
        return suma;
    }

    /**
     * has22
     * 
     * @param int[]  arreglo de enteros
     * @return int
     */
    public boolean has22(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
          if(nums[i] == 2){
            if(nums[i+1] ==  2) return true;
          }
        }
        return false;
      }
}