package dev.aura.bungeechat.command;

import dev.aura.bungeechat.BungeeChat;
import dev.aura.bungeechat.account.BungeecordAccountManager;
import dev.aura.bungeechat.api.BungeeChatApi;
import dev.aura.bungeechat.api.account.AccountManager;
import dev.aura.bungeechat.api.account.BungeeChatAccount;
import dev.aura.bungeechat.api.enums.Permission;
import dev.aura.bungeechat.message.Message;
import dev.aura.bungeechat.permission.PermissionManager;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;

import java.util.Optional;

@SuppressWarnings("deprecation")
public class BungeeChatCommand extends BaseCommand {
    private final String prefix = ChatColor.BLUE + "Bungee Chat " + ChatColor.DARK_GRAY + "// ";

    public BungeeChatCommand() {
        super("bungeechat");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (args.length != 0) {

            if (args[0].equalsIgnoreCase("reload")
                    && PermissionManager.hasPermission(sender, Permission.BUNGEECHAT_RELOAD)) {

                BungeeChat.getInstance().onDisable();
                BungeeChat.getInstance().onEnable(false);

                sender.sendMessage(prefix + ChatColor.GREEN + "The plugin has been reloaded!");

            } else if (args[0].equalsIgnoreCase("setprefix")
                    && PermissionManager.hasPermission(sender, Permission.BUNGEECHAT_SETPREFIX)) {

                if (args.length < 2) {
                    sender.sendMessage(Message.INCORRECT_USAGE.get(sender, "/bungeechat setprefix <player> [new prefix]"));
                } else {
                    Optional<BungeeChatAccount> targetAccount = AccountManager.getAccount(args[1]);

                    if (!targetAccount.isPresent()) {
                        sender.sendMessage(Message.PLAYER_NOT_FOUND.get());
                    } else {
                        CommandSender target = BungeecordAccountManager.getCommandSender(targetAccount.get()).get();

                        if (args.length < 3) {
                            targetAccount.get().setStoredPrefix(null);
                            sender.sendMessage(Message.PREFIX_REMOVED.get(target));
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();

                            for (int i = 2; i < args.length; i++) {
                                stringBuilder.append(args[i]).append(" ");
                            }

                            targetAccount.get().setStoredPrefix(Optional.of(stringBuilder.toString()));
                            //TODO: Add the %new-perfix% placeholder...
                            sender.sendMessage(Message.PREFIX_SET.get(target));
                        }
                    }
                }
            } else if (args[0].equalsIgnoreCase("setsuffix")
                        && PermissionManager.hasPermission(sender, Permission.BUNGEECHAT_SETSUFFIX)) {

                if (args.length < 2) {
                    sender.sendMessage(Message.INCORRECT_USAGE.get(sender, "/bungeechat setsuffix <player> [new suffix]"));
                } else {
                    Optional<BungeeChatAccount> targetAccount = AccountManager.getAccount(args[1]);

                    if (!targetAccount.isPresent()) {
                        sender.sendMessage(Message.PLAYER_NOT_FOUND.get());
                    } else {
                        CommandSender target = BungeecordAccountManager.getCommandSender(targetAccount.get()).get();

                        if (args.length < 3) {
                            targetAccount.get().setStoredSuffix(null);
                            sender.sendMessage(Message.SUFFIX_REMOVED.get(target));
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();

                            for (int i = 2; i < args.length; i++) {
                                stringBuilder.append(args[i]).append(" ");
                            }

                            targetAccount.get().setStoredSuffix(Optional.of(stringBuilder.toString()));
                            //TODO: Add the %new-suffix% placeholder...
                            sender.sendMessage(Message.SUFFIX_SET.get(target));
                        }
                    }
                }
            }
        }

        checkForUpdates(sender);
        sender.sendMessage(prefix + ChatColor.GRAY + "Coded by " + ChatColor.GOLD + BungeeChatApi.AUTHOR_SHAWN
                + ChatColor.GRAY + " and " + ChatColor.GOLD + BungeeChatApi.AUTHOR_BRAINSTONE + ChatColor.GRAY
                + ", with help from " + ChatColor.GOLD + BungeeChatApi.AUTHOR_RYADA + ChatColor.GRAY + ".");
    }

    private void checkForUpdates(CommandSender sender) {
        if (BungeeChat.getInstance().isLatestVersion()) {
            sender.sendMessage(prefix + ChatColor.GRAY + "Version: " + ChatColor.GREEN + BungeeChatApi.VERSION
                    + " [test] (Build #" + BungeeChatApi.BUILD + ")");
        } else {
            sender.sendMessage(prefix + ChatColor.GRAY + "Version: " + ChatColor.RED + BungeeChatApi.VERSION
                    + " [test] (Build #" + BungeeChatApi.BUILD + ")");
            sender.sendMessage(prefix + ChatColor.GRAY + "Newest Version: " + ChatColor.GREEN
                    + BungeeChat.getInstance().getLatestVersion());
        }
    }
}