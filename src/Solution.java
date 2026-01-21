import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {

    public String minRemoveToMakeValid(String s) {

        /**
         * We use stack to keep track of valid pairs of parentheses and we use hashSet
         * to mark indices of invalid parentheses that should be removed.
         */
        /**
         * Initializing variables
         */
        Set<Integer> removeIndices = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        /**
         * Iterate through the entire string
         */
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            /**
             * If opening bracket, push it to the stack
             */
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                /**
                 * if the stack is empty than this is an invalid case
                 */
                if (stack.isEmpty()) {
                    removeIndices.add(i);
                } else {
                    /**
                     * for valid entry, pop it from the stack so that a valid pair is accounted for
                     */
                    stack.pop();
                }
            }
        }
        /**
         * Add remining unmatched opening brackets to the set
         */
        while (!stack.isEmpty()) {
            removeIndices.add(stack.pop());

        }

        /**
         * build the result string
         */
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            /**
             * For the indices that are present in removeIndices set, we skip them. those
             * which are not present in removeIndices are appended in the stringbuilder
             * variable.
             */
            if (!removeIndices.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

}
