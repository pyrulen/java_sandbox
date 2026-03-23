package dev.pyrulen.leet.bigint;

import java.util.LinkedList;

public class BigIntMultiplier {
    public String multiplyLargeNumbers(String num1, String num2) {
        int[] multiplicand = toIntArr(num1);
        int[] multiplier = toIntArr(num2);
        int[] sum = new int[]{0};
        for(int i = 0; i < multiplier.length; i++){
            int[] product = multiplyLargeInt(multiplicand, multiplier[i]);
            int[] shiftedProduct = new int[product.length + i];
            System.arraycopy(product, 0, shiftedProduct, i, product.length);
            sum = sumLargeInt(new int[][] { shiftedProduct, sum });
        }
        StringBuilder sb = new StringBuilder();
        boolean leadingZeros = true;
        for(int i = sum.length - 1; i >= 0; i--){
            if(sum[i] != 0){
                leadingZeros = false;
            }
            if(!leadingZeros) {
                sb.append(sum[i]);
            }
        }
        String stringResult = sb.toString();
        return stringResult.length() > 0 ? stringResult : "0";
    }

    /**
     * Convert a string to an array of integers, 0-9, with the
     * assumption that all characters in the array are between
     * '0' and'9' inclusive.
     *
     * Returned array of integers is little endian. That is, the
     * ones digit is at index 0, the tens at index 1, and so forth.
     */
    public int[] toIntArr(String s) {
        int[] result = new int[s.length()];
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            result[i] = chars[i] - '0';
        }
        return reverse(result);
    }

    public int[] multiplyLargeInt(int[] multiplicand, int multiplier){
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;
        int digitIndex = 0;
        int base = 10;
        for(; digitIndex < multiplicand.length; digitIndex++) {
            int product = multiplier * multiplicand[digitIndex];
            int value = product + carry;
            result.add(value % base);
            carry = value / base;
        }
        while(carry != 0) {
            result.add(carry % base);
            digitIndex++;
            carry /= base;
        }
        int[] resultAsArray = new int[digitIndex];
        digitIndex = 0;
        for(int i : result) {
            resultAsArray[digitIndex++] = i;
        }
        return resultAsArray;
    }

    /**
     * For each array, treat the array as a little endian base 10 number
     * and find the sum of all arrays.
     */
    public int[] sumLargeInt(int[][] values) {
        LinkedList<Integer> result = new LinkedList<>();
        int base = 10;
        int digitIndex = 0;
        /**
         * we are safe to use an int here as the num1 and num2 maximium lengths will be 500 digits. 500*500*9 is 2250000, which is within the max value for an int.
         * However, if we want to support larger numbers of digits, then we should only ever pass a 2d array of values to this method and our external multiplication
         * function should sum after each digit in the multiplier.
         */
        int sum = 0;
        while(true) {
            Boolean touched = false;
            for(int i = 0; i < values.length; i++) {
                int[] number = values[i];
                if(number.length > digitIndex) {
                    touched = true;
                    sum += number[digitIndex];
                }
            }
            if(!touched) {
                break;
            } else {
                result.add(sum % base);
                sum /= base;
                digitIndex++;
            }
        }
        while (sum > 0) {
            result.add(sum % base);
            sum /= base;
            digitIndex++;
        }
        int[] resultAsArray = new int[digitIndex];
        digitIndex = 0;
        for(int i : result) {
            resultAsArray[digitIndex++] = i;
        }
        return resultAsArray;
    }

    public int[] reverse(int[] arr){
        int[] result = new int[arr.length];
        for(int i = 0 ; i < arr.length; i++) {
            result[arr.length - 1 - i] = arr[i];
        }
        return result;
    }

    public void display(int[] arr) {
        System.out.println(toString(arr));
    }

    public String toString(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
            if(i != arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}