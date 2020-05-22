package com.pattern.behavioral.iterator.concrete;

import com.pattern.behavioral.iterator.Iterable;
import com.pattern.behavioral.iterator.Iterator;

public class NameContainer implements Iterable {
	private String[] names = { "Ram", "Laxman", "Bharat", "Shatrughan" };

	@Override
	public Iterator iterator() {
		return new Iterator() {
			int index;
			@Override
			public boolean hasMore() {
				if (index < names.length) {
					return true;
				}

				return false;
			}

			@Override
			public Object next() {
				if (this.hasMore()) {
					return names[index++];
				}

				return null;
			}
		};
	}
}
