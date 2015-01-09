package com.java.drivers;

import com.java.utils.SortUtils;
import com.java.utils.UserExceptions.StackEmptyException;
import com.java.utils.ds.LinkedStack;

public class StackDriver extends SortUtils {

  public static void main(String[] args) throws StackEmptyException  {
    //Stack<String> s = new Stack<String>();
	  LinkedStack<String> s = new LinkedStack<String>();
    
    System.out.println(s.isEmpty());
    s.push("test");
    s.push("te1");
    s.push("te2");
    s.push("te3");
    s.push("te4");
    s.push("te5");
    System.out.println(s.size());
    for (String si : s){
    	System.out.println("Itr: "+si);
    }
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
 //   System.out.println(s.pop());
    



  }

}
