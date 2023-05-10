package stack;

import java.util.Stack;

class StartStacks {
    public static void main(String[] args) {
        // Create a stack
        Stack<String> Customers = new Stack<String>();

        // Populate the stack
        Customers.push("Jane_Doe_1"); // Bottom item
        Customers.push("John_Doe_2");
        Customers.push("Shane_Doe_3");
        Customers.push("Jack_Doe_4");
        Customers.push("Jill_Doe_5");
        Customers.push("Gertrude_Doe_6");
        Customers.push("Mick_Doe_7"); // Top item

        // View object at the top of the stack
        System.out.println(Customers.peek());
        /*
         * Misc-Programs\java\stack on  main [?] via ☕ v11.0.18 on ☁️ (us-east-1)
         * 
         * ❯ java .\StartStacks.java
         * 
         * Mick_Doe_7
         */

        /*
         * Stack is very restrictive in how it allows interactions. Topmost item should be mostly
         * interacted with. Stack inherits from Vector class.
         */

        // Print the stack
        System.out.println(Customers.toString());
        /*
         * Misc-Programs\java\stack on  main [?] via ☕ v11.0.18 on ☁️ (us-east-1)
         * 
         * ❯ java .\StartStacks.java
         * 
         * [Jane_Doe_1, John_Doe_2, Shane_Doe_3, Jack_Doe_4, Jill_Doe_5, Gertrude_Doe_6, Mick_Doe_7]
         * 
         */

        // Find the index of an item in the stack, where 0 is the bottom most item.
        System.out.println(Customers.indexOf("Jill_Doe_5"));
        System.out.println(Customers.indexOf("Jane_Doe_1"));
        System.out.println(Customers.indexOf("Mick_Doe_7"));
        System.out.println(Customers.indexOf("Ricky_Doe_8"));
        /*
         * Misc-Programs\java\stack on  main [?] via ☕ v11.0.18 on ☁️ (us-east-1)
         * 
         * ❯ java .\StartStacks.java
         * 
         * 4
         * 
         * 0
         * 
         * 6
         * 
         * -1
         */

        // Search an item relative to the top of the stack, where topmost item has position of 1.
        System.out.println(Customers.search("Jane_Doe_1"));
        System.out.println(Customers.search("Mick_Doe_7"));
        System.out.println(Customers.search("Ricky_Doe_8"));
        /*
         * Misc-Programs\java\stack on  main [?] via ☕ v11.0.18 on ☁️ (us-east-1)
         * 
         * ❯ java .\StartStacks.java
         * 
         * 7
         * 
         * 1
         * 
         * -1
         */

        // Update items in a stack
        System.out.println(Customers.toString());
        Customers.pop();
        Customers.pop();
        Customers.push("Ella_Doe_8");
        Customers.push("Micky_Doe_7");
        System.out.println(Customers.toString());
        /*
         * Misc-Programs\java\stack on  main [?] via ☕ v11.0.18 on ☁️ (us-east-1)
         * 
         * ❯ java .\StartStacks.java
         * 
         * [Jane_Doe_1, John_Doe_2, Shane_Doe_3, Jack_Doe_4, Jill_Doe_5, Gertrude_Doe_6, Mick_Doe_7]
         * 
         * [Jane_Doe_1, John_Doe_2, Shane_Doe_3, Jack_Doe_4, Jill_Doe_5, Ella_Doe_8, Micky_Doe_7]
         * 
         */

        // To delete an item, pop it from the stack
        // Delete all items in the stack
        System.out.println(Customers.toString());
        Customers.clear();
        System.out.println(Customers.toString());
        System.out.println(Customers.empty());
        /*
         * Misc-Programs\java\stack on  main [?] via ☕ v11.0.18 on ☁️ (us-east-1)
         * 
         * ❯ java .\StartStacks.java
         * 
         * [Jane_Doe_1, John_Doe_2, Shane_Doe_3, Jack_Doe_4, Jill_Doe_5, Ella_Doe_8, Micky_Doe_7]
         * 
         * []
         * 
         * true
         */

         
    }
}
