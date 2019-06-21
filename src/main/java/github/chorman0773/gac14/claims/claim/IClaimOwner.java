package github.chorman0773.gac14.claims.claim;

import java.util.List;

import github.chorman0773.gac14.worldguard.core.permission.IPrincipal;
import github.chorman0773.gac14.worldguard.core.permission.PermissionEntry;
import github.chorman0773.gac14.worldguard.core.zone.Zone;
import net.minecraft.util.text.ITextComponent;

public interface IClaimOwner extends IPrincipal {
	
	public IPrincipal getDirectOwner();
	
	public IPrincipal getPrincipalForPermissionLevel(IClaimPermissionLevel<?> level);
	public IRelation hasRelationTo(IClaimOwner owner);
	public IPrincipal getPrincipalFormPermissionLevel(IClaimPermissionLevel<?> level,IRelation relation);
	
	public List<IPrincipal> getPrincipalsAtLevel(IClaimPermissionLevel<?> level);
	public boolean isMember(IPrincipal principal);
	public IClaimPermissionLevel<?> getPermissionLevel(IPrincipal principal);
	
	public List<Zone> getOwnedChunks();
	public List<PermissionEntry> getDefaultPermissions();
	
	public ITextComponent getDisplayName();
	public ITextComponent getDescription();
	
	public int getMaxClaimCount();
}
