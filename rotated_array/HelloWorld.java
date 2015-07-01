public class HelloWorld{

     public static void main(String []args){
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        RotatedArray rotate = new RotatedArray(arr);
        rotate.leftRotate(2, 7);
        rotate.printArray(7);
        int numberToSearch = 7;
        System.out.println("search position of "
            +numberToSearch
            +" : " 
            + rotate.search(arr.length,numberToSearch));
     }
}
