package org.italiangrid.authz.pdp.impl;

import java.util.ArrayList;
import java.util.List;

import org.italiangrid.authz.pdp.MatchingRule;

public abstract class CompositeAttributeMatchingRule implements MatchingRule{

	protected List<MatchingRule> rules;
	
	protected CompositeAttributeMatchingRule(){
		rules = new ArrayList<MatchingRule>();
	}
	
	protected List<MatchingRule> getRules(){
		return rules;
	}
	
	protected void addRule(MatchingRule r){
		rules.add(r);
	}
	
}
