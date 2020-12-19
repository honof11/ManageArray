package it.antonio.nestedarrays.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.antonio.nestedarrays.ArbitrarilyNestedArraysUtil;


class TestNestedArrays {

	@Test
	public void testBuildNestedArray() 
	{
		Object[] arrayOfNestedArray = null;
		
		final int  depthNestedArrays=3;
		final int  maxLengthArray=5;
		
		arrayOfNestedArray = ArbitrarilyNestedArraysUtil.buildArbitrarilyNestedArrays(arrayOfNestedArray,maxLengthArray,depthNestedArrays);
		
	    assertTrue(arrayOfNestedArray.length>0);
	}
	
	@Test
	public void testFlatNestedArray() 
	{
		Object[] arrayOfNestedArray = null;
		
		final int  depthNestedArrays=3;
		final int  maxLengthArray=5;
		
		arrayOfNestedArray = ArbitrarilyNestedArraysUtil.buildArbitrarilyNestedArrays(arrayOfNestedArray,maxLengthArray,depthNestedArrays);
		
		Integer [] flatArray=ArbitrarilyNestedArraysUtil.flattenNestedArraysOfIntegeres(arrayOfNestedArray);
		
	    assertTrue(flatArray.length>0);
	}
	
	
	@Test
	public void testCountElements() 
	{
		Object[] array = { 1, 2, new Object[]{ 3, 4,  5, 6 }, 7,new Object[]{ 8, 9,  10, 11 }};
		assertTrue(11==ArbitrarilyNestedArraysUtil.countElementsInNestedArray(array));
	}
	
	@Test
	public void testNestedArrayAndFlatNestedArraySameLength() 
	{
		Object[] arrayOfNestedArray = null;
		
		final int  depthNestedArrays=3;
		final int  maxLengthArray=5;
		
		arrayOfNestedArray = ArbitrarilyNestedArraysUtil.buildArbitrarilyNestedArrays(arrayOfNestedArray,maxLengthArray,depthNestedArrays);
		
		Integer [] flatArray=ArbitrarilyNestedArraysUtil.flattenNestedArraysOfIntegeres(arrayOfNestedArray);
		
		int numberOfElements = ArbitrarilyNestedArraysUtil.countElementsInNestedArray(arrayOfNestedArray);
		
	    assertTrue(flatArray.length==numberOfElements);
	}

	
	
}
