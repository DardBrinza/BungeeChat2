package dev.aura.bungeechat.module.perms;

import dev.aura.bungeechat.api.hook.HookManager;
import dev.aura.bungeechat.hook.BungeePermsHook;

public class BungeePermsModule extends PermissionPluginModule {
    @Override
    public String getName() {
        return "BungeePerms";
    }

    @Override
    public void onEnable() {
        HookManager.addHook(getName(), new BungeePermsHook());
    }

    @Override
    public void onDisable() {
        HookManager.removeHook(getName());
    }
}
