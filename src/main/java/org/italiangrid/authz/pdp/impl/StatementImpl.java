package org.italiangrid.authz.pdp.impl;

import java.util.UUID;

import org.italiangrid.authz.pdp.Action;
import org.italiangrid.authz.pdp.Effect;
import org.italiangrid.authz.pdp.MatchRule;
import org.italiangrid.authz.pdp.Principal;
import org.italiangrid.authz.pdp.Resource;
import org.italiangrid.authz.pdp.Statement;



public class StatementImpl extends BaseIdentifiable implements Statement {

	private MatchRule<Principal> principalRule;
	private MatchRule<Resource> resourceRule;
	private MatchRule<Action> actionRule;
	private Effect effect;
	
	public StatementImpl(){
		super(UUID.randomUUID().toString());
	}

	@Override
	public Effect getEffect() {
		return effect;
	}

	@Override
	public MatchRule<Principal> getPrincipalMatchRule() {
		return principalRule;
	}

	@Override
	public MatchRule<Resource> getResourceMatchRule() {
		return resourceRule;
	}

	@Override
	public MatchRule<Action> getActionMatchRule() {
		return actionRule;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	
	public void setPrincipalRule(MatchRule<Principal> principalRule) {
		this.principalRule = principalRule;
	}

	
	public void setResourceRule(MatchRule<Resource> resourceRule) {
		this.resourceRule = resourceRule;
	}

	
	public void setActionRule(MatchRule<Action> actionRule) {
		this.actionRule = actionRule;
	}

	
	public void setEffect(Effect effect) {
		this.effect = effect;
	}
	
	@Override
	public String toString() {
		return 
			String.format("Statement [%s] { Effect: %s, principal: %s, resource: %s, action: %s }",
			id,
			effect,
			principalRule,
			resourceRule,
			actionRule);
	}
}
