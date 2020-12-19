package it.antonio.nestedarrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Antonio
 *
 */

public class ArbitrarilyNestedArraysUtil {

	private static Random random = new Random();
	private static final int MAX_RANDOM_NUMBER = 11;


	/*
	 * Method to build arbitrarily nested arrays
	 */
	/**
	 * @param arrayOfNestedArray the array to fill
	 * @param maxLengthArray the max length of the array to fill
	 * @param depthNestedArrays the max depth of the nested array
	 * @return
	 */
	public static Object[] buildArbitrarilyNestedArrays(Object arrayOfNestedArray, int maxLengthArray, int depthNestedArrays) {

		// check if array is null
		if (arrayOfNestedArray == null || !checkArray(arrayOfNestedArray)) {

			// build first dimension
			int x = random.nextInt(maxLengthArray) + 1;
			arrayOfNestedArray = new Object[x];
		}

		Object[] intArray = (Object[]) arrayOfNestedArray;

		//build second dimension
		for (int i = 0; i < intArray.length; i++) {
			//random for depth nested array
			boolean isNested = random.nextBoolean();
			if (isNested && depthNestedArrays>0) {
				intArray[i] = new Object[random.nextInt(maxLengthArray) + 1][];
				intArray[i] = buildArbitrarilyNestedArrays(intArray[i],maxLengthArray, depthNestedArrays -= 1);
			} else {
				intArray[i] = new Object[] { random.nextInt(MAX_RANDOM_NUMBER) };
			}
		}

		return  intArray;
	}

	/*
	 * Method to flat arbitrarily nested arrays
	 */
	/**
	 * @param inputArray the array of array to flat
	 * @return the array flat
	 */
	public static  Integer[] flattenNestedArraysOfIntegeres(Object[] inputArray) throws IllegalArgumentException {

		List<Integer> flatList =flattenNestedArraysOfIntegeresRecursive(inputArray);

		Integer[] ret=new Integer[0];

		if(flatList != null && !flatList.isEmpty())
		{
			ret=new Integer[flatList.size()];
			flatList.toArray(ret);
		}

		return ret;

	}


	private static  List<Integer> flattenNestedArraysOfIntegeresRecursive(Object[] inputArray) throws IllegalArgumentException {

		if (inputArray == null) return null;

		List<Integer> flatList = new ArrayList<Integer>();

		for (Object element : inputArray) {
			if (element instanceof Integer) {
				flatList.add((Integer) element);
			} 
			else if (element instanceof Object[]) {
				flatList.addAll(flattenNestedArraysOfIntegeresRecursive((Object[])element));
			}
			else {
				throw new IllegalArgumentException("Array is not of Integers or nested arrays of Integers");
			}
		}
		return flatList;
	}


	public static int countElementsInNestedArray(Object[] inputArray)
	{
		int numberOfElements=0;
		
		for (Object element : inputArray) {
			if (element instanceof Integer) {
				numberOfElements+=1;
			} 
			else if (element instanceof Object[]) {
				numberOfElements+=countElementsInNestedArray( (Object[])element);
			}
			else {
				throw new IllegalArgumentException("Array is not of Integers or nested arrays of Integers");
			}
		}
		return numberOfElements;
	}


	private static boolean checkArray(Object obj) {
		return obj.getClass().isArray();
	}

	private ArbitrarilyNestedArraysUtil(){

	}

}
