package com.edu.nwmu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;



public class AssignmentTwo {

	public static void main(String[] args) {
		AssignmentTwo mainApp = new AssignmentTwo();
		Scanner scanner = new Scanner(System.in);
		try {
		do {
		System.out.println("Enter problem number to solve:");
		String problemNo = scanner.nextLine();
		
			int iProblemNo = Integer.parseInt(problemNo);
			if(iProblemNo < 1 || iProblemNo > 6) {
				throw new Exception("Problem number should be entered between 1 and 6 .");
			}
			switch (iProblemNo) {
			case 1:
				mainApp.promptInputsAndSolveProblem1(scanner);
				break;
			case 2:
				mainApp.promptInputsAndSolveProblem2(scanner);
				break;
				
			case 3:
				mainApp.promptInputsAndSolveProblem3(scanner);
				break;
			case 4:
				mainApp.promptInputsAndSolveProblem4(scanner);
				break;
			case 5:
				mainApp.promptInputsAndSolveProblem5(scanner);
				break;
			case 6:
				mainApp.promptInputsAndSolveProblem6(scanner);
				break;
			default:
				mainApp.exit();
				break;
			}
		}while(true);
		}catch(NumberFormatException e) { // gets executed only for number format exceptions
			System.out.println("You have entered a string which is not in number format");
		    mainApp.exit();
		}catch(Exception e) { // gets executed for all other exceptions
			System.out.println(e.getMessage());
			mainApp.exit();
		}

	}
	
	public void promptInputsAndSolveProblem1(Scanner sc) throws Exception {
		List<String> l1 = new ArrayList<String>();
		System.out.println("Enter the strings to solve problem1. "
				+ "Press enter to input next string in the array. When you are finished, type \"done\"");
		String inputStr = null;
		boolean isFinished = false;
		do {
			inputStr = sc.nextLine();
			
			
				if("done".equalsIgnoreCase(inputStr)) {
					isFinished = true;
				}
				else {
					l1.add(inputStr);
				}
				
			
		}while(!isFinished);
		solveProblem1(l1.toArray(new String[l1.size()]));
	}
	
	public void promptInputsAndSolveProblem2(Scanner sc) throws Exception {
		List<String> l1 = new ArrayList<String>();
		System.out.println("Enter the strings to solve problem2. "
				+ "Press enter to input next string in the array. When you are finished, type \"done\"");
		String inputStr = null;
		boolean isFinished = false;
		do {
			inputStr = sc.nextLine();
			
			
				if("done".equalsIgnoreCase(inputStr)) {
					isFinished = true;
				}
				else {
					l1.add(inputStr);
				}
				
			
		}while(!isFinished);
		solveProblem2(l1.toArray(new String[l1.size()]));
	}
	public void exit() {
		System.out.println("Application has been terminated. Please check the errors and try again");
		System.exit(0);
	}
	
	public void promptInputsAndSolveProblem3(Scanner sc) throws Exception {
		List<Integer> l1 = new ArrayList<Integer>();
		System.out.println("Enter the positive integers to solve problem3. "
				+ "Press enter to input next number in the array. When you are finished, type \"done\"");
		String inputStr = null;
		boolean isFinished = false;
		do {
			try {
			inputStr = sc.nextLine();
			int inputNo = Integer.parseInt(inputStr);
			if(inputNo >= 0) 
			  l1.add(inputNo);
			else
			  throw new Exception("You have entered a non positive integer");
			}catch(NumberFormatException e) {
				if("done".equalsIgnoreCase(inputStr)) {
					isFinished = true;
				}
				else {
					throw new Exception("You have entered a non integer. Problem 1 accepts"
							+ " only numbers");
				}
			}
		}while(!isFinished);
		solveProblem3(l1.toArray(new Integer[l1.size()]));
	}
	
	
	
	public Map<String,Integer> solveProblem1(String[] l1) {
		System.out.println("Input (L1): " + Arrays.asList(l1).toString());
		Map<String,Integer> map = new LinkedHashMap<String,Integer>();
		for(String s: l1) {
			if(!map.containsKey(s)) {
				map.put(s, 1);
			}else {
				map.put(s, map.get(s)+1);
			}
		}
		StringBuilder builder = new StringBuilder();
	    map.forEach((k,v) -> builder.append(k).append("-").append(v).append(", "));
	    if(builder.toString().contains(",")) {
	    	
	    	builder.delete(builder.length()-2, builder.length());
	    }
	    System.out.println("Output: " +builder.toString());
		return map;
	}
	
