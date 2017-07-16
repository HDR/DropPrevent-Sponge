package hdr.dropprevent;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.cause.entity.spawn.EntitySpawnCause;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.item.inventory.DropItemEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

@Plugin(id = "dropprevent", name = "DropPrevent", version = "0.3")
public class DropPrevent {

    @Listener
    public void onItemDrop(DropItemEvent event, @Root EntitySpawnCause src) {
        if (src.getEntity() instanceof Player) {
            Player player = (Player) src.getEntity();
            if(player.hasPermission("dropprevent.restrict")){
                event.setCancelled(true);
                Text dropPreventText = Text.builder("You're not allowed to drop items!").color(TextColors.RED).build();
                player.sendMessage(dropPreventText);
            }
        }
    }

}