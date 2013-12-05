package org.italiangrid.authz.pdp.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.italiangrid.authz.pdp.Effect;
import org.italiangrid.authz.pdp.MatchingRule;
import org.italiangrid.authz.pdp.Rule;



public class RuleImpl extends BaseIdentifiable implements Rule {

	private Effect effect;
	private List<MatchingRule> matchingRules;
	
	public RuleImpl(){
		super(UUID.randomUUID().toString());
		matchingRules = new ArrayList<MatchingRule>();
	}

	@Override
	public Effect getEffect() {
		return effect;
	}

	public void setEffect(Effect effect) {
		this.effect = effect;
	}
	
	@Override
	public String toString() {
		return 
			String.format("Rule [%s] { Effect: %s, MatchingRules: %s }",
			id,
			effect,
			matchingRules);
	}

	@Override
	public List<MatchingRule> getMatchingRules() {
		return matchingRules;
	}
	
	public void addMatchingRule(MatchingRule r){
		matchingRules.add(r);
	}

}