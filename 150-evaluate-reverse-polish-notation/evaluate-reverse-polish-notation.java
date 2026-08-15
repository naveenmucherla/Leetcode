class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s.equals("+") ||s.equals("-") ||s.equals("*") ||s.equals("/") ){
                int elem1 = stack.pop();
                int elem2 =  stack.pop();
                int eq = 0;
                switch(s){
                    case "+" -> eq = elem2 + elem1;
                    case "-" -> eq = elem2 - elem1;
                    case "*" -> eq = elem2 * elem1;
                    case "/" -> eq = elem2 / elem1;
                }

                stack.push(eq);
            }
            else
             stack.push(Integer.parseInt(s));
        }
        return stack.peek();
    }
}