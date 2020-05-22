package com.learning.language;

public class Immutability {

	public static void main(String[] args) {
		//Properties of the object can only be set once - preferably during object instantiation
		ImmutableByPrivate obj1 = new ImmutableByPrivate(3664);
		System.out.println(obj1.getId());

	}

}

final class ImmutableByPrivate {
	private int employeeId;
	
	public ImmutableByPrivate(int theId) {
		this.employeeId = theId;
	}
	
	public int getId() {
		int copyOfId = this.employeeId;
		return copyOfId;
	}
}

final class ImmutableByFinal {
	public final String bloodGroup;
	
	public ImmutableByFinal(String bGroup) {
		this.bloodGroup = bGroup;
	}
	
	public String getBloodGroup() {
		String copyOfBloodGroup = this.bloodGroup;
		return copyOfBloodGroup;
	}
}
/*
Common properties
- There must be no setter for the properties
- Properties should be initialized during object instantiation(constructor)
- Immutable class should be made final to prevent it from being sub-classed.
- Immutable members should not be directly returned, in fact make a copy of that and then return it.

Difference
- member variable should be declared the as private
- If it is not declared private then it must be declared as final
*/