package edu.tum.cs.logic;

import java.util.HashMap;

import edu.tum.cs.bayesnets.relational.core.Database;

public class Equality extends UngroundedFormula {
	public String left, right;
	
	public Equality(String left, String right) {
		this.left = left;
		this.right = right;
	}
	
	public String toString() {
		return left + "=" + right;
	}

	@Override
	public void getVariables(Database db, HashMap<String, String> ret) {		
	}

	@Override
	public Formula ground(HashMap<String, String> binding, WorldVariables vars, Database db) throws Exception {
		String a = binding.get(left);
		if(a == null) a = left;
		String b = binding.get(right);
		if(b == null) b = right;
		return TrueFalse.getInstance(a == b);
	}
}