public class Main {
    public static void main(String[] args) {
        System.out.print("How many numbers: ");
        int num = IO.readInt();
        double array[] = new double[num];
        for (int i = 0; i < num; i++) {
            System.out.print("["+i+"]Please enter your double");
            array[i] = IO.readDouble();
        }

        //Sort
        double temp = 0;
        for (int i = 0; i < num - 1; i++) {
            for (int j = i + 1; j < num ; j++) {
                if (array[j] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                 }
            }
        }

        //Result
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
