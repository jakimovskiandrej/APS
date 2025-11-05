package aud3;

public class CalcPostfix {
    public static double evaluirajPostfix(String izraz) {
        LinkedStack<Double> stack = new LinkedStack<>();
        Double r = null;

        for (int i = 0; i < izraz.length(); i++) {
            char c = izraz.charAt(i);
            if(c == ' ') {
                continue;
            }
            else if(Character.isDigit(c)) {
                stack.push((double) c - '0');
            }
            else {
                if(stack.size() >= 2) {
                    double lastNum = stack.pop();
                    double lastNum2 = stack.pop();
                    switch (c) {
                        case '+':
                            stack.push(lastNum2 + lastNum);
                            break;
                        case '*':
                            stack.push(lastNum2 * lastNum);
                            break;
                        case '/':
                            stack.push(lastNum2 / lastNum);
                            break;
                        case '-':
                            stack.push(lastNum2 - lastNum);
                            break;
                    }
                } else {
                    System.out.println("Nevaliden vlez");
                    return r;
                }
            }
        }
        if(stack.size() != 1) {
            System.out.println("Nevaliden vlez");
        } else {
            r = stack.pop();
        }
        return r;
    }

    public static void main(String[] args) {
        String primer = "5 9 + 2 * 6 5 * +";
        System.out.println("Rezultat: " + evaluirajPostfix(primer));
    }
}
