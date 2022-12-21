package restfulwebservices.RomanNumerals;
import java.util.*;
import java.io.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Conversion_controller {
	
	@GetMapping(path ="/roman-to-numeral/{name}")
	public String roman_to_numerals(@PathVariable String name) {
		Map<Character, Integer> map = new HashMap();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int res =0;
		for(int i=0;i<name.length();i++) {
			if(i>0 && map.get(name.charAt(i))> map.get(name.charAt(i-1))) {
				res+=map.get(name.charAt(i)) - 2 * map.get(name.charAt(i-1));
			}
			else {
			res+=map.get(name.charAt(i));
			}
		}
		
		System.out.println("The converted integer for given roman number is "+ res);
		return "The converted integer for given roman number is "+ res;
		//return new convert("The converted integer for given roman number is "+ res);
	}
	
	@GetMapping(path ="/numeral-to-roman/{msg}")
	public String numeral_to_roman(@PathVariable int msg) {
		String[] thousands =new String[] {"","M","MM","MMM","MMMM"};
		String[] hundreds = new String[] {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String[] tens = new String[] {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String[] units = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
		
		String res="";
		if(msg<0) {
			return "Please provide a positive integer.";
		}
		else {
			res = thousands[msg/1000]+ hundreds[(msg%1000)/100]+ tens[(msg%100)/10]+units[msg%10];
		}
		return "The converted roman literal for given integer is " + res;
	}

}
