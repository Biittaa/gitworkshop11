package com.example.demo30;


import java.util.*;

public class Calculate implements Runnable {
    String check;
    String result;

    public Calculate(String check) {
        this.check = check;
    }

    @Override
    public void run() {
        System.out.println(check);
        String[] tokens = check.split("\\s");
        ArrayList<Double> numbers = new ArrayList<>();
        ArrayList<String> operation = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            double t = 0;
            int f = 1;
            while (isNumber(tokens[i])) {
                double num = Double.parseDouble(tokens[i]);
                t = t * 10 + num;
                f = f * 10;
                i++;
            }
            numbers.add(t);
            operation.add(tokens[i]);
        }
        int j = 0;
        while (true) {
            Double r;
            if (operation.get(j).equals("=")) {
                break;
            }
            if (operation.get(j).equals("*")) {
                r = numbers.get(j) * numbers.get(j + 1);
                numbers.remove(j);
                numbers.add(j, r);
                numbers.remove(j + 1);
                operation.remove(j);
                j--;
            } else if (operation.get(j).equals("/")) {
                r = numbers.get(j) / numbers.get(j + 1);
                numbers.remove(j);
                numbers.add(j, r);
                numbers.remove(j + 1);
                operation.remove(j);
                j--;
            }
            j++;
        }
        j = 0;
        while (true) {
            Double r;
            if (operation.get(j).equals("=")) {
                break;
            }
            if (operation.get(j).equals("+")) {
                System.out.println(j);
                r = numbers.get(j) + numbers.get(j + 1);
                numbers.remove(j);
                numbers.add(j, r);
                numbers.remove(j + 1);
                operation.remove(j);
                System.out.println(numbers.get(j));
                j--;
            } else if (operation.get(j).equals("-")) {
                r = numbers.get(j) - numbers.get(j + 1);
                numbers.remove(j);
                numbers.add(j, r);
                numbers.remove(j + 1);
                operation.remove(j);
                j--;

            }
            j++;
        }
        result = Double.toString(numbers.get(0));
    }

    protected boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String getResult() {
        return result;
    }
}
