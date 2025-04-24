public class SquarefreeBinomialCoefficients {

    public long sumOfRow(int num) {
        return (long) Math.pow(2, num-1);
    }

    public static long[] row(int num) {
        if (num == 1) {
            return new long[]{1};
        } else if (num == 2) {
            return new long[]{1, 1};
        } else if (num==3) {
            return new long[]{1, 2, 1};
        } else if (num > 3) {

            long[] result = new long[3];

            long[] temp = row(3);

            for (int j=3; j<num; j++) {
                result = new long[j+1];
                result[0] = 1;
                result[j] = 1;


                for (int i = 1; i < j; i++) {
                    result[i] = temp[i - 1] + temp[i];
                }
                temp = result;
            }
            return result;
        }
        return new long[num];
    }

    public static boolean isSquareFree(long n) {
        for (long k = 2; k * k <= n; k++) {
            if (n % (k * k) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int rowNum = 8;
        System.out.println(new SquarefreeBinomialCoefficients().sumOfRow(rowNum));
        long[] squarefrees = new long[30];
        squarefrees[0] = 1;
        int c = 1;

        /*long[] rowN = row(rowNum);
        for (int i=0; i<rowNum; i++) {
            System.out.print(rowN[i] + " ");
        }*/
        for (int i=1; i<=rowNum; i++) {
            long[] rowN = row(i);
            for (int j = 0; j < i; j++) {
                System.out.print(rowN[j] + " ");
                if (rowN[j] == 1) {
                    continue;
                } else if (isSquareFree(rowN[j])) {
                    squarefrees[c++] = rowN[j];
                }
            }
            System.out.println();

        }
        long sum = 0;
        //need to sanitise list to remove copies of numbers and then need to sum them
        for (long i : squarefrees) {
            System.out.println(i);
        }
    }
}
