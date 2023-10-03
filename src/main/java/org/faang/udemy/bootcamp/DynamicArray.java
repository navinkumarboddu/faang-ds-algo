package org.faang.udemy.bootcamp;

import java.util.function.BiPredicate;

public class DynamicArray<T> {

	private Object[] data;
	private int size;
	private int initialCapacity;

	public DynamicArray(int initialCapacity) {
		this.initialCapacity = initialCapacity;
		data = new Object[initialCapacity];
	}

	public void set(int index, T value) {
		data[index] = value;
	}

	public Object get(int index) {
		return data[index];
	}

	public void add(T value) {
		if (size == initialCapacity) {
			resize();
		}

		data[size] = value;
		size++;
	}

	public void insert(int index, T value) {
		// check size
		if (size == initialCapacity) {
			resize();
		}

		// copy the elements
		for (int j = size; j > index; j--) {
			data[j] = data[j - 1];
		}

		// insert the data
		data[index] = value;
		size++;
	}

	public void delete(int index) {
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}

		data[size - 1] = null;
		size--;
	}

	private void resize() {
		initialCapacity = initialCapacity * 2;
		Object[] newData = new Object[initialCapacity];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean Contains(T value) {
		boolean exists = false;
		if (size == 1) {
			exists = valueExists.test(0, value);
		} else {
			for (int i = 0; i < size; i++) {
				if (valueExists.test(i, value)) {
					exists = true;
					break; // Exit the loop once a match is found
				}
			}
		}
		return exists;
	}

	BiPredicate<Integer, T> valueExists = (i, v) -> {
		T currentValue = (T) data[i];
		if (currentValue.equals(v)) {
			return true;
		}
		return false;
	};

}