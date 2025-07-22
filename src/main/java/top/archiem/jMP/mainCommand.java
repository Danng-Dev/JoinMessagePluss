package top.archiem.jMP;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import top.archiem.jMP.JMP;

public class mainCommand {
    public static LiteralCommandNode mainCommand() {
        LiteralCommandNode build = ((LiteralArgumentBuilder) Commands.literal("jmp")
                .then(((LiteralArgumentBuilder) Commands.literal("reload")
                        .requires(sender -> sender.getSender().hasPermission("JMP.cmd")))
                        .executes(ctx -> {
                            CommandSender sender = ((CommandSourceStack) ctx.getSource()).getSender();
                            Entity executor = ((CommandSourceStack) ctx.getSource()).getExecutor();
                            JMP.getPlugin(JMP.class).refreshConfig();
                            return 1;
                        }))).build();
        return build;
    }
}
