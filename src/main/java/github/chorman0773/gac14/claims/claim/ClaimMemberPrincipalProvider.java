package github.chorman0773.gac14.claims.claim;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import github.chorman0773.gac14.worldguard.core.permission.IPrincipal;
import github.chorman0773.gac14.worldguard.core.permission.IPrincipalProvider;
import github.chorman0773.gac14.worldguard.core.permission.WorldguardRegistries;
import net.minecraft.util.ResourceLocation;

public final class ClaimMemberPrincipalProvider implements IPrincipalProvider {

	@Override
	public ResourceLocation getProviderName() {
		// TODO Auto-generated method stub
		return ResourceLocation.makeResourceLocation("gac14:claims/member");
	}

	@Override
	public int getSize(IPrincipal arg0) {
		ClaimMemberPrincipal principal = (ClaimMemberPrincipal)arg0;
		IPrincipalProvider provider = principal.getBase().getProvider();
		return 2+provider.getProviderName().toString().length()+4+provider.getSize(principal.getBase())+2+principal.getPermissionLevel().getName().toString().length();
	}

	@Override
	public IPrincipal load(DataInputStream arg0) throws IOException {
		arg0.readUnsignedShort();
		IPrincipal inner = WorldguardRegistries.readPrincipal(arg0);
		if(!(inner instanceof IClaimOwner))
			throw new IOException("Failed to load Principal. Inner Principal is not a ClaimOwner");
		IClaimOwner owner = (IClaimOwner)inner;
		ResourceLocation levelName = ResourceLocation.makeResourceLocation(arg0.readUTF());
		IClaimPermissionLevel<?> level = PermissionLevelManager.levels.get(levelName);
		return new ClaimMemberPrincipal(this,owner,level);
	}

	@Override
	public IPrincipal resolve(String arg0) {
		return null;
	}

	@Override
	public int store(IPrincipal arg0, DataOutputStream arg1) throws IOException {
		ClaimMemberPrincipal principal = (ClaimMemberPrincipal)arg0;
		IPrincipal root = principal.getBase();
		int sz = getSize(arg0);
		arg1.writeUTF(getProviderName().toString());
		arg1.writeShort(sz);
		root.store(arg1);
		arg1.writeUTF(principal.getPermissionLevel().getName().toString());
		return sz;
	}

}