	public Map<String,String> solveProblem2(String[] l1) {
		System.out.println("Input (L1): " + Arrays.asList(l1).toString());
		Map<String,String> map = new LinkedHashMap<String,String>();
		for(String s: l1) {
			if(!map.containsKey(Character.toString(s.charAt(0)))) {
				map.put(Character.toString(s.charAt(0)), s);
			}else {
				map.put(Character.toString(s.charAt(0)), map.get(Character.toString(s.charAt(0)))+s);
			}
		}
		
		
		StringBuilder builder = new StringBuilder();
	    map.forEach((k,v) -> builder.append(k).append("-").append(v).append(", "));
	    if(builder.toString().contains(",")) {
	    	
	    	builder.delete(builder.length()-2, builder.length());
	    }
	    System.out.println("Output: " +builder.toString());
		return map;
	}
	
	public List<Integer> solveProblem3(Integer[] l1) {
		System.out.println("Input (A1): " + Arrays.asList(l1).toString());
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		for(Integer i: l1) {
			if(!map.containsKey(i)) {
				map.put(i, 0);
				l2.add(i);
			}else {
				map.put(i, map.get(i)+1);
				l2.add(i + map.get(i));
			}
		}
		
		
		
	    System.out.println("Output(s): " +l2.toString());
		return l2;
	}
	
	public void promptInputsAndSolveProblem4(Scanner sc) throws Exception {
		List<String> l1 = new ArrayList<String>();
		System.out.println("Enter the non empty strings to solve problem4. "
				+ "Press enter to input next string in the array. When you are finished, type \"done\"");
		String inputStr = null;
		boolean isFinished = false;
		do {
			inputStr = sc.nextLine();
			
			
				if("done".equalsIgnoreCase(inputStr)) {
					isFinished = true;
				}
				else if("".equals(inputStr.trim())) {
					throw new Exception("You have entered empty string. Please try again");
				}
				else {
					l1.add(inputStr);
				}
				
			
		}while(!isFinished);
		solveProblem4(l1.toArray(new String[l1.size()]));
	}

	
	
	public List<String> solveProblem4(String[] l1) {
		System.out.println("Input (A1): " + Arrays.asList(l1).toString());
		
		
		Set<String> set = new HashSet<String>();
		List<String> output = new ArrayList<String>();
		
		for(String i: l1) {
			
			for(int j=0; j< i.length(); j++) {
				if(!set.contains(Character.toString(i.charAt(j))))
				  set.add(Character.toString(i.charAt(j)));
			}
			output.add(set.stream().collect(Collectors.joining("")));
			set.clear();
		}
		
		
		
	    System.out.println("Output(s): " +output.toString());
		return output;
	}
	
	public void promptInputsAndSolveProblem5(Scanner sc) throws Exception {
		List<String> l1 = new ArrayList<String>();
		System.out.println("Enter the non empty strings to solve problem5. "
				+ "Press enter to input next string in the array. When you are finished, type \"done\"");
		String inputStr = null;
		boolean isFinished = false;
		do {
			inputStr = sc.nextLine();
			
			
				if("done".equalsIgnoreCase(inputStr)) {
					isFinished = true;
				}
				else if("".equals(inputStr.trim())) {
					throw new Exception("You have entered empty string. Please try again");
				}
				else {
					l1.add(inputStr);
				}
				
			
		}while(!isFinished);
		solveProblem5(l1.toArray(new String[l1.size()]));
	}

	
	
	public Map<String,String> solveProblem5(String[] l1) {
		System.out.println("Input (A1): " + Arrays.asList(l1).toString());
		
		
		
		Map<String,String> output = new LinkedHashMap<String,String>();
		
		for(String i: l1) {
			
			output.put(Character.toString(i.charAt(0)), Character.toString(i.charAt(i.length()-1)));
		}
		
		
		
	    System.out.println("Output(s): " +output.toString());
		return output;
	}
	
	public void promptInputsAndSolveProblem6(Scanner sc) throws Exception {
		List<String> l1 = new ArrayList<String>();
		System.out.println("Enter the non strings to solve problem6. "
				+ "Press enter to input next string in the array. When you are finished, type \"done\"");
		String inputStr = null;
		boolean isFinished = false;
		do {
			inputStr = sc.nextLine();
			
			
				if("done".equalsIgnoreCase(inputStr)) {
					isFinished = true;
				}
				else if("".equals(inputStr.trim())) {
					throw new Exception("You have entered empty string. Please try again");
				}
				else {
					l1.add(inputStr);
				}
				
			
		}while(!isFinished);
		solveProblem6(l1.toArray(new String[l1.size()]));
	}

	
	
	public Map<String,Boolean> solveProblem6(String[] l1) {
		System.out.println("Input (A1): " + Arrays.asList(l1).toString());
		
		
		
		Map<String,Boolean> output = new LinkedHashMap<String,Boolean>();
		
		for(String i: l1) {
			if(!output.containsKey(i))
			   output.put(i, false);
			else
			   output.put(i, true);	
		}
		
		
		
	    System.out.println("Output(s): " +output.toString());
		return output;
	}
}
