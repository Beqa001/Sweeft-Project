import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        DataStructure<Integer> integerDataStructure = new DataStructure<>();
        integerDataStructure.add(3);
        integerDataStructure.add(4);
        integerDataStructure.add(5);
        integerDataStructure.add(6);
        integerDataStructure.pop();
        System.out.println(integerDataStructure.toString());

        System.out.println(minSplit(49));
    }

    public static int notContains(int[] array){
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }

        int min = 1;

        while (set.contains(min)) {
            min++;
        }

        return min;
    }

    public static String binaryString(String a,String b){
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static int countVariants(int n) {
        if(n<1){
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        } else {
            return countVariants(n - 1) + countVariants(n - 2);
        }
    }

    public static int singleNumber(int[] array) {
        Set<Integer> seen = new HashSet<>();
        int sum = 0;
        int uniqueSum = 0;
        for (int num : array) {
            if (!seen.contains(num)) {
                seen.add(num);
                uniqueSum += num;
            }
            sum += num;
        }
        return 2 * uniqueSum - sum;
    }

    public static int minSplit(int amount){
        int result = 0;

        if(amount/50>0){
            result +=amount/50;
            amount=amount%50;
        }
        if(amount/20>0){
            result +=amount/20;
            amount=amount%20;
        }
        if(amount/10>0){
            result +=amount/10;
            amount=amount%10;
        }
        if(amount/5>0){
            result +=amount/5;
            amount=amount%5;
        }
        result +=amount;
        return result;

    }
}