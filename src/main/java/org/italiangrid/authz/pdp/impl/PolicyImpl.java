package org.italiangrid.authz.pdp.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.italiangrid.authz.pdp.Policy;
import org.italiangrid.authz.pdp.Rule;



public class PolicyImpl implements Policy {

	private String id;
	private List<Rule> rules;
	
	public PolicyImpl(){
		id = UUID.randomUUID().toString();
		rules  = new ArrayList<Rule>();
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public List<Rule> getRules() {
		return rules;
	}

	@Override
	public String toString() {
		return String.format("Policy [%s]: %s", id, rules);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PolicyImpl other = (PolicyImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
