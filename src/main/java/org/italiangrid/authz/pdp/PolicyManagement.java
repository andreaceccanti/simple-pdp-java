package org.italiangrid.authz.pdp;

import java.util.List;


public interface PolicyManagement {
	public List<Policy> getPolicies();
	public boolean addPolicy(Policy p);
	public void clearPolicies();
}
