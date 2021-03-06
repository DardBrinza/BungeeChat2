package dev.aura.bungeechat.permission;

import lombok.Getter;

/**
 * Enum which contains all the permissions used by BungeeChat.<br>
 * Used for easy access to all the permission nodes.
 */
public enum Permission {
    BUNGEECHAT_RELOAD("admin.reload"),
    BUNGEECHAT_SETPREFIX("admin.setprefix"),
    BUNGEECHAT_SETSUFFIX("admin.setsuffix"),
    BUNGEECHAT_MODULES("admin.modules"),
    CHECK_VERSION("admin.checkversion", false),

    USE_CHAT_COLOR_BLACK("chat.color.black"),
    USE_CHAT_COLOR_DARK_BLUE("chat.color.dark_blue"),
    USE_CHAT_COLOR_DARK_GREEN("chat.color.dark_green"),
    USE_CHAT_COLOR_DARK_AQUA("chat.color.dark_aqua"),
    USE_CHAT_COLOR_DARK_RED("chat.color.dark_red"),
    USE_CHAT_COLOR_DARK_PURPLE("chat.color.dark_pruple"),
    USE_CHAT_COLOR_GOLD("chat.color.gold"),
    USE_CHAT_COLOR_GRAY("chat.color.gray"),
    USE_CHAT_COLOR_DARK_GRAY("chat.color.dark_gray"),
    USE_CHAT_COLOR_BLUE("chat.color.blue"),
    USE_CHAT_COLOR_GREEN("chat.color.green"),
    USE_CHAT_COLOR_AQUA("chat.color.aqua"),
    USE_CHAT_COLOR_RED("chat.color.red"),
    USE_CHAT_COLOR_LIGHT_PURPLE("chat.color.light_purple"),
    USE_CHAT_COLOR_YELLOW("chat.color.yellow"),
    USE_CHAT_COLOR_WHITE("chat.color.white"),

    USE_CHAT_FORMAT_OBFUSCATED("chat.format.obfuscated"),
    USE_CHAT_FORMAT_BOLD("chat.format.bold"),
    USE_CHAT_FORMAT_STRIKETHROUGH("chat.format.strikethrough"),
    USE_CHAT_FORMAT_UNDERLINE("chat.format.underline"),
    USE_CHAT_FORMAT_ITALIC("chat.format.italic"),
    USE_CHAT_FORMAT_RESET("chat.format.reset"),

    USE_TAB_COMPLETE("chat.tabcomplete"),

    BYPASS_ANTI_ADVERTISEMENT("chat.bypass.antiadvertisement"),
    BYPASS_ANTI_DUPLICATE("chat.bypass.antiduplicate"),
    BYPASS_ANTI_SWEAR("chat.bypass.antiswear"),
    BYPASS_TOGGLE_MESSAGE("chat.bypass.toggle"),
    BYPASS_CHAT_LOCK("chat.bypass.chatlock"),
    BYPASS_IGNORE("chat.bypass.ignore"),

    COMMAND_ALERT("command.alert"),
    COMMAND_GLOBAL("command.global"),
    COMMAND_GLOBAL_TOGGLE("command.global.toggle"),
    COMMAND_STAFFCHAT("command.staffchat"),
    COMMAND_STAFFCHAT_VIEW("command.staffchat.view"),
    COMMAND_HELPOP("command.helpop"),
    COMMAND_HELPOP_VIEW("command.helpop.view"),
    COMMAND_IGNORE("command.ignore"),
    COMMAND_MESSAGE("command.msg"),
    COMMAND_MUTE("command.mute"),
    COMMAND_TEMPMUTE("command.tempmute"),
    COMMAND_UNMUTE("command.unmute"),
    COMMAND_TOGGLE_MESSAGE("command.toggle"),
    COMMAND_VANISH("command.vanish"),
    COMMAND_VANISH_VIEW("command.vanish.view"),
    COMMAND_SOCIALSPY("command.socialspy"),
    COMMAND_LOCALSPY("command.localspy"),
    COMMAND_CHAT_LOCK("command.chatlock"),
    COMMAND_CLEAR_CHAT("command.clearchat"),

    MESSAGE_JOIN("message.join"),
    MESSAGE_LEAVE("message.leave"),
    MESSAGE_SWITCH("message.switch"),
    MESSAGE_MOTD("message.motd");

    @Getter
    private final String stringedPermission;
    @Getter
    private final boolean warnOnLackingPermission;

    private Permission(String stringedPermission, boolean warnOnLackingPermission) {
        this.stringedPermission = "bungeechat." + stringedPermission;
        this.warnOnLackingPermission = warnOnLackingPermission;
    }

    private Permission(String stringedPermission) {
        this(stringedPermission, (stringedPermission.startsWith("command.") || stringedPermission.startsWith("admin."))
                && !stringedPermission.endsWith(".view"));
    }
}
