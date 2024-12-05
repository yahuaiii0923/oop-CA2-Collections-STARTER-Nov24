package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  Name:Siew Ya Huai
 *  Class Group:SD2b
 */
public class Question3  {   //Nested HTML (Stack)

    /*
filename: name of the file to test.
*/
    public static boolean validate(String filename) throws FileNotFoundException
    {
        String[] selfClosingTags = {"<br>", "<img>", "<hr>", "<input>","<meta>","<link>"};

        Scanner scanner = new Scanner(new File(filename));
        Stack<String> tagStack = new Stack<>();



        while (scanner.hasNext()) {
            String tag = scanner.next();

            //check if it's a self-closing tag
            boolean isSelfClosing = false;
            for(String selfClosingTag : selfClosingTags){
                if(tag.equals(selfClosingTag)){
                    isSelfClosing = true;
                    break;
                }
            }

            //if it is self closing tag, skip the iteration
            if (isSelfClosing){
                continue;
            }
            if (tag.startsWith("</")){
                if(tagStack.isEmpty()){
                    scanner.close();
                    return false;
                }
                //pop the top element
                String lastAccessedTag = tagStack.pop();
                if(!tag.equals("</" + lastAccessedTag.substring(1))){
                    scanner.close();
                    return false;
                }
            } else if (tag.startsWith("<") && tag.endsWith(">")) {
                tagStack.push(tag);
            }
        }
        scanner.close();
        //the stack should be empty if all tags are matched because they are popped
        return tagStack.isEmpty();
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }



}


