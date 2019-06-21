package github.chorman0773.gac14.claims.claim;

import java.util.Map;
import java.util.TreeMap;

import github.chorman0773.gac14.util.Comparators;
import net.minecraft.util.ResourceLocation;

class PermissionLevelManager {
	static Map<ResourceLocation,IClaimPermissionLevel<?>> levels = new TreeMap<>(Comparators.stringOrder);
}
