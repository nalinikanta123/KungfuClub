package org.test.springtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class testService {

	public int a=10;
	
	public int getAllInfo(){
		return a; 
	}
}
