package github.chorman0773.gac14.claims.claim;

import java.util.UUID;

import github.chorman0773.gac14.worldguard.core.permission.IPrincipal;
import github.chorman0773.gac14.worldguard.core.permission.IPrincipalProvider;

public class ClaimMemberPrincipal implements IPrincipal {
	
	private IClaimOwner base;
	private IClaimPermissionLevel<?> permission;
	private ClaimMemberPrincipalProvider provider;
	
	ClaimMemberPrincipal(ClaimMemberPrincipalProvider provider,IClaimOwner base,IClaimPermissionLevel<?> level){
		this.provider = provider;
		this.base = base;
		this.permission = level;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return base.getName()+"\\\\"+permission.getName();
	}

	@Override
	public IPrincipalProvider getProvider() {
		// TODO Auto-generated method stub
		return provider;
	}

	@Override
	public boolean matches(UUID arg0) {
		for(IPrincipal principal:base.getPrincipalsAtLevel(permission))
			if(principal.matches(arg0))
				return true;
		return false;
	}
	
	public IClaimOwner getBase() {
		return base;
	}
	
	public IClaimPermissionLevel<?> getPermissionLevel(){
		return permission;
	}

}
