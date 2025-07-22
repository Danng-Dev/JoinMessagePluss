package top.archiem.jMP;

import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer.Builder;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;

public class textFormat {
    private final boolean papiEnabled;
    private final MiniMessage miniMessage = MiniMessage.miniMessage();
    private final LegacyComponentSerializer legacy = LegacyComponentSerializer.legacyAmpersand();

    public textFormat(boolean papiEnabled) {
        this.papiEnabled = papiEnabled;
    }

    private String applyPlaceholders(String text, Player player) {
        if (papiEnabled) {
            return PlaceholderAPI.setPlaceholders(player, text);
        } else {
            return text.replace("%player%", player.getName());
        }
    }

    public Component format(String raw, Player player) {
        String withPlaceholders = applyPlaceholders(raw, player);
        Component component = legacy.deserialize(withPlaceholders);
        String miniMessageString = MiniMessage.miniMessage().serialize(component);
        return miniMessage.deserialize(miniMessageString);
    }
}
