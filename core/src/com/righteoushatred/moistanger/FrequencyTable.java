package com.righteoushatred.moistanger;

import java.util.ArrayList;

/**
 * Stores a set of objects where each object has a relative frequency. 
 * The frequency of each object determines how often it should appear when {@link FrequencyTable#getRandomValue()} is called, relative to all other objects.
 * 
 * @author Episkbo
 *
 * @param <T> The type this frequency table will store.
 */
public class FrequencyTable<T> {

	/**
	 * List of objects stored.
	 */
	private ArrayList<T> values;

	/**
	 * List of frequencies related to the objects stored.
	 */
	private ArrayList<Float> frequencies;

	/**
	 * The sum of all frequencies.
	 */
	private float frequencySum;

	public FrequencyTable() {
		values = new ArrayList<T>();
		frequencies = new ArrayList<Float>();
	}
	
	/**
	 * Returns a random object from this table. The chance of each object occurring depends on its frequency.
	 * The frequency is relative to every other object in this table.
	 * For example: Object A has a frequency of 1, and object B a frequency of 0.5,
	 * then the chance of getting object A is 1/(1 + 0.5) = 67% chance.
	 * 
	 * @return A random object stored in this table.
	 */
	public T getRandomValue() {

		T value = null;

		double r = Math.random()*frequencySum;

		for (int j = 0; j<frequencies.size(); j++) {
			if (r < frequencies.get(j)) {
				value = values.get(j);
				break;
			}

			r -= frequencies.get(j);
		}

		return value;
	}

	/**
	 * Adds an object to this table.
	 * 
	 * @param object The object to add.
	 * @param frequency The frequency of the object.
	 */
	public void add(T object, float frequency) {
		values.add(object);
		frequencies.add(frequency);
		
		frequencySum = 0;
		for (int i = 0; i<frequencies.size(); i++) {
			frequencySum += frequencies.get(i);
		}
	}

	/**
	 * @param object The object to look for.
	 * @return True, if this table contains this object.
	 */
	public boolean contains(T object) {
		return values.contains(object);
	}
	
	/**
	 * @param object The object to check the frequency for.
	 * @return The frequency for the object. Returns 0 if the object doesn't exist.
	 */
	public float getFrequency(T object) {
		int index = values.indexOf(object);
		if (index != -1)
			return frequencies.get(index);
		else
			return 0;
	}
	
	/**
	 * Sets the frequency of a specific object in the table.
	 * Does nothing if the object doesn't exist.
	 * 
	 * @param object The object to set the frequency for.
	 * @param frequency The frequency.
	 */
	public void setFrequency(T object, float frequency) {
		int index = values.indexOf(object);
		
		if (index == -1)
			return;
			
		frequencies.set(index, frequency);
		
		frequencySum = 0;
		for (int i = 0; i<frequencies.size(); i++) {
			frequencySum += frequencies.get(i);
		}
	}
	
	/**
	 * Returns an ArrayList of containing all the objects stored in this table.
	 * 
	 * @return List of all objects stored.
	 */
	public ArrayList<T> getValues() {
		return values;
	}
}
