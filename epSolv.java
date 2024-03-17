import java.util.ArrayList;
import java.util.Scanner;

class checkIt {
    ArrayList<Integer> num = new ArrayList<>();
    ArrayList<Character> op = new ArrayList<>();

    public int checkNum(String equ) {

        int i = 0;

        do {

            if (equ.charAt(i) != '-' && equ.charAt(i) != '+' && equ.charAt(i) != '*' && equ.charAt(i) != '/') {

                try {
                    num.add(Integer.parseInt(String.valueOf(equ.charAt(i))));
                    op.add(null);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number input : " + e.getMessage());
                    return 1;
                }

            } else {
                op.add(equ.charAt(i));
                num.add(null);
            }

            i++;
            if (i == equ.length()) {
                return 0;
            }

        } while (true);

    }

    public int checkOp() {


        if (op.getFirst() == null && op.getLast() == null) {
//            System.out.println("S and E!");
            for (int l = 0; l < op.size(); l++) {
                if (op.get(l) != null && op.get(l + 1) == null && op.get(l - 1) == null) {
//                    System.out.println("I" + op.get(l));
                } else if (op.get(l) != null) {
//                    System.out.println("O");
                    System.out.println("Double Operator, re-enter the equation");
                    return 1;
                }

            }
        } else {
            System.out.println("Invalid equation");
            return 1;
        }
        return 0;
    }

    public ArrayList<Character> finalOP() {

        ArrayList<Character> finOp = new ArrayList<>(op);


        // /0 + /0 /0
        int j = 1;
        for (int i = 0; i < finOp.size() - 1; ) {

            Character a = finOp.get(i);
            Character b = finOp.get(j);

            if (a == b) {
                finOp.remove(j);
            } else {
                i++;
                j++;
            }

        }

//        System.out.println(finOp);
//        System.out.println(num);
//        System.out.println(fin);

        return finOp;

    }

    public ArrayList<Integer> finalNum() {

        ArrayList<Integer> finNum = new ArrayList<>();
//        ArrayList<Character> finOp = new ArrayList<>(op);


        int sum = 0;

        for (Integer a : num) {

            if (a == null) {

                finNum.add(sum);

                finNum.add(null);

                sum = 0;

            } else {

                sum = (sum * 10) + a;


            }
        }

        finNum.add(sum);

//        System.out.println(num);
//        System.out.println(finOp);

        return finNum;

    }


    Integer solv(ArrayList<Integer> numTe, ArrayList<Character> opTe) {

        int k = 1;
        char temp;
        int count = 0;
        char[] dmas = new char[]{'/', '*', '+', '-'};

        for (int i = 0; i < dmas.length; i++) {
            temp = dmas[i];
            switch (temp) {
                case '/': {
                    for (int j = 0; j < opTe.size(); j++) {
                        if (opTe.get(j) != null && opTe.get(j) == dmas[i]) {
                            numTe.set(j, numTe.getFirst() / numTe.get(k + 1));
                            opTe.set(k, null);
                            numTe.remove(k + 1);
                            numTe.removeFirst();
                            opTe.remove(k + 1);
                            opTe.removeFirst();
                            count += 1;
                        }
                    }
                    System.out.println(count);
                    count = 0;
                    break;
                }
                case '*': {
                    for (int j = 0; j < opTe.size(); j++) {
                        if (opTe.get(j) != null && opTe.get(j) == dmas[i]) {
                            numTe.set(k, numTe.getFirst() * numTe.get(k + 1));
                            opTe.set(k, null);
                            numTe.remove(k + 1);
                            numTe.removeFirst();
                            opTe.remove(k + 1);
                            opTe.removeFirst();
                            count += 1;
                        }
                    }
                    System.out.println(count);
                    count = 0;
                    break;
                }
                case '+': {
                    for (int j = 0; j < opTe.size(); j++) {
                        if (opTe.get(j) != null && opTe.get(j) == dmas[i]) {
                            numTe.set(k, numTe.getFirst() + numTe.get(k + 1));
                            opTe.set(k, null);
                            numTe.remove(k + 1);
                            numTe.removeFirst();
                            opTe.remove(k + 1);
                            opTe.removeFirst();
                            count += 1;
                        }
                    }
                    System.out.println(count);
                    count = 0;
                    break;
                }
                case '-': {
                    for (int j = 0; j < opTe.size(); j++) {
                        if (opTe.get(j) != null && opTe.get(j) == dmas[i]) {
                            numTe.set(k, numTe.getFirst() - numTe.get(k + 1));
                            opTe.set(k, null);
                            numTe.remove(k + 1);
                            numTe.removeFirst();
                            opTe.remove(k + 1);
                            opTe.removeFirst();
                            count += 1;
                        }
                    }
                    System.out.println(count);
                    count = 0;
                    break;
                }
            }

        }

//        do {
//            if (numTe.get(i) == null && opTe.get(i) == '+') {
//
//                numTe.set(i, numTe.getFirst() + numTe.get(i + 1));
//                opTe.set(i, null);
//                numTe.remove(i + 1);
//                numTe.removeFirst();
//                opTe.remove(i + 1);
//                opTe.removeFirst();
//                si = si - 2;
//            }
//        } while (numTe.size() != 1);

        return numTe.getFirst();

    }
}


public class test1 {
    //    public void checkNum(String equ) {
//
//        int poin = 0, i = 0;
//        ArrayList<Integer> num = new ArrayList<>();
//        ArrayList<Character> op = new ArrayList<>();
//
//        do {
//
//            if (equ.charAt(i) != '-' && equ.charAt(i) != '+' && equ.charAt(i) != '*' && equ.charAt(i) != '/') {
//
//                try {
//                    num.add(Integer.parseInt(String.valueOf(equ.charAt(i))));
//                    op.add(null);
//                } catch (NumberFormatException e) {
//                    System.err.println("Invalid input: " + e.getMessage());
//                    break;
//                }
//
//            } else {
//                op.add(equ.charAt(i));
//                num.add(null);
//            }
//
//            i++;
//            if (i == equ.length()) {
//                break;
//            }
//
//        } while (true);
//
//    }
    public static void main(String[] args) {

        Scanner str = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        do {
            int point = 0;
            checkIt obj = new checkIt();

            System.out.println("enter math equation :");
            String equ = str.nextLine();
            point = obj.checkNum(equ);

            System.out.println("You enter : " + equ);

            if (point == 0) {
                point = obj.checkOp();
                if (point == 0) {

                    int ans = obj.solv(obj.finalNum(), obj.finalOP());
//                    obj.finalOP();
//                    System.out.println("Sovle : ");
                    System.out.println("Sovle : " + ans);
                }
            }
            System.out.println("enter '0' to exit:");
            int e = Integer.parseInt(in.nextLine());
            if (e == 0) {
                break;
            }
        } while (true);


    }

}
