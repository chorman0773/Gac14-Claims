package github.chorman0773.gac14.claims.claim;

import net.minecraft.util.ResourceLocation;

public interface IClaimPermissionLevel<T extends IClaimPermissionLevel<T>> extends Comparable<T> {
	public ResourceLocation getName();
	
	public static void registerPermissionLevel(IClaimPermissionLevel<?> level) {
		if(PermissionLevelManager.levels.putIfAbsent(level.getName(), level)!=null)
			throw new IllegalArgumentException("Failed to register Claim permission level "+level.getName()+", level already exists.");
	}
}