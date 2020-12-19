package it.antonio.main;

import java.util.Arrays;

import it.antonio.nestedarrays.ArbitrarilyNestedArraysUtil;


public class Run {

	public static void main(String[] args)
	{
		Object[] arrayOfNestedArray = null;
		
		final int  depthNestedArrays=3;
		final int  maxLengthArray=5;
		
		arrayOfNestedArray = ArbitrarilyNestedArraysUtil.buildArbitrarilyNestedArrays(arrayOfNestedArray,maxLengthArray,depthNestedArrays);
				
		Integer [] flatArray=ArbitrarilyNestedArraysUtil.flattenNestedArraysOfIntegeres(arrayOfNestedArray);
		
		System.out.println("original: "+ Arrays.deepToString(arrayOfNestedArray));
		System.out.println("flat array: "+ Arrays.deepToString(flatArray));			
		
		System.out.println("length of the flat array: "+flatArray.length);
		System.out.println("elements in the nested arrays "+ ArbitrarilyNestedArraysUtil.countElementsInNestedArray(arrayOfNestedArray));
		
		
	}
}
