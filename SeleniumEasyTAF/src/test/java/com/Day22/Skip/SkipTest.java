package com.Day22.Skip;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTest 
{
	String flag = "false";
	 //Throws skip exception
	@Test
	public void Test1() 
	{
		if (flag.equals("true")) 
		{
			System.out.println("Test 1 will be executed and Test 2 will be skipped.");
		} 
		else 
		{
			throw new SkipException("Skipping Test 1 as flag is false.");
		}
	 
	}
	 //Executes this test 
	@Test
	public void Test2() 
	{
		if (flag.equals("false")) 
		{
			System.out.println("Test 2 will be executed and Test 1 will be skipped.");
		} 
		else 
		{
			throw new SkipException("Skipping Test 2 as flag is true.");
		}
	}
	//Skips complete test
	@Test(enabled = false)
	public void Test3() 
	{
		System.out.println("Test is not ready!!!!!");
	}
}
