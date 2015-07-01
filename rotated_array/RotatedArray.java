public class RotatedArray{
    private int mArray[];
    
    public RotatedArray(int array[]){
        mArray=array;
    }
    
    public int search(int size, int key) {
        int left = 0;
        int right = size - 1;
 
        while (left <= right) {
            // Avoid overflow, same as middle=(left+right)/2
            int middle = left + ((right - left) / 2);
            if (mArray[middle] == key) return middle;
 
            // the bottom half is sorted
            if (mArray[left] <= mArray[middle]) {
                if (mArray[left] <= key && key < mArray[middle])
                    right = middle - 1;
                else
                    left = middle + 1;
            }
            // the upper half is sorted
            else {
                if (mArray[middle] < key && key <= mArray[right])
                    left = middle + 1;
                else 
                    right = middle - 1;
            }
        }
        return -1;
    }
    
    /*
     * Function to left rotate mArray[] of siz n by d
     * Time complexity: O(n)
     * Auxiliary Space: O(1)
     */
    public void leftRotate(int d, int n){
        if(n>mArray.length)
            throw new RuntimeException("size to rotate > size of the array");
        
        int j, k, temp;
        for (int i = 0; i < gcd(d, n); i++) {
            /* move i-th values of blocks */
            temp = mArray[i];
            j = i;
            do{
                k = j + d;
                if (k >= n){
                    k = k - n;
                }
                if(k!=i){
                    mArray[j] = mArray[k];
                    j = k;
                }
            }while(k!=i);
            
            mArray[j] = temp;
        }
    }
 
     /*
     * Fuction to get gcd of a and b
     * is the largest positive integer that divides the numbers without a 
     * remainder. 
     * For example, the GCD of 8 and 12 is 4
     */
    private int gcd(int toShift,int size){
        if(size==0) return toShift;
        return gcd(size, toShift % size);
    }
 
    /* function to print an array */
    public void printArray(int size){
        for(int i = 0; i < size; i++){
            System.out.print(mArray[i]+" ");
        }
        System.out.print("\n");
    }
}